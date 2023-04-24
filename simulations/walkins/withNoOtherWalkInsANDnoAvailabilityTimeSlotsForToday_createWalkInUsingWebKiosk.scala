
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class AddWalkInUsingWebKioskWithNoAvailabilityIntervalForTodayANDNoWalkInForCurrentResource extends Simulation {

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

  private val headers_2 = Map(
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


  private val scn = scenario("AddWalkInUsingWebKioskWithNoAvailabilityIntervalForTodayANDNoWalkInForCurrentResource")
    .exec(
      http("request_0")
        .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/services/tree?organizationStatus=LIVE&serviceStatus=ACTIVE&linkedUserRequired=true&locationStatus=ACTIVE&visibleOnPhysKiosk=true")
        .headers(headers_0)
    )
    .pause(5)
    .exec(
      http("request_1")
        .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/services/links?serviceIds=SVCEE1B07BFECAE4EEAB94A93197871195FUSEAST1&filterOnlyAvailable=true")
        .headers(headers_0)
    )
    .pause(3)
    .exec(
      http("request_2")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/services/SVCEE1B07BFECAE4EEAB94A93197871195FUSEAST1/available-time-slots/list")
        .headers(headers_2)
        .resources(
          http("request_3")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/services/SVCEE1B07BFECAE4EEAB94A93197871195FUSEAST1/first-available-walkin-slot")
            .headers(headers_0),
          http("request_4")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/services/SVCEE1B07BFECAE4EEAB94A93197871195FUSEAST1/available-time-slots/list")
            .headers(headers_4)
            .body(RawFileBody("addwalkinusingwebkioskwithnoavailabilityintervalfortodayandnowalkinforcurrentresource/0004_request.json"))
        )
    )
    .pause(8)
    .exec(
      http("request_5")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/appointments/resources/list")
        .headers(headers_2)
        .resources(
          http("request_6")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/appointments/resources/list")
            .headers(headers_4)
            .body(RawFileBody("addwalkinusingwebkioskwithnoavailabilityintervalfortodayandnowalkinforcurrentresource/0006_request.json"))
        )
    )
    .pause(4)
    .exec(
      http("request_7")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/services/SVCEE1B07BFECAE4EEAB94A93197871195FUSEAST1/available-time-slots/list")
        .headers(headers_2)
        .resources(
          http("request_8")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/services/SVCEE1B07BFECAE4EEAB94A93197871195FUSEAST1/full-service-field-links/list")
            .headers(headers_0),
          http("request_9")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/services/SVCEE1B07BFECAE4EEAB94A93197871195FUSEAST1/available-time-slots/list")
            .headers(headers_4)
            .body(RawFileBody("addwalkinusingwebkioskwithnoavailabilityintervalfortodayandnowalkinforcurrentresource/0009_request.json"))
        )
    )
    .pause(18)
    .exec(
      http("request_10")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/services/SVCEE1B07BFECAE4EEAB94A93197871195FUSEAST1/resources/appointments")
        .headers(headers_2)
        .resources(
          http("request_11")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/services/SVCEE1B07BFECAE4EEAB94A93197871195FUSEAST1/resources/appointments")
            .headers(headers_4)
            .body(RawFileBody("addwalkinusingwebkioskwithnoavailabilityintervalfortodayandnowalkinforcurrentresource/0011_request.json")),
          http("request_12")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1")
            .headers(headers_0)
        )
    )
    .pause(29)
    .exec(
      http("request_13")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/appointments/APT0B8DE3DB59CB41E6A5BC3A44F577A138USEAST1/fields")
        .headers(headers_13)
        .resources(
          http("request_14")
            .put("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/appointments/APT0B8DE3DB59CB41E6A5BC3A44F577A138USEAST1/fields")
            .headers(headers_4)
            .body(RawFileBody("addwalkinusingwebkioskwithnoavailabilityintervalfortodayandnowalkinforcurrentresource/0014_request.json"))
        )
    )
    .pause(3)
    .exec(
      http("request_15")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/resources/appointments/APT0B8DE3DB59CB41E6A5BC3A44F577A138USEAST1")
        .headers(headers_13)
        .resources(
          http("request_16")
            .put("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/resources/appointments/APT0B8DE3DB59CB41E6A5BC3A44F577A138USEAST1")
            .headers(headers_4)
            .body(RawFileBody("addwalkinusingwebkioskwithnoavailabilityintervalfortodayandnowalkinforcurrentresource/0016_request.json"))
        )
    )

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}
