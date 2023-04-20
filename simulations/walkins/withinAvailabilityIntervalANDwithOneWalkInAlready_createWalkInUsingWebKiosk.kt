import java.time.Duration

import io.gatling.javaapi.core.*
import io.gatling.javaapi.http.*
import io.gatling.javaapi.jdbc.*

import io.gatling.javaapi.core.CoreDsl.*
import io.gatling.javaapi.http.HttpDsl.*
import io.gatling.javaapi.jdbc.JdbcDsl.*

class AddWalkInUsingWebKioskInAvailabilityTimeIntervalWithOneWalkInAlready : Simulation() {

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

  private val headers_2 = mapOf(
    "accept" to "*/*",
    "access-control-request-headers" to "content-type",
    "access-control-request-method" to "POST",
    "sec-fetch-dest" to "empty",
    "sec-fetch-mode" to "cors",
    "sec-fetch-site" to "same-site"
  )

  private val headers_3 = mapOf(
    "content-type" to "application/json",
    "sec-ch-ua" to """Chromium";v="112", "Google Chrome";v="112", "Not:A-Brand";v="99""",
    "sec-ch-ua-mobile" to "?0",
    "sec-ch-ua-platform" to "macOS",
    "sec-fetch-dest" to "empty",
    "sec-fetch-mode" to "cors",
    "sec-fetch-site" to "same-site"
  )

  private val headers_8 = mapOf(
    "accept" to "*/*",
    "access-control-request-headers" to "content-type",
    "access-control-request-method" to "PUT",
    "sec-fetch-dest" to "empty",
    "sec-fetch-mode" to "cors",
    "sec-fetch-site" to "same-site"
  )


  private val scn = scenario("AddWalkInUsingWebKioskInAvailabilityTimeIntervalWithOneWalkInAlready")
    .exec(
      http("request_0")
        .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/services/tree?organizationStatus=LIVE&serviceStatus=ACTIVE&linkedUserRequired=true&locationStatus=ACTIVE&visibleOnPhysKiosk=true")
        .headers(headers_0)
    )
    .pause(3)
    .exec(
      http("request_1")
        .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/services/links?serviceIds=SVCEE1B07BFECAE4EEAB94A93197871195FUSEAST1&filterOnlyAvailable=true")
        .headers(headers_0)
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
            .body(RawFileBody("addwalkinusingwebkioskinavailabilitytimeintervalwithonewalkinalready/0003_request.json")),
          http("request_4")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/services/SVCEE1B07BFECAE4EEAB94A93197871195FUSEAST1/first-available-walkin-slot")
            .headers(headers_0)
        )
    )
    .pause(5)
    .exec(
      http("request_5")
        .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/services/SVCEE1B07BFECAE4EEAB94A93197871195FUSEAST1/full-service-field-links/list")
        .headers(headers_0)
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
            .body(RawFileBody("addwalkinusingwebkioskinavailabilitytimeintervalwithonewalkinalready/0007_request.json"))
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
            .body(RawFileBody("addwalkinusingwebkioskinavailabilitytimeintervalwithonewalkinalready/0009_request.json"))
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
            .body(RawFileBody("addwalkinusingwebkioskinavailabilitytimeintervalwithonewalkinalready/0011_request.json"))
        )
    )

  init {
	  setUp(
	    scn.injectOpen(
	        atOnceUsers(1)
	    )).protocols(httpProtocol)
  }
}
