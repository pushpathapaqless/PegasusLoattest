
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class AddWalkInUsingWebKioskForTodayWithNoOtherWalkInForCurrentResource extends Simulation {

  private val httpProtocol = http
    .baseUrl("https://apps-api.staging.peg.qless.com")
    .inferHtmlResources(AllowList(), DenyList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.woff2""", """.*\.(t|o)tf""", """.*\.png""", """.*\.svg""", """.*detectportal\.firefox\.com.*"""))
    .acceptHeader("application/json, text/plain, */*")
    .acceptEncodingHeader("gzip, deflate, br")
    .acceptLanguageHeader("en-US,en;q=0.9")
    .originHeader("https://kiosk.staging.peg.qless.com")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.0.0 Safari/537.36")

  private val headers_0 = Map(
  		"accept" -> "*/*",
  		"access-control-request-headers" -> "content-type",
  		"access-control-request-method" -> "POST",
  		"sec-fetch-dest" -> "empty",
  		"sec-fetch-mode" -> "cors",
  		"sec-fetch-site" -> "same-site"
  )

  private val headers_1 = Map(
  		"content-type" -> "application/json",
  		"sec-ch-ua" -> """Chromium";v="112", "Google Chrome";v="112", "Not:A-Brand";v="99""",
  		"sec-ch-ua-mobile" -> "?0",
  		"sec-ch-ua-platform" -> "macOS",
  		"sec-fetch-dest" -> "empty",
  		"sec-fetch-mode" -> "cors",
  		"sec-fetch-site" -> "same-site"
  )

  private val headers_4 = Map(
  		"sec-ch-ua" -> """Chromium";v="112", "Google Chrome";v="112", "Not:A-Brand";v="99""",
  		"sec-ch-ua-mobile" -> "?0",
  		"sec-ch-ua-platform" -> "macOS",
  		"sec-fetch-dest" -> "empty",
  		"sec-fetch-mode" -> "cors",
  		"sec-fetch-site" -> "same-site"
  )

  private val headers_14 = Map(
  		"accept" -> "*/*",
  		"access-control-request-headers" -> "content-type",
  		"access-control-request-method" -> "PUT",
  		"sec-fetch-dest" -> "empty",
  		"sec-fetch-mode" -> "cors",
  		"sec-fetch-site" -> "same-site"
  )


  private val scn = scenario("AddWalkInUsingCECForTodayWithNoOtherWalkInForCurrentResource")
    .exec(
      http("request_0")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/services/search")
        .headers(headers_0)
        .resources(
          http("request_1")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/services/search")
            .headers(headers_1)
            .body(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0001_request.json"))
        )
    )
    .pause(12)
    .exec(
      http("request_2")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/search")
        .headers(headers_0)
        .resources(
          http("request_3")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/search")
            .headers(headers_1)
            .body(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0003_request.json")),
          http("request_4")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/services/links?locationIds=LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1,LOC57509129BB8E465A9F072A8514DCE017USEAST1&serviceIds=SVC8A14C0DAE5B14F48BF1225448C2874CCUSEAST1&filterOnlyAvailable=true")
            .headers(headers_4),
          http("request_5")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/services/SVC8A14C0DAE5B14F48BF1225448C2874CCUSEAST1/available-time-slots/list")
            .headers(headers_0),
          http("request_6")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC57509129BB8E465A9F072A8514DCE017USEAST1/services/SVC8A14C0DAE5B14F48BF1225448C2874CCUSEAST1/available-time-slots/list")
            .headers(headers_0),
          http("request_7")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC57509129BB8E465A9F072A8514DCE017USEAST1/services/SVC8A14C0DAE5B14F48BF1225448C2874CCUSEAST1/first-available-walkin-slot")
            .headers(headers_4),
          http("request_8")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/services/SVC8A14C0DAE5B14F48BF1225448C2874CCUSEAST1/first-available-walkin-slot")
            .headers(headers_4),
          http("request_9")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC57509129BB8E465A9F072A8514DCE017USEAST1/services/SVC8A14C0DAE5B14F48BF1225448C2874CCUSEAST1/available-time-slots/list")
            .headers(headers_1)
            .body(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0009_request.json")),
          http("request_10")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/services/SVC8A14C0DAE5B14F48BF1225448C2874CCUSEAST1/available-time-slots/list")
            .headers(headers_1)
            .body(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0010_request.json"))
        )
    )
    .pause(3)
    .exec(
      http("request_11")
        .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/services/SVC8A14C0DAE5B14F48BF1225448C2874CCUSEAST1/full-service-field-links/list")
        .headers(headers_4)
    )
    .pause(1)
    .exec(
      http("request_12")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/services/SVC8A14C0DAE5B14F48BF1225448C2874CCUSEAST1/resources/walkins")
        .headers(headers_0)
        .resources(
          http("request_13")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/services/SVC8A14C0DAE5B14F48BF1225448C2874CCUSEAST1/resources/walkins")
            .headers(headers_1)
            .body(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0013_request.json"))
        )
    )
    .pause(13)
    .exec(
      http("request_14")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/WLKIFC2AB6100E4244FE9D40EB4450506892USEAST1/fields")
        .headers(headers_14)
        .resources(
          http("request_15")
            .put("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/WLKIFC2AB6100E4244FE9D40EB4450506892USEAST1/fields")
            .headers(headers_1)
            .body(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0015_request.json"))
        )
    )
    .pause(2)
    .exec(
      http("request_16")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/resources/walkins/WLKIFC2AB6100E4244FE9D40EB4450506892USEAST1")
        .headers(headers_14)
        .resources(
          http("request_17")
            .put("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/resources/walkins/WLKIFC2AB6100E4244FE9D40EB4450506892USEAST1")
            .headers(headers_1)
            .body(RawFileBody("addwalkinusingwebkioskfortodaywithnootherwalkinforcurrentresource/0017_request.json"))
        )
    )

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}
