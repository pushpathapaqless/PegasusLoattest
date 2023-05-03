
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

import com.github.javafaker.Faker


class AddWalkInsFromWebKioskAndCancelVisitUsingWebKiosk extends Simulation{

	val fake = new Faker()

	val httpProtocol = http
	    .baseUrl("https://apps-api.staging.peg.qless.com/api/v1")
	    .acceptHeader("*/*")
	    .contentTypeHeader("application/json")
	    .authorizationHeader("Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxNTUiLCJ1c2VybmFtZSI6InB1c2hwYS50aGFwYUBxbGVzcy5jb20iLCJhY2NvdW50X2lkIjoiQUNDN0FENzQxNTYwQkNCNDc0MUIzQkFCOEY5MkRDMDhEQjRVU0VBU1QxIiwicHJvdmlkZXIiOiJRTEVTUyIsIm9yZ2FuaXphdGlvbl9pZCI6Ik9SR0JDNTJEN0U5MUYzRTQwNTE5NzNDRDlBNkNDNzRENEUxVVNFQVNUMSIsImlhdCI6MTY4MjYwMDU2MSwiZXhwIjoxNjgzNDY0NTYxLCJzYWx0ZXItdXVpZCI6ImFmYjY3ODlmLWY5ZjEtNGJhMy1hZjAzLWY2Zjk0MmI3NTQwNSJ9.8ReizlyNtEFW8147MRv_4FVAli0XAAWQLfjrHHnax-qWd_jsavrDGFC9UTLabLq_q9enijZmhBHCYKXduRNKgA")

	val organizationId = "ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1"
	val locationId = "LOC3477C5AAF32E45D59D812F6E7A405DA2USEAST1"
	val serviceId = "SVCDDA21A92812D465D9F11FA2B9218BE03USEAST1"
	val stationId = "STN7C7782C1446E4E208C0EC1B5D30EFB5CUSEAST1"
	val resourceId = "RES7F831964353B4E688967624081486FA2USEAST1"
	
	val createWalkIn = http("reserveTimeSlot")
				.post(s"/organizations/${organizationId}/locations/${locationId}/services/${serviceId}/resources/walkins")
				.header(HttpHeaderNames.ContentType, "application/json")
				.body(StringBody("""{
						"source" : "WEB_KIOSK"
				}""")).asJson
				.check(status.is(201))
				.check(jsonPath("$.id").saveAs("walkInId"))
				

	val updateWalkInFields = http("updateWalkInFields")
				.put(s"/organizations/${organizationId}/locations/${locationId}/walkins/#{walkInId}/fields")
				.header(HttpHeaderNames.ContentType, "application/json")
				.body(StringBody(s"""{
					"fields" : [  
						{    
							"internalName": "First Name",
							"values": ["#{firstName}"]
						},
						{
							"internalName": "Email",
							"values": ["#{email}"]
						},
						{
							"internalName": "Phone Number",
							"values": ["#{phoneNumber}"]
						}
					]
				}""")).asJson
				.check(status.is(200))

	val confirmWalkIn = http("confirmWalkIn")
				.put(s"/organizations/${organizationId}/locations/${locationId}/resources/walkins/#{walkInId}")
				.header(HttpHeaderNames.ContentType, "application/json")
				.body(StringBody("""{
					"action" : "SCHEDULE",
					"source" : "WEB_KIOSK"
				}""")).asJson
				.check(status.is(200))

	val cancelVisit = http("cancelVisit")
				.put(s"/organizations/${organizationId}/locations/${locationId}/resources/walkins/#{walkInId}")
				.header(HttpHeaderNames.ContentType, "application/json")
				.body(StringBody("""{
					"action" : "CANCEL",
					"note" : "",
					"source" : "WEB_KIOSK"
				}""")).asJson
				.check(status.is(200))				

	val scn = scenario("Create WalkIn & Cancel Visit")
		.exec(session => {
			val firstName = fake.name().firstName()
			val email = fake.internet().emailAddress()
			val phoneList = List("+13029033388", "+14018038822", "+19082138974", "+15043000000", "+17072481109")	
			val phoneNumber = phoneList(scala.util.Random.nextInt(phoneList.length))

			println(s"First Name: $firstName \n Phone Number: $phoneNumber \n Email: $email")
			session.set("firstName", firstName).set("email", email).set("phoneNumber", phoneNumber)
		})

		.exec(createWalkIn)
		.exec(session => {
					val walkInId = session("walkInId").as[String]
					println(s"walkInId API's: $walkInId")
					session
				  })

		.exec(updateWalkInFields)
		.exec(confirmWalkIn)
		.exec(cancelVisit)

	setUp(
		scn.inject(
			atOnceUsers(1)
		)
	).protocols(httpProtocol)
}