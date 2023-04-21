
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class AddWalkInUsingWebKioskWithCurrentTimeInAvailabilityIntervalANDWithNoOtherWalkInForCurrentResource extends Simulation {

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
  
  private val headers_4 = Map(
  		"content-type" -> "application/json",
  		"sec-ch-ua" -> """Chromium";v="112", "Google Chrome";v="112", "Not:A-Brand";v="99""",
  		"sec-ch-ua-mobile" -> "?0",
  		"sec-ch-ua-platform" -> "macOS",
  		"sec-fetch-dest" -> "empty",
  		"sec-fetch-mode" -> "cors",
  		"sec-fetch-site" -> "same-site"
  )
  
  private val headers_9 = Map(
  		"accept" -> "*/*",
  		"access-control-request-headers" -> "content-type",
  		"access-control-request-method" -> "PUT",
  		"sec-fetch-dest" -> "empty",
  		"sec-fetch-mode" -> "cors",
  		"sec-fetch-site" -> "same-site"
  )


  private val scn = scenario("AddWalkInUsingWebKioskWithCurrentTimeInAvailabilityIntervalANDWithNoOtherWalkInForCurrentResource")
    .exec(
      http("request_0")
        .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/services/tree?organizationStatus=LIVE&serviceStatus=ACTIVE&linkedUserRequired=true&locationStatus=ACTIVE&visibleOnPhysKiosk=true")
        .headers(headers_0)
        .check(bodyBytes.is(RawFileBody("addwalkinusingwebkioskwithcurrenttimeinavailabilityintervalandwithnootherwalkinforcurrentresource/0000_response.json")))
    )
    .pause(1)
    .exec(
      http("request_1")
        .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/services/links?serviceIds=SVC1BF4EE814B85450DAFDC6A4916856023USEAST1&filterOnlyAvailable=true")
        .headers(headers_0)
        .check(bodyBytes.is(RawFileBody("addwalkinusingwebkioskwithcurrenttimeinavailabilityintervalandwithnootherwalkinforcurrentresource/0001_response.json")))
    )
    .pause(2)
    .exec(
      http("request_2")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/services/SVC1BF4EE814B85450DAFDC6A4916856023USEAST1/available-time-slots/list")
        .headers(headers_2)
        .resources(
          http("request_3")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/services/SVC1BF4EE814B85450DAFDC6A4916856023USEAST1/first-available-walkin-slot")
            .headers(headers_0)
            .check(bodyBytes.is(RawFileBody("addwalkinusingwebkioskwithcurrenttimeinavailabilityintervalandwithnootherwalkinforcurrentresource/0003_response.json"))),
          http("request_4")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/services/SVC1BF4EE814B85450DAFDC6A4916856023USEAST1/available-time-slots/list")
            .headers(headers_4)
            .body(RawFileBody("addwalkinusingwebkioskwithcurrenttimeinavailabilityintervalandwithnootherwalkinforcurrentresource/0004_request.json"))
            .check(bodyBytes.is(RawFileBody("addwalkinusingwebkioskwithcurrenttimeinavailabilityintervalandwithnootherwalkinforcurrentresource/0004_response.json")))
        )
    )
    .pause(3)
    .exec(
      http("request_5")
        .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/services/SVC1BF4EE814B85450DAFDC6A4916856023USEAST1/full-service-field-links/list")
        .headers(headers_0)
        .check(bodyBytes.is(RawFileBody("addwalkinusingwebkioskwithcurrenttimeinavailabilityintervalandwithnootherwalkinforcurrentresource/0005_response.json")))
    )
    .pause(1)
    .exec(
      http("request_6")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/services/SVC1BF4EE814B85450DAFDC6A4916856023USEAST1/resources/walkins")
        .headers(headers_2)
        .resources(
          http("request_7")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/services/SVC1BF4EE814B85450DAFDC6A4916856023USEAST1/resources/walkins")
            .headers(headers_4)
            .body(RawFileBody("addwalkinusingwebkioskwithcurrenttimeinavailabilityintervalandwithnootherwalkinforcurrentresource/0007_request.json"))
            .check(bodyBytes.is(RawFileBody("addwalkinusingwebkioskwithcurrenttimeinavailabilityintervalandwithnootherwalkinforcurrentresource/0007_response.json"))),
          http("request_8")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1")
            .headers(headers_0)
            .check(bodyBytes.is(RawFileBody("addwalkinusingwebkioskwithcurrenttimeinavailabilityintervalandwithnootherwalkinforcurrentresource/0008_response.json")))
        )
    )
    .pause(31)
    .exec(
      http("request_9")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/walkins/WLKI759B8BEABE324E929CE8A1B0908C330DUSEAST1/fields")
        .headers(headers_9)
        .resources(
          http("request_10")
            .put("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/walkins/WLKI759B8BEABE324E929CE8A1B0908C330DUSEAST1/fields")
            .headers(headers_4)
            .body(RawFileBody("addwalkinusingwebkioskwithcurrenttimeinavailabilityintervalandwithnootherwalkinforcurrentresource/0010_request.json"))
            .check(bodyBytes.is(RawFileBody("addwalkinusingwebkioskwithcurrenttimeinavailabilityintervalandwithnootherwalkinforcurrentresource/0010_response.json")))
        )
    )
    .pause(1)
    .exec(
      http("request_11")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/resources/walkins/WLKI759B8BEABE324E929CE8A1B0908C330DUSEAST1")
        .headers(headers_9)
        .resources(
          http("request_12")
            .put("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/resources/walkins/WLKI759B8BEABE324E929CE8A1B0908C330DUSEAST1")
            .headers(headers_4)
            .body(RawFileBody("addwalkinusingwebkioskwithcurrenttimeinavailabilityintervalandwithnootherwalkinforcurrentresource/0012_request.json"))
            .check(bodyBytes.is(RawFileBody("addwalkinusingwebkioskwithcurrenttimeinavailabilityintervalandwithnootherwalkinforcurrentresource/0012_response.json")))
        )
    )

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}
