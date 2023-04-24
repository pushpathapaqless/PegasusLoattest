
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class AddWalkInUsingWebKioskWithNoOptionForWalkInsANDSeveralVisitsForCurrentResource extends Simulation {

  private val httpProtocol = http
    .baseUrl("https://apps-api.staging.peg.qless.com")
    .inferHtmlResources(AllowList(), DenyList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.woff2""", """.*\.(t|o)tf""", """.*\.png""", """.*\.svg""", """.*detectportal\.firefox\.com.*"""))
    .acceptHeader("application/json, text/plain, */*")
    .acceptEncodingHeader("gzip, deflate, br")
    .acceptLanguageHeader("en-US,en;q=0.9")
    .originHeader("https://kiosk.staging.peg.qless.com")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.0.0 Safari/537.36")

  private val headers_0 = Map(
  		"sec-ch-ua" -> """Chromium";v="112", "Google Chrome";v="112", "Not:A-Brand";v="99""",
  		"sec-ch-ua-mobile" -> "?0",
  		"sec-ch-ua-platform" -> "macOS",
  		"sec-fetch-dest" -> "empty",
  		"sec-fetch-mode" -> "cors",
  		"sec-fetch-site" -> "same-site"
  )

  private val headers_1 = Map(
  		"accept" -> "*/*",
  		"access-control-request-headers" -> "content-type",
  		"access-control-request-method" -> "POST",
  		"sec-fetch-dest" -> "empty",
  		"sec-fetch-mode" -> "cors",
  		"sec-fetch-site" -> "same-site"
  )

  private val headers_4 = Map(
  		"content-type" -> "application/json",
  		"sec-ch-ua" -> """Chromium";v="112", "Google Chrome";v="112", "Not:A-Brand";v="99""",
  		"sec-ch-ua-mobile" -> "?0",
  		"sec-ch-ua-platform" -> "macOS",
  		"sec-fetch-dest" -> "empty",
  		"sec-fetch-mode" -> "cors",
  		"sec-fetch-site" -> "same-site"
  )

  private val headers_13 = Map(
  		"accept" -> "*/*",
  		"access-control-request-headers" -> "content-type",
  		"access-control-request-method" -> "PUT",
  		"sec-fetch-dest" -> "empty",
  		"sec-fetch-mode" -> "cors",
  		"sec-fetch-site" -> "same-site"
  )


  private val scn = scenario("AddWalkInUsingWebKioskWithNoOptionForWalkInsANDSeveralVisitsForCurrentResource")
    .exec(
      http("request_0")
        .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/services/tree?organizationStatus=LIVE&serviceStatus=ACTIVE&linkedUserRequired=true&locationStatus=ACTIVE&visibleOnPhysKiosk=true")
        .headers(headers_0)
    )
    .pause(3)
    .exec(
      http("request_1")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/services/SVC804BCF8EE71044F1ADD6A185CEA8D4ADUSEAST1/available-time-slots/list")
        .headers(headers_1)
        .resources(
          http("request_2")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/services/SVC804BCF8EE71044F1ADD6A185CEA8D4ADUSEAST1/first-available-walkin-slot")
            .headers(headers_0),
          http("request_3")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/services/links?serviceIds=SVC804BCF8EE71044F1ADD6A185CEA8D4ADUSEAST1&filterOnlyAvailable=true")
            .headers(headers_0),
          http("request_4")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/services/SVC804BCF8EE71044F1ADD6A185CEA8D4ADUSEAST1/available-time-slots/list")
            .headers(headers_4)
            .body(RawFileBody("addwalkinusingwebkioskwithnooptionforwalkinsandseveralvisitsforcurrentresource/0004_request.json"))
        )
    )
    .pause(5)
    .exec(
      http("request_5")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/appointments/resources/list")
        .headers(headers_1)
        .resources(
          http("request_6")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/appointments/resources/list")
            .headers(headers_4)
            .body(RawFileBody("addwalkinusingwebkioskwithnooptionforwalkinsandseveralvisitsforcurrentresource/0006_request.json"))
        )
    )
    .pause(4)
    .exec(
      http("request_7")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/services/SVC804BCF8EE71044F1ADD6A185CEA8D4ADUSEAST1/available-time-slots/list")
        .headers(headers_1)
        .resources(
          http("request_8")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/services/SVC804BCF8EE71044F1ADD6A185CEA8D4ADUSEAST1/available-time-slots/list")
            .headers(headers_4)
            .body(RawFileBody("addwalkinusingwebkioskwithnooptionforwalkinsandseveralvisitsforcurrentresource/0008_request.json")),
          http("request_9")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/services/SVC804BCF8EE71044F1ADD6A185CEA8D4ADUSEAST1/full-service-field-links/list")
            .headers(headers_0)
        )
    )
    .pause(3)
    .exec(
      http("request_10")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/services/SVC804BCF8EE71044F1ADD6A185CEA8D4ADUSEAST1/resources/appointments")
        .headers(headers_1)
        .resources(
          http("request_11")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/services/SVC804BCF8EE71044F1ADD6A185CEA8D4ADUSEAST1/resources/appointments")
            .headers(headers_4)
            .body(RawFileBody("addwalkinusingwebkioskwithnooptionforwalkinsandseveralvisitsforcurrentresource/0011_request.json")),
          http("request_12")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1")
            .headers(headers_0)
        )
    )
    .pause(13)
    .exec(
      http("request_13")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/appointments/APTE782A3FF040F4930A285C47C0B9D40C6USEAST1/fields")
        .headers(headers_13)
        .resources(
          http("request_14")
            .put("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/appointments/APTE782A3FF040F4930A285C47C0B9D40C6USEAST1/fields")
            .headers(headers_4)
            .body(RawFileBody("addwalkinusingwebkioskwithnooptionforwalkinsandseveralvisitsforcurrentresource/0014_request.json"))
        )
    )
    .pause(1)
    .exec(
      http("request_15")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/resources/appointments/APTE782A3FF040F4930A285C47C0B9D40C6USEAST1")
        .headers(headers_13)
        .resources(
          http("request_16")
            .put("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/resources/appointments/APTE782A3FF040F4930A285C47C0B9D40C6USEAST1")
            .headers(headers_4)
            .body(RawFileBody("addwalkinusingwebkioskwithnooptionforwalkinsandseveralvisitsforcurrentresource/0016_request.json"))
        )
    )

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}
