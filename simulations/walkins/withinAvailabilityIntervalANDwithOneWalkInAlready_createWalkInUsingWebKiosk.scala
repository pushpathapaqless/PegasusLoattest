
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class AddWalkInUsingWebKioskWithCurrentTimeInAvailabilityIntervalANDWithAtLeastOneWalkInForCurrentResource extends Simulation {

  private val httpProtocol = http
    .baseUrl("https://apps-api.staging.peg.qless.com")
    .inferHtmlResources()
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
  
  private val headers_3 = Map(
  		"content-type" -> "application/json",
  		"sec-ch-ua" -> """Chromium";v="112", "Google Chrome";v="112", "Not:A-Brand";v="99""",
  		"sec-ch-ua-mobile" -> "?0",
  		"sec-ch-ua-platform" -> "macOS",
  		"sec-fetch-dest" -> "empty",
  		"sec-fetch-mode" -> "cors",
  		"sec-fetch-site" -> "same-site"
  )
  
  private val headers_8 = Map(
  		"accept" -> "*/*",
  		"access-control-request-headers" -> "content-type",
  		"access-control-request-method" -> "PUT",
  		"sec-fetch-dest" -> "empty",
  		"sec-fetch-mode" -> "cors",
  		"sec-fetch-site" -> "same-site"
  )


  private val scn = scenario("AddWalkInUsingWebKioskWithCurrentTimeInAvailabilityIntervalANDWithAtLeastOneWalkInForCurrentResource")
    .exec(
      http("request_0")
        .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/services/tree?organizationStatus=LIVE&serviceStatus=ACTIVE&linkedUserRequired=true&locationStatus=ACTIVE&visibleOnPhysKiosk=true")
        .headers(headers_0)
        .check(bodyBytes.is(RawFileBody("addwalkinusingwebkioskwithcurrenttimeinavailabilityintervalandwithatleastonewalkinforcurrentresource/0000_response.json")))
    )
    .pause(3)
    .exec(
      http("request_1")
        .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/services/links?serviceIds=SVCEE1B07BFECAE4EEAB94A93197871195FUSEAST1&filterOnlyAvailable=true")
        .headers(headers_0)
        .check(bodyBytes.is(RawFileBody("addwalkinusingwebkioskwithcurrenttimeinavailabilityintervalandwithatleastonewalkinforcurrentresource/0001_response.json")))
    )
    .pause(1)
    .exec(
      http("request_2")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/services/SVCEE1B07BFECAE4EEAB94A93197871195FUSEAST1/available-time-slots/list")
        .headers(headers_2)
        .resources(
          http("request_3")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/services/SVCEE1B07BFECAE4EEAB94A93197871195FUSEAST1/available-time-slots/list")
            .headers(headers_3)
            .body(RawFileBody("addwalkinusingwebkioskwithcurrenttimeinavailabilityintervalandwithatleastonewalkinforcurrentresource/0003_request.json"))
            .check(bodyBytes.is(RawFileBody("addwalkinusingwebkioskwithcurrenttimeinavailabilityintervalandwithatleastonewalkinforcurrentresource/0003_response.json"))),
          http("request_4")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/services/SVCEE1B07BFECAE4EEAB94A93197871195FUSEAST1/first-available-walkin-slot")
            .headers(headers_0)
            .check(bodyBytes.is(RawFileBody("addwalkinusingwebkioskwithcurrenttimeinavailabilityintervalandwithatleastonewalkinforcurrentresource/0004_response.json")))
        )
    )
    .pause(5)
    .exec(
      http("request_5")
        .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/services/SVCEE1B07BFECAE4EEAB94A93197871195FUSEAST1/full-service-field-links/list")
        .headers(headers_0)
        .check(bodyBytes.is(RawFileBody("addwalkinusingwebkioskwithcurrenttimeinavailabilityintervalandwithatleastonewalkinforcurrentresource/0005_response.json")))
    )
    .pause(2)
    .exec(
      http("request_6")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/services/SVCEE1B07BFECAE4EEAB94A93197871195FUSEAST1/resources/walkins")
        .headers(headers_2)
        .resources(
          http("request_7")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/services/SVCEE1B07BFECAE4EEAB94A93197871195FUSEAST1/resources/walkins")
            .headers(headers_3)
            .body(RawFileBody("addwalkinusingwebkioskwithcurrenttimeinavailabilityintervalandwithatleastonewalkinforcurrentresource/0007_request.json"))
            .check(bodyBytes.is(RawFileBody("addwalkinusingwebkioskwithcurrenttimeinavailabilityintervalandwithatleastonewalkinforcurrentresource/0007_response.json")))
        )
    )
    .pause(24)
    .exec(
      http("request_8")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/walkins/WLKI0716DB12AF424F14BB6B5E04B56A498AUSEAST1/fields")
        .headers(headers_8)
        .resources(
          http("request_9")
            .put("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/walkins/WLKI0716DB12AF424F14BB6B5E04B56A498AUSEAST1/fields")
            .headers(headers_3)
            .body(RawFileBody("addwalkinusingwebkioskwithcurrenttimeinavailabilityintervalandwithatleastonewalkinforcurrentresource/0009_request.json"))
            .check(bodyBytes.is(RawFileBody("addwalkinusingwebkioskwithcurrenttimeinavailabilityintervalandwithatleastonewalkinforcurrentresource/0009_response.json")))
        )
    )
    .pause(1)
    .exec(
      http("request_10")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/resources/walkins/WLKI0716DB12AF424F14BB6B5E04B56A498AUSEAST1")
        .headers(headers_8)
        .resources(
          http("request_11")
            .put("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/resources/walkins/WLKI0716DB12AF424F14BB6B5E04B56A498AUSEAST1")
            .headers(headers_3)
            .body(RawFileBody("addwalkinusingwebkioskwithcurrenttimeinavailabilityintervalandwithatleastonewalkinforcurrentresource/0011_request.json"))
            .check(bodyBytes.is(RawFileBody("addwalkinusingwebkioskwithcurrenttimeinavailabilityintervalandwithatleastonewalkinforcurrentresource/0011_response.json")))
        )
    )

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}
