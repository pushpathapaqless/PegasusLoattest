
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class AddWalkInUsingWebKioskWithNoAvailabilityIntervalForTodayANDWithNoWalkInForCurrentResource extends Simulation {

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

  private val headers_2 = Map(
  		"accept" -> "text/css,*/*;q=0.1",
  		"sec-ch-ua" -> """Chromium";v="112", "Google Chrome";v="112", "Not:A-Brand";v="99""",
  		"sec-ch-ua-mobile" -> "?0",
  		"sec-ch-ua-platform" -> "macOS",
  		"sec-fetch-dest" -> "style",
  		"sec-fetch-mode" -> "no-cors",
  		"sec-fetch-site" -> "same-origin"
  )

  private val headers_3 = Map(
  		"origin" -> "https://kiosk.staging.peg.qless.com",
  		"sec-ch-ua" -> """Chromium";v="112", "Google Chrome";v="112", "Not:A-Brand";v="99""",
  		"sec-ch-ua-mobile" -> "?0",
  		"sec-ch-ua-platform" -> "macOS",
  		"sec-fetch-dest" -> "empty",
  		"sec-fetch-mode" -> "cors",
  		"sec-fetch-site" -> "same-site"
  )

  private val headers_5 = Map(
  		"accept" -> "*/*",
  		"access-control-request-headers" -> "content-type",
  		"access-control-request-method" -> "POST",
  		"origin" -> "https://kiosk.staging.peg.qless.com",
  		"sec-fetch-dest" -> "empty",
  		"sec-fetch-mode" -> "cors",
  		"sec-fetch-site" -> "same-site"
  )

  private val headers_7 = Map(
  		"content-type" -> "application/json",
  		"origin" -> "https://kiosk.staging.peg.qless.com",
  		"sec-ch-ua" -> """Chromium";v="112", "Google Chrome";v="112", "Not:A-Brand";v="99""",
  		"sec-ch-ua-mobile" -> "?0",
  		"sec-ch-ua-platform" -> "macOS",
  		"sec-fetch-dest" -> "empty",
  		"sec-fetch-mode" -> "cors",
  		"sec-fetch-site" -> "same-site"
  )

  private val headers_16 = Map(
  		"accept" -> "*/*",
  		"access-control-request-headers" -> "content-type",
  		"access-control-request-method" -> "PUT",
  		"origin" -> "https://kiosk.staging.peg.qless.com",
  		"sec-fetch-dest" -> "empty",
  		"sec-fetch-mode" -> "cors",
  		"sec-fetch-site" -> "same-site"
  )

  private val uri2 = "https://kiosk.staging.peg.qless.com/assets"

  private val scn = scenario("AddWalkInUsingWebKioskWithNoAvailabilityIntervalForTodayANDWithNoWalkInForCurrentResource")
    .exec(
      http("request_0")
        .get(uri2 + "/index-6c45fd6f.js")
        .headers(headers_0)
        .check(bodyBytes.is(RawFileBody("addwalkinusingwebkioskwithnoavailabilityintervalfortodayandwithnowalkinforcurrentresource/0000_response.bin")))
        .resources(
          http("request_1")
            .get(uri2 + "/ErrorAlert-defa392a.js")
            .headers(headers_0)
            .check(bodyBytes.is(RawFileBody("addwalkinusingwebkioskwithnoavailabilityintervalfortodayandwithnowalkinforcurrentresource/0001_response.bin"))),
          http("request_2")
            .get(uri2 + "/index-6b41fe43.css")
            .headers(headers_2)
            .check(bodyBytes.is(RawFileBody("addwalkinusingwebkioskwithnoavailabilityintervalfortodayandwithnowalkinforcurrentresource/0002_response.bin"))),
          http("request_3")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/services/tree?organizationStatus=LIVE&serviceStatus=ACTIVE&linkedUserRequired=true&locationStatus=ACTIVE&visibleOnPhysKiosk=true")
            .headers(headers_3)
            .check(bodyBytes.is(RawFileBody("addwalkinusingwebkioskwithnoavailabilityintervalfortodayandwithnowalkinforcurrentresource/0003_response.json")))
        )
    )
    .pause(5)
    .exec(
      http("request_4")
        .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/services/links?serviceIds=SVCEE1B07BFECAE4EEAB94A93197871195FUSEAST1&filterOnlyAvailable=true")
        .headers(headers_3)
        .check(bodyBytes.is(RawFileBody("addwalkinusingwebkioskwithnoavailabilityintervalfortodayandwithnowalkinforcurrentresource/0004_response.json")))
    )
    .pause(3)
    .exec(
      http("request_5")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/services/SVCEE1B07BFECAE4EEAB94A93197871195FUSEAST1/available-time-slots/list")
        .headers(headers_5)
        .resources(
          http("request_6")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/services/SVCEE1B07BFECAE4EEAB94A93197871195FUSEAST1/first-available-walkin-slot")
            .headers(headers_3)
            .check(bodyBytes.is(RawFileBody("addwalkinusingwebkioskwithnoavailabilityintervalfortodayandwithnowalkinforcurrentresource/0006_response.json"))),
          http("request_7")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/services/SVCEE1B07BFECAE4EEAB94A93197871195FUSEAST1/available-time-slots/list")
            .headers(headers_7)
            .body(RawFileBody("addwalkinusingwebkioskwithnoavailabilityintervalfortodayandwithnowalkinforcurrentresource/0007_request.json"))
            .check(bodyBytes.is(RawFileBody("addwalkinusingwebkioskwithnoavailabilityintervalfortodayandwithnowalkinforcurrentresource/0007_response.json")))
        )
    )
    .pause(8)
    .exec(
      http("request_8")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/appointments/resources/list")
        .headers(headers_5)
        .resources(
          http("request_9")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/appointments/resources/list")
            .headers(headers_7)
            .body(RawFileBody("addwalkinusingwebkioskwithnoavailabilityintervalfortodayandwithnowalkinforcurrentresource/0009_request.json"))
            .check(bodyBytes.is(RawFileBody("addwalkinusingwebkioskwithnoavailabilityintervalfortodayandwithnowalkinforcurrentresource/0009_response.json")))
        )
    )
    .pause(4)
    .exec(
      http("request_10")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/services/SVCEE1B07BFECAE4EEAB94A93197871195FUSEAST1/available-time-slots/list")
        .headers(headers_5)
        .resources(
          http("request_11")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/services/SVCEE1B07BFECAE4EEAB94A93197871195FUSEAST1/full-service-field-links/list")
            .headers(headers_3)
            .check(bodyBytes.is(RawFileBody("addwalkinusingwebkioskwithnoavailabilityintervalfortodayandwithnowalkinforcurrentresource/0011_response.json"))),
          http("request_12")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/services/SVCEE1B07BFECAE4EEAB94A93197871195FUSEAST1/available-time-slots/list")
            .headers(headers_7)
            .body(RawFileBody("addwalkinusingwebkioskwithnoavailabilityintervalfortodayandwithnowalkinforcurrentresource/0012_request.json"))
            .check(bodyBytes.is(RawFileBody("addwalkinusingwebkioskwithnoavailabilityintervalfortodayandwithnowalkinforcurrentresource/0012_response.json")))
        )
    )
    .pause(18)
    .exec(
      http("request_13")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/services/SVCEE1B07BFECAE4EEAB94A93197871195FUSEAST1/resources/appointments")
        .headers(headers_5)
        .resources(
          http("request_14")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/services/SVCEE1B07BFECAE4EEAB94A93197871195FUSEAST1/resources/appointments")
            .headers(headers_7)
            .body(RawFileBody("addwalkinusingwebkioskwithnoavailabilityintervalfortodayandwithnowalkinforcurrentresource/0014_request.json"))
            .check(bodyBytes.is(RawFileBody("addwalkinusingwebkioskwithnoavailabilityintervalfortodayandwithnowalkinforcurrentresource/0014_response.json"))),
          http("request_15")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1")
            .headers(headers_3)
            .check(bodyBytes.is(RawFileBody("addwalkinusingwebkioskwithnoavailabilityintervalfortodayandwithnowalkinforcurrentresource/0015_response.json")))
        )
    )
    .pause(29)
    .exec(
      http("request_16")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/appointments/APT0B8DE3DB59CB41E6A5BC3A44F577A138USEAST1/fields")
        .headers(headers_16)
        .resources(
          http("request_17")
            .put("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/appointments/APT0B8DE3DB59CB41E6A5BC3A44F577A138USEAST1/fields")
            .headers(headers_7)
            .body(RawFileBody("addwalkinusingwebkioskwithnoavailabilityintervalfortodayandwithnowalkinforcurrentresource/0017_request.json"))
            .check(bodyBytes.is(RawFileBody("addwalkinusingwebkioskwithnoavailabilityintervalfortodayandwithnowalkinforcurrentresource/0017_response.json")))
        )
    )
    .pause(3)
    .exec(
      http("request_18")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/resources/appointments/APT0B8DE3DB59CB41E6A5BC3A44F577A138USEAST1")
        .headers(headers_16)
        .resources(
          http("request_19")
            .put("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/resources/appointments/APT0B8DE3DB59CB41E6A5BC3A44F577A138USEAST1")
            .headers(headers_7)
            .body(RawFileBody("addwalkinusingwebkioskwithnoavailabilityintervalfortodayandwithnowalkinforcurrentresource/0019_request.json"))
            .check(bodyBytes.is(RawFileBody("addwalkinusingwebkioskwithnoavailabilityintervalfortodayandwithnowalkinforcurrentresource/0019_response.json")))
        )
    )

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}
