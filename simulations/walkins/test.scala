
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class AddWalkInsForToday extends Simulation{

	val httpProtocol = http
	    .baseUrl("https://apps-api.staging.peg.qless.com/api/v1")
	    .acceptHeader("*/*")
	    .contentTypeHeader("application/json")

	val organizationId = "ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1"
	val locationId = "LOC3477C5AAF32E45D59D812F6E7A405DA2USEAST1"
	val serviceId = "SVCDDA21A92812D465D9F11FA2B9218BE03USEAST1"

	val firstName = "McDowell"
	val phoneNumber = "+19196329575"
	val email = "pushpa.thapa@qless.com"

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
							"values": ["${firstName}"]
						},
						{
							"internalName": "Email",
							"values": ["${email}"]
						},
						{
							"internalName": "Phone Number",
							"values": ["${phoneNumber}"]
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


	val scn = scenario("Create WalkIn")
		.exec(createWalkIn)
		.exec(session => {
					val walkInId = session("walkInId").as[String]
					println(s"walkInId API's: $walkInId")
					session
				  })

		.exec(updateWalkInFields)
		.exec(confirmWalkIn)

	setUp(
		scn.inject(
			atOnceUsers(1)
		)
	).protocols(httpProtocol)
}