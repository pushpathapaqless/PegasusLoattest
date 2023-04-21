
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class AddWalkInUsingCECForTodayWithNoOtherWalkInForCurrentResource extends Simulation {

  private val httpProtocol = http
    .baseUrl("https://apps-api.staging.peg.qless.com")
    .inferHtmlResources()
    .acceptHeader("application/json, text/plain, */*")
    .acceptEncodingHeader("gzip, deflate, br")
    .acceptLanguageHeader("en-US,en;q=0.9,zh-CN;q=0.8,zh;q=0.7,hi;q=0.6")
    .originHeader("https://console.staging.peg.qless.com")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.0.0 Safari/537.36")
  
  private val headers_0 = Map(
  		"accept" -> "*/*",
  		"access-control-request-headers" -> "authorization",
  		"access-control-request-method" -> "GET",
  		"sec-fetch-dest" -> "empty",
  		"sec-fetch-mode" -> "cors",
  		"sec-fetch-site" -> "same-site"
  )
  
  private val headers_1 = Map(
  		"authorization" -> "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxNTUiLCJ1c2VybmFtZSI6InB1c2hwYS50aGFwYUBxbGVzcy5jb20iLCJhY2NvdW50X2lkIjoiQUNDN0FENzQxNTYwQkNCNDc0MUIzQkFCOEY5MkRDMDhEQjRVU0VBU1QxIiwicHJvdmlkZXIiOiJRTEVTUyIsIm9yZ2FuaXphdGlvbl9pZCI6Ik9SR0JDNTJEN0U5MUYzRTQwNTE5NzNDRDlBNkNDNzRENEUxVVNFQVNUMSIsImlhdCI6MTY4MTkxNDM0NywiZXhwIjoxNjgyNzc4MzQ3LCJzYWx0ZXItdXVpZCI6IjRlYTVjMmRjLWVmNTEtNDRjNC1hZGJiLWMwNzAxYmY4Y2IwYiJ9.WbntzvG6UppOH9ltMDJDHpJdWUM4wH_gwU9AAQfX_ksrTYqmWBjdlWhCGqoxlmRXADnPxs_Ttc7GOvW95HKBFQ",
  		"sec-ch-ua" -> """Chromium";v="112", "Google Chrome";v="112", "Not:A-Brand";v="99""",
  		"sec-ch-ua-mobile" -> "?0",
  		"sec-ch-ua-platform" -> "macOS",
  		"sec-fetch-dest" -> "empty",
  		"sec-fetch-mode" -> "cors",
  		"sec-fetch-site" -> "same-site"
  )
  
  private val headers_2 = Map(
  		"authorization" -> "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxNTUiLCJ1c2VybmFtZSI6InB1c2hwYS50aGFwYUBxbGVzcy5jb20iLCJhY2NvdW50X2lkIjoiQUNDN0FENzQxNTYwQkNCNDc0MUIzQkFCOEY5MkRDMDhEQjRVU0VBU1QxIiwicHJvdmlkZXIiOiJRTEVTUyIsIm9yZ2FuaXphdGlvbl9pZCI6Ik9SR0JDNTJEN0U5MUYzRTQwNTE5NzNDRDlBNkNDNzRENEUxVVNFQVNUMSIsImlhdCI6MTY4MTkxNDM0NywiZXhwIjoxNjgyNzc4MzQ3LCJzYWx0ZXItdXVpZCI6IjRlYTVjMmRjLWVmNTEtNDRjNC1hZGJiLWMwNzAxYmY4Y2IwYiJ9.WbntzvG6UppOH9ltMDJDHpJdWUM4wH_gwU9AAQfX_ksrTYqmWBjdlWhCGqoxlmRXADnPxs_Ttc7GOvW95HKBFQ",
  		"content-type" -> "application/json",
  		"sec-ch-ua" -> """Chromium";v="112", "Google Chrome";v="112", "Not:A-Brand";v="99""",
  		"sec-ch-ua-mobile" -> "?0",
  		"sec-ch-ua-platform" -> "macOS",
  		"sec-fetch-dest" -> "empty",
  		"sec-fetch-mode" -> "cors",
  		"sec-fetch-site" -> "same-site"
  )
  
  private val headers_6 = Map(
  		"accept" -> "*/*",
  		"access-control-request-headers" -> "authorization,content-type",
  		"access-control-request-method" -> "POST",
  		"sec-fetch-dest" -> "empty",
  		"sec-fetch-mode" -> "cors",
  		"sec-fetch-site" -> "same-site"
  )
  
  private val headers_42 = Map(
  		"accept" -> "*/*",
  		"access-control-request-headers" -> "authorization,content-type",
  		"access-control-request-method" -> "PUT",
  		"sec-fetch-dest" -> "empty",
  		"sec-fetch-mode" -> "cors",
  		"sec-fetch-site" -> "same-site"
  )


  private val scn = scenario("AddWalkInUsingCECForTodayWithNoOtherWalkInForCurrentResource")
    .exec(
      http("request_0")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/services/tree?linkedUserRequired=true&serviceStatus=ACTIVE&serviceAvailabilityTypes=QUEUE,ALL")
        .headers(headers_0)
        .resources(
          http("request_1")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/services/tree?linkedUserRequired=true&serviceStatus=ACTIVE&serviceAvailabilityTypes=QUEUE,ALL")
            .headers(headers_1)
            .check(bodyBytes.is(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0001_response.json"))),
          http("request_2")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/appointments/search")
            .headers(headers_2)
            .body(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0002_request.json"))
            .check(bodyBytes.is(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0002_response.json"))),
          http("request_3")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/walkins/search")
            .headers(headers_2)
            .body(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0003_request.json"))
            .check(bodyBytes.is(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0003_response.json"))),
          http("request_4")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/visits/score-card")
            .headers(headers_1)
            .check(bodyBytes.is(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0004_response.json")))
        )
    )
    .pause(1)
    .exec(
      http("request_5")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/services/SVC1BF4EE814B85450DAFDC6A4916856023USEAST1/full-service-field-links/list")
        .headers(headers_0)
        .resources(
          http("request_6")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/services/SVC1BF4EE814B85450DAFDC6A4916856023USEAST1/resources/walkins")
            .headers(headers_6),
          http("request_7")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/services/SVC1BF4EE814B85450DAFDC6A4916856023USEAST1/full-service-field-links/list")
            .headers(headers_1)
            .check(bodyBytes.is(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0007_response.json"))),
          http("request_8")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/services/SVC1BF4EE814B85450DAFDC6A4916856023USEAST1/resources/walkins")
            .headers(headers_2)
            .body(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0008_request.json"))
            .check(bodyBytes.is(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0008_response.json"))),
          http("request_9")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/appointments/search")
            .headers(headers_6),
          http("request_10")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/walkins/search")
            .headers(headers_6),
          http("request_11")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/appointments/search")
            .headers(headers_2)
            .body(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0011_request.json"))
            .check(bodyBytes.is(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0011_response.json"))),
          http("request_12")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/walkins/search")
            .headers(headers_2)
            .body(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0012_request.json"))
            .check(bodyBytes.is(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0012_response.json"))),
          http("request_13")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/visits/score-card")
            .headers(headers_0),
          http("request_14")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/visits/score-card")
            .headers(headers_1)
            .check(bodyBytes.is(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0014_response.json")))
        )
    )
    .pause(2)
    .exec(
      http("request_15")
        .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/appointments/search")
        .headers(headers_2)
        .body(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0015_request.json"))
        .check(bodyBytes.is(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0015_response.json")))
        .resources(
          http("request_16")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/walkins/search")
            .headers(headers_2)
            .body(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0016_request.json"))
            .check(bodyBytes.is(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0016_response.json"))),
          http("request_17")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/visits/score-card")
            .headers(headers_1)
            .check(bodyBytes.is(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0017_response.json")))
        )
    )
    .pause(2)
    .exec(
      http("request_18")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/appointments/search")
        .headers(headers_6)
        .resources(
          http("request_19")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/walkins/search")
            .headers(headers_6),
          http("request_20")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/appointments/search")
            .headers(headers_2)
            .body(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0020_request.json"))
            .check(bodyBytes.is(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0020_response.json"))),
          http("request_21")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/visits/score-card")
            .headers(headers_0),
          http("request_22")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/walkins/search")
            .headers(headers_2)
            .body(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0022_request.json"))
            .check(bodyBytes.is(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0022_response.json"))),
          http("request_23")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/visits/score-card")
            .headers(headers_1)
            .check(bodyBytes.is(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0023_response.json")))
        )
    )
    .pause(2)
    .exec(
      http("request_24")
        .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/appointments/search")
        .headers(headers_2)
        .body(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0024_request.json"))
        .check(bodyBytes.is(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0024_response.json")))
        .resources(
          http("request_25")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/walkins/search")
            .headers(headers_2)
            .body(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0025_request.json"))
            .check(bodyBytes.is(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0025_response.json"))),
          http("request_26")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/visits/score-card")
            .headers(headers_1)
            .check(bodyBytes.is(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0026_response.json")))
        )
    )
    .pause(2)
    .exec(
      http("request_27")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/walkins/search")
        .headers(headers_6)
        .resources(
          http("request_28")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/appointments/search")
            .headers(headers_6),
          http("request_29")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/walkins/search")
            .headers(headers_2)
            .body(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0029_request.json"))
            .check(bodyBytes.is(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0029_response.json"))),
          http("request_30")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/appointments/search")
            .headers(headers_2)
            .body(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0030_request.json"))
            .check(bodyBytes.is(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0030_response.json"))),
          http("request_31")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/visits/score-card")
            .headers(headers_0),
          http("request_32")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/visits/score-card")
            .headers(headers_1)
            .check(bodyBytes.is(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0032_response.json")))
        )
    )
    .pause(2)
    .exec(
      http("request_33")
        .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/appointments/search")
        .headers(headers_2)
        .body(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0033_request.json"))
        .check(bodyBytes.is(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0033_response.json")))
        .resources(
          http("request_34")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/walkins/search")
            .headers(headers_2)
            .body(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0034_request.json"))
            .check(bodyBytes.is(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0034_response.json"))),
          http("request_35")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/visits/score-card")
            .headers(headers_1)
            .check(bodyBytes.is(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0035_response.json")))
        )
    )
    .pause(2)
    .exec(
      http("request_36")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/appointments/search")
        .headers(headers_6)
        .resources(
          http("request_37")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/walkins/search")
            .headers(headers_6),
          http("request_38")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/appointments/search")
            .headers(headers_2)
            .body(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0038_request.json"))
            .check(bodyBytes.is(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0038_response.json"))),
          http("request_39")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/walkins/search")
            .headers(headers_2)
            .body(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0039_request.json"))
            .check(bodyBytes.is(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0039_response.json"))),
          http("request_40")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/visits/score-card")
            .headers(headers_0),
          http("request_41")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/visits/score-card")
            .headers(headers_1)
            .check(bodyBytes.is(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0041_response.json")))
        )
    )
    .pause(2)
    .exec(
      http("request_42")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/walkins/WLKIFB5EB4304836464DB10FAAAA307A1B76USEAST1/fields")
        .headers(headers_42)
        .resources(
          http("request_43")
            .put("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/walkins/WLKIFB5EB4304836464DB10FAAAA307A1B76USEAST1/fields")
            .headers(headers_2)
            .body(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0043_request.json"))
            .check(bodyBytes.is(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0043_response.json"))),
          http("request_44")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/resources/walkins/WLKIFB5EB4304836464DB10FAAAA307A1B76USEAST1")
            .headers(headers_42),
          http("request_45")
            .put("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/resources/walkins/WLKIFB5EB4304836464DB10FAAAA307A1B76USEAST1")
            .headers(headers_2)
            .body(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0045_request.json"))
            .check(bodyBytes.is(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0045_response.json"))),
          http("request_46")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/walkins/search")
            .headers(headers_2)
            .body(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0046_request.json"))
            .check(bodyBytes.is(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0046_response.json"))),
          http("request_47")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/walkins/search")
            .headers(headers_2)
            .body(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0047_request.json"))
            .check(bodyBytes.is(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0047_response.json"))),
          http("request_48")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/visits/score-card")
            .headers(headers_1)
            .check(bodyBytes.is(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0048_response.json"))),
          http("request_49")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/appointments/search")
            .headers(headers_2)
            .body(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0049_request.json"))
            .check(bodyBytes.is(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0049_response.json")))
        )
    )
    .pause(2)
    .exec(
      http("request_50")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/walkins/search")
        .headers(headers_6)
        .resources(
          http("request_51")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/visits/score-card")
            .headers(headers_0),
          http("request_52")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/visits/score-card")
            .headers(headers_1)
            .check(bodyBytes.is(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0052_response.json"))),
          http("request_53")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/walkins/search")
            .headers(headers_2)
            .body(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0053_request.json"))
            .check(bodyBytes.is(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0053_response.json"))),
          http("request_54")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/appointments/search")
            .headers(headers_6),
          http("request_55")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/appointments/search")
            .headers(headers_2)
            .body(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0055_request.json"))
            .check(bodyBytes.is(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0055_response.json")))
        )
    )
    .pause(2)
    .exec(
      http("request_56")
        .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/walkins/search")
        .headers(headers_2)
        .body(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0056_request.json"))
        .check(bodyBytes.is(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0056_response.json")))
        .resources(
          http("request_57")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/visits/score-card")
            .headers(headers_1)
            .check(bodyBytes.is(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0057_response.json"))),
          http("request_58")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/appointments/search")
            .headers(headers_2)
            .body(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0058_request.json"))
            .check(bodyBytes.is(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0058_response.json")))
        )
    )
    .pause(2)
    .exec(
      http("request_59")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/walkins/search")
        .headers(headers_6)
        .resources(
          http("request_60")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/visits/score-card")
            .headers(headers_0),
          http("request_61")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/walkins/search")
            .headers(headers_2)
            .body(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0061_request.json"))
            .check(bodyBytes.is(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0061_response.json"))),
          http("request_62")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/appointments/search")
            .headers(headers_6),
          http("request_63")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/visits/score-card")
            .headers(headers_1)
            .check(bodyBytes.is(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0063_response.json"))),
          http("request_64")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/appointments/search")
            .headers(headers_2)
            .body(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0064_request.json"))
            .check(bodyBytes.is(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0064_response.json")))
        )
    )
    .pause(2)
    .exec(
      http("request_65")
        .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/walkins/search")
        .headers(headers_2)
        .body(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0065_request.json"))
        .check(bodyBytes.is(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0065_response.json")))
        .resources(
          http("request_66")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/appointments/search")
            .headers(headers_2)
            .body(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0066_request.json"))
            .check(bodyBytes.is(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0066_response.json"))),
          http("request_67")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/visits/score-card")
            .headers(headers_1)
            .check(bodyBytes.is(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0067_response.json")))
        )
    )
    .pause(2)
    .exec(
      http("request_68")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/walkins/search")
        .headers(headers_6)
        .resources(
          http("request_69")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/appointments/search")
            .headers(headers_6),
          http("request_70")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/visits/score-card")
            .headers(headers_0),
          http("request_71")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/walkins/search")
            .headers(headers_2)
            .body(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0071_request.json"))
            .check(bodyBytes.is(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0071_response.json"))),
          http("request_72")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/appointments/search")
            .headers(headers_2)
            .body(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0072_request.json"))
            .check(bodyBytes.is(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0072_response.json"))),
          http("request_73")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/visits/score-card")
            .headers(headers_1)
            .check(bodyBytes.is(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0073_response.json")))
        )
    )
    .pause(2)
    .exec(
      http("request_74")
        .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/walkins/search")
        .headers(headers_2)
        .body(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0074_request.json"))
        .check(bodyBytes.is(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0074_response.json")))
        .resources(
          http("request_75")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/appointments/search")
            .headers(headers_2)
            .body(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0075_request.json"))
            .check(bodyBytes.is(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0075_response.json"))),
          http("request_76")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/visits/score-card")
            .headers(headers_1)
            .check(bodyBytes.is(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0076_response.json")))
        )
    )
    .pause(2)
    .exec(
      http("request_77")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/walkins/search")
        .headers(headers_6)
        .resources(
          http("request_78")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/appointments/search")
            .headers(headers_6),
          http("request_79")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/walkins/search")
            .headers(headers_2)
            .body(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0079_request.json"))
            .check(bodyBytes.is(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0079_response.json"))),
          http("request_80")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/visits/score-card")
            .headers(headers_0),
          http("request_81")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/appointments/search")
            .headers(headers_2)
            .body(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0081_request.json"))
            .check(bodyBytes.is(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0081_response.json"))),
          http("request_82")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC91ADFAF7317547A68994820E38489799USEAST1/visits/score-card")
            .headers(headers_1)
            .check(bodyBytes.is(RawFileBody("addwalkinusingcecfortodaywithnootherwalkinforcurrentresource/0082_response.json")))
        )
    )

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}

