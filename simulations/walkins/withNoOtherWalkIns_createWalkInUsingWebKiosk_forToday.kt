import java.time.Duration

import io.gatling.javaapi.core.*
import io.gatling.javaapi.http.*
import io.gatling.javaapi.jdbc.*

import io.gatling.javaapi.core.CoreDsl.*
import io.gatling.javaapi.http.HttpDsl.*
import io.gatling.javaapi.jdbc.JdbcDsl.*

class AddWalkInWebKioskforTodayWithNoOtherWalkInAlready : Simulation() {

  private val httpProtocol = http
    .baseUrl("https://apps-api.staging.peg.qless.com")
    .inferHtmlResources()
    .acceptHeader("application/json, text/plain, */*")
    .acceptEncodingHeader("gzip, deflate, br")
    .acceptLanguageHeader("en-US,en;q=0.9")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.0.0 Safari/537.36")

  private val headers_0 = mapOf(
    "accept" to "*/*",
    "origin" to "https://kiosk.staging.peg.qless.com",
    "sec-ch-ua" to """Chromium";v="112", "Google Chrome";v="112", "Not:A-Brand";v="99""",
    "sec-ch-ua-mobile" to "?0",
    "sec-ch-ua-platform" to "macOS",
    "sec-fetch-dest" to "script",
    "sec-fetch-mode" to "cors",
    "sec-fetch-site" to "same-origin"
  )

  private val headers_1 = mapOf(
    "accept" to "text/css,*/*;q=0.1",
    "sec-ch-ua" to """Chromium";v="112", "Google Chrome";v="112", "Not:A-Brand";v="99""",
    "sec-ch-ua-mobile" to "?0",
    "sec-ch-ua-platform" to "macOS",
    "sec-fetch-dest" to "style",
    "sec-fetch-mode" to "no-cors",
    "sec-fetch-site" to "same-origin"
  )

  private val headers_3 = mapOf(
    "accept" to "*/*",
    "access-control-request-headers" to "content-type",
    "access-control-request-method" to "POST",
    "origin" to "https://kiosk.staging.peg.qless.com",
    "sec-fetch-dest" to "empty",
    "sec-fetch-mode" to "cors",
    "sec-fetch-site" to "same-site"
  )

  private val headers_4 = mapOf(
    "content-type" to "application/json",
    "origin" to "https://kiosk.staging.peg.qless.com",
    "sec-ch-ua" to """Chromium";v="112", "Google Chrome";v="112", "Not:A-Brand";v="99""",
    "sec-ch-ua-mobile" to "?0",
    "sec-ch-ua-platform" to "macOS",
    "sec-fetch-dest" to "empty",
    "sec-fetch-mode" to "cors",
    "sec-fetch-site" to "same-site"
  )

  private val headers_7 = mapOf(
    "origin" to "https://kiosk.staging.peg.qless.com",
    "sec-ch-ua" to """Chromium";v="112", "Google Chrome";v="112", "Not:A-Brand";v="99""",
    "sec-ch-ua-mobile" to "?0",
    "sec-ch-ua-platform" to "macOS",
    "sec-fetch-dest" to "empty",
    "sec-fetch-mode" to "cors",
    "sec-fetch-site" to "same-site"
  )

  private val headers_17 = mapOf(
    "accept" to "*/*",
    "access-control-request-headers" to "content-type",
    "access-control-request-method" to "PUT",
    "origin" to "https://kiosk.staging.peg.qless.com",
    "sec-fetch-dest" to "empty",
    "sec-fetch-mode" to "cors",
    "sec-fetch-site" to "same-site"
  )

  private val uri2 = "https://kiosk.staging.peg.qless.com/assets"

  private val scn = scenario("AddWalkInWebKioskforTodayWithNoOtherWalkInAlready")
    .exec(
      http("request_0")
        .get(uri2 + "/ErrorAlert-defa392a.js")
        .headers(headers_0)
        .resources(
          http("request_1")
            .get(uri2 + "/index-6b41fe43.css")
            .headers(headers_1),
          http("request_2")
            .get(uri2 + "/index-6c45fd6f.js")
            .headers(headers_0),
          http("request_3")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/services/search")
            .headers(headers_3),
          http("request_4")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/services/search")
            .headers(headers_4)
            .body(RawFileBody("addwalkinwebkioskfortodaywithnootherwalkinalready/0004_request.json"))
        )
    )
    .pause(12)
    .exec(
      http("request_5")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/search")
        .headers(headers_3)
        .resources(
          http("request_6")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/search")
            .headers(headers_4)
            .body(RawFileBody("addwalkinwebkioskfortodaywithnootherwalkinalready/0006_request.json")),
          http("request_7")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/services/links?locationIds=LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1,LOC57509129BB8E465A9F072A8514DCE017USEAST1&serviceIds=SVC8A14C0DAE5B14F48BF1225448C2874CCUSEAST1&filterOnlyAvailable=true")
            .headers(headers_7),
          http("request_8")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/services/SVC8A14C0DAE5B14F48BF1225448C2874CCUSEAST1/available-time-slots/list")
            .headers(headers_3),
          http("request_9")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC57509129BB8E465A9F072A8514DCE017USEAST1/services/SVC8A14C0DAE5B14F48BF1225448C2874CCUSEAST1/available-time-slots/list")
            .headers(headers_3),
          http("request_10")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC57509129BB8E465A9F072A8514DCE017USEAST1/services/SVC8A14C0DAE5B14F48BF1225448C2874CCUSEAST1/first-available-walkin-slot")
            .headers(headers_7),
          http("request_11")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/services/SVC8A14C0DAE5B14F48BF1225448C2874CCUSEAST1/first-available-walkin-slot")
            .headers(headers_7),
          http("request_12")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC57509129BB8E465A9F072A8514DCE017USEAST1/services/SVC8A14C0DAE5B14F48BF1225448C2874CCUSEAST1/available-time-slots/list")
            .headers(headers_4)
            .body(RawFileBody("addwalkinwebkioskfortodaywithnootherwalkinalready/0012_request.json")),
          http("request_13")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/services/SVC8A14C0DAE5B14F48BF1225448C2874CCUSEAST1/available-time-slots/list")
            .headers(headers_4)
            .body(RawFileBody("addwalkinwebkioskfortodaywithnootherwalkinalready/0013_request.json"))
        )
    )
    .pause(3)
    .exec(
      http("request_14")
        .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/services/SVC8A14C0DAE5B14F48BF1225448C2874CCUSEAST1/full-service-field-links/list")
        .headers(headers_7)
    )
    .pause(1)
    .exec(
      http("request_15")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/services/SVC8A14C0DAE5B14F48BF1225448C2874CCUSEAST1/resources/walkins")
        .headers(headers_3)
        .resources(
          http("request_16")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/services/SVC8A14C0DAE5B14F48BF1225448C2874CCUSEAST1/resources/walkins")
            .headers(headers_4)
            .body(RawFileBody("addwalkinwebkioskfortodaywithnootherwalkinalready/0016_request.json"))
        )
    )
    .pause(13)
    .exec(
      http("request_17")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/WLKIFC2AB6100E4244FE9D40EB4450506892USEAST1/fields")
        .headers(headers_17)
        .resources(
          http("request_18")
            .put("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/WLKIFC2AB6100E4244FE9D40EB4450506892USEAST1/fields")
            .headers(headers_4)
            .body(RawFileBody("addwalkinwebkioskfortodaywithnootherwalkinalready/0018_request.json"))
        )
    )
    .pause(2)
    .exec(
      http("request_19")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/resources/walkins/WLKIFC2AB6100E4244FE9D40EB4450506892USEAST1")
        .headers(headers_17)
        .resources(
          http("request_20")
            .put("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/resources/walkins/WLKIFC2AB6100E4244FE9D40EB4450506892USEAST1")
            .headers(headers_4)
            .body(RawFileBody("addwalkinwebkioskfortodaywithnootherwalkinalready/0020_request.json"))
        )
    )

  init {
	  setUp(
	    scn.injectOpen(
	        atOnceUsers(1) //for 1 user at a time
	    )).protocols(httpProtocol)
  }
}
