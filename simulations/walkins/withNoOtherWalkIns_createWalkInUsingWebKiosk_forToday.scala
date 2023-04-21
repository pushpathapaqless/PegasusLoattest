
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class AddWalkInUsingWebKioskForTodayWithNoOtherWalkInForCurrentResource extends Simulation {

  private val httpProtocol = http
    .baseUrl("https://apps-api.staging.peg.qless.com")
    .inferHtmlResources()
    .acceptHeader("application/json, text/plain, */*")
    .acceptEncodingHeader("gzip, deflate, br")
    .acceptLanguageHeader("en-US,en;q=0.9")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.0.0 Safari/537.36")
  
  private val headers_0 = Map(
  		"accept" -> "*/*",
  		"origin" -> "https://kiosk.staging.peg.qless.com",
  		"sec-ch-ua" -> """Chromium";v="112", "Google Chrome";v="112", "Not:A-Brand";v="99""",
  		"sec-ch-ua-mobile" -> "?0",
  		"sec-ch-ua-platform" -> "macOS",
  		"sec-fetch-dest" -> "script",
  		"sec-fetch-mode" -> "cors",
  		"sec-fetch-site" -> "same-origin"
  )
  
  private val headers_1 = Map(
  		"accept" -> "text/css,*/*;q=0.1",
  		"sec-ch-ua" -> """Chromium";v="112", "Google Chrome";v="112", "Not:A-Brand";v="99""",
  		"sec-ch-ua-mobile" -> "?0",
  		"sec-ch-ua-platform" -> "macOS",
  		"sec-fetch-dest" -> "style",
  		"sec-fetch-mode" -> "no-cors",
  		"sec-fetch-site" -> "same-origin"
  )
  
  private val headers_3 = Map(
  		"accept" -> "*/*",
  		"access-control-request-headers" -> "content-type",
  		"access-control-request-method" -> "POST",
  		"origin" -> "https://kiosk.staging.peg.qless.com",
  		"sec-fetch-dest" -> "empty",
  		"sec-fetch-mode" -> "cors",
  		"sec-fetch-site" -> "same-site"
  )
  
  private val headers_4 = Map(
  		"content-type" -> "application/json",
  		"origin" -> "https://kiosk.staging.peg.qless.com",
  		"sec-ch-ua" -> """Chromium";v="112", "Google Chrome";v="112", "Not:A-Brand";v="99""",
  		"sec-ch-ua-mobile" -> "?0",
  		"sec-ch-ua-platform" -> "macOS",
  		"sec-fetch-dest" -> "empty",
  		"sec-fetch-mode" -> "cors",
  		"sec-fetch-site" -> "same-site"
  )
  
  private val headers_7 = Map(
  		"origin" -> "https://kiosk.staging.peg.qless.com",
  		"sec-ch-ua" -> """Chromium";v="112", "Google Chrome";v="112", "Not:A-Brand";v="99""",
  		"sec-ch-ua-mobile" -> "?0",
  		"sec-ch-ua-platform" -> "macOS",
  		"sec-fetch-dest" -> "empty",
  		"sec-fetch-mode" -> "cors",
  		"sec-fetch-site" -> "same-site"
  )
  
  private val headers_17 = Map(
  		"accept" -> "*/*",
  		"access-control-request-headers" -> "content-type",
  		"access-control-request-method" -> "PUT",
  		"origin" -> "https://kiosk.staging.peg.qless.com",
  		"sec-fetch-dest" -> "empty",
  		"sec-fetch-mode" -> "cors",
  		"sec-fetch-site" -> "same-site"
  )
  
  private val uri2 = "https://kiosk.staging.peg.qless.com/assets"

  private val scn = scenario("AddWalkInUsingWebKioskForTodayWithNoOtherWalkInForCurrentResource")
    .exec(
      http("request_0")
        .get(uri2 + "/ErrorAlert-defa392a.js")
        .headers(headers_0)
        .check(bodyBytes.is(RawFileBody("addwalkinusingwebkioskfortodaywithnootherwalkinforcurrentresource/0000_response.bin")))
        .resources(
          http("request_1")
            .get(uri2 + "/index-6b41fe43.css")
            .headers(headers_1)
            .check(bodyBytes.is(RawFileBody("addwalkinusingwebkioskfortodaywithnootherwalkinforcurrentresource/0001_response.bin"))),
          http("request_2")
            .get(uri2 + "/index-6c45fd6f.js")
            .headers(headers_0)
            .check(bodyBytes.is(RawFileBody("addwalkinusingwebkioskfortodaywithnootherwalkinforcurrentresource/0002_response.bin"))),
          http("request_3")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/services/search")
            .headers(headers_3),
          http("request_4")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/services/search")
            .headers(headers_4)
            .body(RawFileBody("addwalkinusingwebkioskfortodaywithnootherwalkinforcurrentresource/0004_request.json"))
            .check(bodyBytes.is(RawFileBody("addwalkinusingwebkioskfortodaywithnootherwalkinforcurrentresource/0004_response.json")))
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
            .body(RawFileBody("addwalkinusingwebkioskfortodaywithnootherwalkinforcurrentresource/0006_request.json"))
            .check(bodyBytes.is(RawFileBody("addwalkinusingwebkioskfortodaywithnootherwalkinforcurrentresource/0006_response.json"))),
          http("request_7")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/services/links?locationIds=LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1,LOC57509129BB8E465A9F072A8514DCE017USEAST1&serviceIds=SVC8A14C0DAE5B14F48BF1225448C2874CCUSEAST1&filterOnlyAvailable=true")
            .headers(headers_7)
            .check(bodyBytes.is(RawFileBody("addwalkinusingwebkioskfortodaywithnootherwalkinforcurrentresource/0007_response.json"))),
          http("request_8")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/services/SVC8A14C0DAE5B14F48BF1225448C2874CCUSEAST1/available-time-slots/list")
            .headers(headers_3),
          http("request_9")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC57509129BB8E465A9F072A8514DCE017USEAST1/services/SVC8A14C0DAE5B14F48BF1225448C2874CCUSEAST1/available-time-slots/list")
            .headers(headers_3),
          http("request_10")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC57509129BB8E465A9F072A8514DCE017USEAST1/services/SVC8A14C0DAE5B14F48BF1225448C2874CCUSEAST1/first-available-walkin-slot")
            .headers(headers_7)
            .check(bodyBytes.is(RawFileBody("addwalkinusingwebkioskfortodaywithnootherwalkinforcurrentresource/0010_response.json"))),
          http("request_11")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/services/SVC8A14C0DAE5B14F48BF1225448C2874CCUSEAST1/first-available-walkin-slot")
            .headers(headers_7)
            .check(bodyBytes.is(RawFileBody("addwalkinusingwebkioskfortodaywithnootherwalkinforcurrentresource/0011_response.json"))),
          http("request_12")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC57509129BB8E465A9F072A8514DCE017USEAST1/services/SVC8A14C0DAE5B14F48BF1225448C2874CCUSEAST1/available-time-slots/list")
            .headers(headers_4)
            .body(RawFileBody("addwalkinusingwebkioskfortodaywithnootherwalkinforcurrentresource/0012_request.json"))
            .check(bodyBytes.is(RawFileBody("addwalkinusingwebkioskfortodaywithnootherwalkinforcurrentresource/0012_response.json"))),
          http("request_13")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/services/SVC8A14C0DAE5B14F48BF1225448C2874CCUSEAST1/available-time-slots/list")
            .headers(headers_4)
            .body(RawFileBody("addwalkinusingwebkioskfortodaywithnootherwalkinforcurrentresource/0013_request.json"))
            .check(bodyBytes.is(RawFileBody("addwalkinusingwebkioskfortodaywithnootherwalkinforcurrentresource/0013_response.json")))
        )
    )
    .pause(3)
    .exec(
      http("request_14")
        .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/services/SVC8A14C0DAE5B14F48BF1225448C2874CCUSEAST1/full-service-field-links/list")
        .headers(headers_7)
        .check(bodyBytes.is(RawFileBody("addwalkinusingwebkioskfortodaywithnootherwalkinforcurrentresource/0014_response.json")))
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
            .body(RawFileBody("addwalkinusingwebkioskfortodaywithnootherwalkinforcurrentresource/0016_request.json"))
            .check(bodyBytes.is(RawFileBody("addwalkinusingwebkioskfortodaywithnootherwalkinforcurrentresource/0016_response.json")))
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
            .body(RawFileBody("addwalkinusingwebkioskfortodaywithnootherwalkinforcurrentresource/0018_request.json"))
            .check(bodyBytes.is(RawFileBody("addwalkinusingwebkioskfortodaywithnootherwalkinforcurrentresource/0018_response.json")))
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
            .body(RawFileBody("addwalkinusingwebkioskfortodaywithnootherwalkinforcurrentresource/0020_request.json"))
            .check(bodyBytes.is(RawFileBody("addwalkinusingwebkioskfortodaywithnootherwalkinforcurrentresource/0020_response.json")))
        )
    )

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}
