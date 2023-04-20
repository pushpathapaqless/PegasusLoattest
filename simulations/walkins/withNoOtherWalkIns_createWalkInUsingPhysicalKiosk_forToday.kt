import java.time.Duration

import io.gatling.javaapi.core.*
import io.gatling.javaapi.http.*
import io.gatling.javaapi.jdbc.*

import io.gatling.javaapi.core.CoreDsl.*
import io.gatling.javaapi.http.HttpDsl.*
import io.gatling.javaapi.jdbc.JdbcDsl.*

class AddWalkInPhysicalKioskforTodayWithNoOtherWalkInAlready : Simulation() {

  private val httpProtocol = http
    .baseUrl("https://apps-api.staging.peg.qless.com")
    .inferHtmlResources()
    .acceptHeader("application/json, text/plain, */*")
    .acceptEncodingHeader("gzip, deflate, br")
    .acceptLanguageHeader("en-US,en;q=0.9")
    .originHeader("https://kiosk.staging.peg.qless.com")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.0.0 Safari/537.36")

  private val headers_0 = mapOf(
    "sec-ch-ua" to """Chromium";v="112", "Google Chrome";v="112", "Not:A-Brand";v="99""",
    "sec-ch-ua-mobile" to "?0",
    "sec-ch-ua-platform" to "macOS",
    "sec-fetch-dest" to "empty",
    "sec-fetch-mode" to "cors",
    "sec-fetch-site" to "same-site"
  )

  private val headers_1 = mapOf(
    "accept" to "*/*",
    "access-control-request-headers" to "content-type",
    "access-control-request-method" to "POST",
    "sec-fetch-dest" to "empty",
    "sec-fetch-mode" to "cors",
    "sec-fetch-site" to "same-site"
  )

  private val headers_4 = mapOf(
    "content-type" to "application/json",
    "sec-ch-ua" to """Chromium";v="112", "Google Chrome";v="112", "Not:A-Brand";v="99""",
    "sec-ch-ua-mobile" to "?0",
    "sec-ch-ua-platform" to "macOS",
    "sec-fetch-dest" to "empty",
    "sec-fetch-mode" to "cors",
    "sec-fetch-site" to "same-site"
  )

  private val headers_9 = mapOf(
    "accept" to "*/*",
    "access-control-request-headers" to "content-type",
    "access-control-request-method" to "PUT",
    "sec-fetch-dest" to "empty",
    "sec-fetch-mode" to "cors",
    "sec-fetch-site" to "same-site"
  )


  private val scn = scenario("AddWalkInPhysicalKioskforTodayWithNoOtherWalkInAlready")
    .exec(
      http("request_0")
        .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/services/tree?organizationStatus=LIVE&serviceStatus=ACTIVE&linkedUserRequired=true&locationStatus=ACTIVE&visibleOnPhysKiosk=true")
        .headers(headers_0)
    )
    .pause(5)
    .exec(
      http("request_1")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/services/SVC1BF4EE814B85450DAFDC6A4916856023USEAST1/available-time-slots/list")
        .headers(headers_1)
        .resources(
          http("request_2")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/services/links?serviceIds=SVC1BF4EE814B85450DAFDC6A4916856023USEAST1&filterOnlyAvailable=true")
            .headers(headers_0),
          http("request_3")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/services/SVC1BF4EE814B85450DAFDC6A4916856023USEAST1/first-available-walkin-slot")
            .headers(headers_0),
          http("request_4")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/services/SVC1BF4EE814B85450DAFDC6A4916856023USEAST1/available-time-slots/list")
            .headers(headers_4)
            .body(RawFileBody("addwalkinphysicalkioskfortodaywithnootherwalkinalready/0004_request.json"))
        )
    )
    .pause(3)
    .exec(
      http("request_5")
        .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/services/SVC1BF4EE814B85450DAFDC6A4916856023USEAST1/full-service-field-links/list")
        .headers(headers_0)
    )
    .pause(1)
    .exec(
      http("request_6")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/services/SVC1BF4EE814B85450DAFDC6A4916856023USEAST1/resources/walkins")
        .headers(headers_1)
        .resources(
          http("request_7")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/services/SVC1BF4EE814B85450DAFDC6A4916856023USEAST1/resources/walkins")
            .headers(headers_4)
            .body(RawFileBody("addwalkinphysicalkioskfortodaywithnootherwalkinalready/0007_request.json")),
          http("request_8")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1")
            .headers(headers_0)
        )
    )
    .pause(14)
    .exec(
      http("request_9")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/walkins/WLKI09B0BF88ED0745D1B78FF72716C01F73USEAST1/fields")
        .headers(headers_9)
        .resources(
          http("request_10")
            .put("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/walkins/WLKI09B0BF88ED0745D1B78FF72716C01F73USEAST1/fields")
            .headers(headers_4)
            .body(RawFileBody("addwalkinphysicalkioskfortodaywithnootherwalkinalready/0010_request.dat"))
            .check(status().shouldBe(400))
        )
    )
    .pause(9)
    .exec(
      http("request_11")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/walkins/WLKI09B0BF88ED0745D1B78FF72716C01F73USEAST1/fields")
        .headers(headers_9)
        .resources(
          http("request_12")
            .put("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/walkins/WLKI09B0BF88ED0745D1B78FF72716C01F73USEAST1/fields")
            .headers(headers_4)
            .body(RawFileBody("addwalkinphysicalkioskfortodaywithnootherwalkinalready/0012_request.json"))
        )
    )
    .pause(3)
    .exec(
      http("request_13")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/resources/walkins/WLKI09B0BF88ED0745D1B78FF72716C01F73USEAST1")
        .headers(headers_9)
        .resources(
          http("request_14")
            .put("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/resources/walkins/WLKI09B0BF88ED0745D1B78FF72716C01F73USEAST1")
            .headers(headers_4)
            .body(RawFileBody("addwalkinphysicalkioskfortodaywithnootherwalkinalready/0014_request.json"))
        )
    )

  init {
	  setUp(
	    scn.injectOpen(
	        atOnceUsers(1)
	    )).protocols(httpProtocol)
  }
}
