
import java.time.Duration

import io.gatling.javaapi.core.*
import io.gatling.javaapi.http.*
import io.gatling.javaapi.jdbc.*

import io.gatling.javaapi.core.CoreDsl.*
import io.gatling.javaapi.http.HttpDsl.*
import io.gatling.javaapi.jdbc.JdbcDsl.*

class CancelVisitWithComment : Simulation() {

  private val httpProtocol = http
    .baseUrl("https://apps-api.staging.peg.qless.com")
    .inferHtmlResources()
    .acceptHeader("application/json, text/plain, */*")
    .acceptEncodingHeader("gzip, deflate, br")
    .acceptLanguageHeader("en-US,en;q=0.9,ru;q=0.8")
    .originHeader("https://console.staging.peg.qless.com")
    .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.0.0 Safari/537.36")
  
  private val headers_0 = mapOf(
    "Accept" to "*/*",
    "Access-Control-Request-Headers" to "authorization,content-type",
    "Access-Control-Request-Method" to "POST",
    "Sec-Fetch-Dest" to "empty",
    "Sec-Fetch-Mode" to "cors",
    "Sec-Fetch-Site" to "same-site"
  )
  
  private val headers_1 = mapOf(
    "Content-Type" to "application/json",
    "Sec-Fetch-Dest" to "empty",
    "Sec-Fetch-Mode" to "cors",
    "Sec-Fetch-Site" to "same-site",
    "authorization" to "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxNTkiLCJ1c2VybmFtZSI6ImFydGVtLmt1Y2h1a0BxbGVzcy5jb20iLCJhY2NvdW50X2lkIjoiQUNDNjJEMTE5MDBBNDhBNEE3MThDQTJDQkQyREE0RTAyMEJVU0VBU1QxIiwicHJvdmlkZXIiOiJRTEVTUyIsIm9yZ2FuaXphdGlvbl9pZCI6Ik9SR0JDNTJEN0U5MUYzRTQwNTE5NzNDRDlBNkNDNzRENEUxVVNFQVNUMSIsImlhdCI6MTY4MjAzNTE4OSwiZXhwIjoxNjgyODk5MTg5LCJzYWx0ZXItdXVpZCI6IjBjZTc5MTlkLTE5N2QtNDhhZi04NzhhLWJhMjg0ZTcxNWRjYSJ9.0AJakceBLtgWXuYE9fKqIm2BvRCBChEkotp-18poBqV6CsurREZUrLRksMHKq0djYnCyAHqIn-p0N2V8V19pqg",
    "sec-ch-ua" to """Chromium";v="112", "Google Chrome";v="112", "Not:A-Brand";v="99""",
    "sec-ch-ua-mobile" to "?0",
    "sec-ch-ua-platform" to "Windows"
  )
  
  private val headers_5 = mapOf(
    "Accept" to "*/*",
    "Access-Control-Request-Headers" to "authorization",
    "Access-Control-Request-Method" to "GET",
    "Sec-Fetch-Dest" to "empty",
    "Sec-Fetch-Mode" to "cors",
    "Sec-Fetch-Site" to "same-site"
  )
  
  private val headers_6 = mapOf(
    "Sec-Fetch-Dest" to "empty",
    "Sec-Fetch-Mode" to "cors",
    "Sec-Fetch-Site" to "same-site",
    "authorization" to "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxNTkiLCJ1c2VybmFtZSI6ImFydGVtLmt1Y2h1a0BxbGVzcy5jb20iLCJhY2NvdW50X2lkIjoiQUNDNjJEMTE5MDBBNDhBNEE3MThDQTJDQkQyREE0RTAyMEJVU0VBU1QxIiwicHJvdmlkZXIiOiJRTEVTUyIsIm9yZ2FuaXphdGlvbl9pZCI6Ik9SR0JDNTJEN0U5MUYzRTQwNTE5NzNDRDlBNkNDNzRENEUxVVNFQVNUMSIsImlhdCI6MTY4MjAzNTE4OSwiZXhwIjoxNjgyODk5MTg5LCJzYWx0ZXItdXVpZCI6IjBjZTc5MTlkLTE5N2QtNDhhZi04NzhhLWJhMjg0ZTcxNWRjYSJ9.0AJakceBLtgWXuYE9fKqIm2BvRCBChEkotp-18poBqV6CsurREZUrLRksMHKq0djYnCyAHqIn-p0N2V8V19pqg",
    "sec-ch-ua" to """Chromium";v="112", "Google Chrome";v="112", "Not:A-Brand";v="99""",
    "sec-ch-ua-mobile" to "?0",
    "sec-ch-ua-platform" to "Windows"
  )
  
  private val headers_26 = mapOf(
    "Accept" to "*/*",
    "Access-Control-Request-Headers" to "authorization,content-type",
    "Access-Control-Request-Method" to "PUT",
    "Sec-Fetch-Dest" to "empty",
    "Sec-Fetch-Mode" to "cors",
    "Sec-Fetch-Site" to "same-site"
  )


  private val scn = scenario("CancelVisitWithComment")
    .exec(
      http("request_0")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
        .headers(headers_0)
        .resources(
          http("request_1")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_1)
            .body(RawFileBody("cancelvisitwithcomment/0001_request.json"))
        )
    )
    .pause(2)
    .exec(
      http("request_2")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/services/SVCDDA21A92812D465D9F11FA2B9218BE03USEAST1/resources/walkins")
        .headers(headers_0)
        .resources(
          http("request_3")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
            .headers(headers_1)
            .body(RawFileBody("cancelvisitwithcomment/0003_request.json")),
          http("request_4")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/services/SVCDDA21A92812D465D9F11FA2B9218BE03USEAST1/resources/walkins")
            .headers(headers_1)
            .body(RawFileBody("cancelvisitwithcomment/0004_request.json")),
          http("request_5")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_5),
          http("request_6")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_6),
          http("request_7")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_1)
            .body(RawFileBody("cancelvisitwithcomment/0007_request.json"))
        )
    )
    .pause(2)
    .exec(
      http("request_8")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
        .headers(headers_0)
        .resources(
          http("request_9")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
            .headers(headers_1)
            .body(RawFileBody("cancelvisitwithcomment/0009_request.json")),
          http("request_10")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_6),
          http("request_11")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_0),
          http("request_12")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_1)
            .body(RawFileBody("cancelvisitwithcomment/0012_request.json"))
        )
    )
    .pause(2)
    .exec(
      http("request_13")
        .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
        .headers(headers_1)
        .body(RawFileBody("cancelvisitwithcomment/0013_request.json"))
        .resources(
          http("request_14")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_5),
          http("request_15")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_6),
          http("request_16")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_1)
            .body(RawFileBody("cancelvisitwithcomment/0016_request.json"))
        )
    )
    .pause(2)
    .exec(
      http("request_17")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
        .headers(headers_0)
        .resources(
          http("request_18")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
            .headers(headers_1)
            .body(RawFileBody("cancelvisitwithcomment/0018_request.json")),
          http("request_19")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_6),
          http("request_20")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_0),
          http("request_21")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_1)
            .body(RawFileBody("cancelvisitwithcomment/0021_request.json"))
        )
    )
    .pause(2)
    .exec(
      http("request_22")
        .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
        .headers(headers_1)
        .body(RawFileBody("cancelvisitwithcomment/0022_request.json"))
        .resources(
          http("request_23")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_5),
          http("request_24")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_6),
          http("request_25")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_1)
            .body(RawFileBody("cancelvisitwithcomment/0025_request.json")),
          http("request_26")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/WLKI3328F6D9095E46DC917823B992A2FF7AUSEAST1/fields")
            .headers(headers_26),
          http("request_27")
            .put("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/WLKI3328F6D9095E46DC917823B992A2FF7AUSEAST1/fields")
            .headers(headers_1)
            .body(RawFileBody("cancelvisitwithcomment/0027_request.json")),
          http("request_28")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/resources/walkins/WLKI3328F6D9095E46DC917823B992A2FF7AUSEAST1")
            .headers(headers_26),
          http("request_29")
            .put("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/resources/walkins/WLKI3328F6D9095E46DC917823B992A2FF7AUSEAST1")
            .headers(headers_1)
            .body(RawFileBody("cancelvisitwithcomment/0029_request.json")),
          http("request_30")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
            .headers(headers_1)
            .body(RawFileBody("cancelvisitwithcomment/0030_request.json")),
          http("request_31")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
            .headers(headers_1)
            .body(RawFileBody("cancelvisitwithcomment/0031_request.json")),
          http("request_32")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_6)
        )
    )
    .pause(1)
    .exec(
      http("request_33")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/WLKI3328F6D9095E46DC917823B992A2FF7AUSEAST1")
        .headers(headers_5)
        .resources(
          http("request_34")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/WLKI3328F6D9095E46DC917823B992A2FF7AUSEAST1/fields")
            .headers(headers_6),
          http("request_35")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/WLKI3328F6D9095E46DC917823B992A2FF7AUSEAST1")
            .headers(headers_6),
          http("request_36")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/WLKI3328F6D9095E46DC917823B992A2FF7AUSEAST1/comments?page=0&size=100")
            .headers(headers_5),
          http("request_37")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/WLKI3328F6D9095E46DC917823B992A2FF7AUSEAST1/comments?page=0&size=100")
            .headers(headers_6),
          http("request_38")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_0),
          http("request_39")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_1)
            .body(RawFileBody("cancelvisitwithcomment/0039_request.json")),
          http("request_40")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
            .headers(headers_0),
          http("request_41")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_6),
          http("request_42")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
            .headers(headers_1)
            .body(RawFileBody("cancelvisitwithcomment/0042_request.json"))
        )
    )
    .pause(1)
    .exec(
      http("request_43")
        .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/WLKI3328F6D9095E46DC917823B992A2FF7AUSEAST1")
        .headers(headers_6)
        .resources(
          http("request_44")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/WLKI3328F6D9095E46DC917823B992A2FF7AUSEAST1/comments?page=0&size=100")
            .headers(headers_6),
          http("request_45")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_1)
            .body(RawFileBody("cancelvisitwithcomment/0045_request.json")),
          http("request_46")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_5),
          http("request_47")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
            .headers(headers_1)
            .body(RawFileBody("cancelvisitwithcomment/0047_request.json")),
          http("request_48")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_6)
        )
    )
    .pause(1)
    .exec(
      http("request_49")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/WLKI3328F6D9095E46DC917823B992A2FF7AUSEAST1")
        .headers(headers_5)
        .resources(
          http("request_50")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/WLKI3328F6D9095E46DC917823B992A2FF7AUSEAST1/comments?page=0&size=100")
            .headers(headers_5),
          http("request_51")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/WLKI3328F6D9095E46DC917823B992A2FF7AUSEAST1")
            .headers(headers_6),
          http("request_52")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/WLKI3328F6D9095E46DC917823B992A2FF7AUSEAST1/comments?page=0&size=100")
            .headers(headers_6),
          http("request_53")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_0),
          http("request_54")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_1)
            .body(RawFileBody("cancelvisitwithcomment/0054_request.json")),
          http("request_55")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
            .headers(headers_0),
          http("request_56")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_6),
          http("request_57")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
            .headers(headers_1)
            .body(RawFileBody("cancelvisitwithcomment/0057_request.json"))
        )
    )
    .pause(1)
    .exec(
      http("request_58")
        .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/WLKI3328F6D9095E46DC917823B992A2FF7AUSEAST1")
        .headers(headers_6)
        .resources(
          http("request_59")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/WLKI3328F6D9095E46DC917823B992A2FF7AUSEAST1/comments?page=0&size=100")
            .headers(headers_6),
          http("request_60")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_1)
            .body(RawFileBody("cancelvisitwithcomment/0060_request.json"))
        )
    )
    .pause(1)
    .exec(
      http("request_61")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
        .headers(headers_5)
        .resources(
          http("request_62")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
            .headers(headers_1)
            .body(RawFileBody("cancelvisitwithcomment/0062_request.json")),
          http("request_63")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_6)
        )
    )
    .pause(1)
    .exec(
      http("request_64")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/WLKI3328F6D9095E46DC917823B992A2FF7AUSEAST1")
        .headers(headers_5)
        .resources(
          http("request_65")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/WLKI3328F6D9095E46DC917823B992A2FF7AUSEAST1")
            .headers(headers_6),
          http("request_66")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/WLKI3328F6D9095E46DC917823B992A2FF7AUSEAST1/comments?page=0&size=100")
            .headers(headers_5),
          http("request_67")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/WLKI3328F6D9095E46DC917823B992A2FF7AUSEAST1/comments?page=0&size=100")
            .headers(headers_6),
          http("request_68")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_0),
          http("request_69")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_1)
            .body(RawFileBody("cancelvisitwithcomment/0069_request.json")),
          http("request_70")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
            .headers(headers_0),
          http("request_71")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_6),
          http("request_72")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
            .headers(headers_1)
            .body(RawFileBody("cancelvisitwithcomment/0072_request.json")),
          http("request_73")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/resources/walkins/WLKI3328F6D9095E46DC917823B992A2FF7AUSEAST1")
            .headers(headers_26),
          http("request_74")
            .put("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/resources/walkins/WLKI3328F6D9095E46DC917823B992A2FF7AUSEAST1")
            .headers(headers_1)
            .body(RawFileBody("cancelvisitwithcomment/0074_request.json")),
          http("request_75")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/WLKI3328F6D9095E46DC917823B992A2FF7AUSEAST1")
            .headers(headers_6),
          http("request_76")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
            .headers(headers_1)
            .body(RawFileBody("cancelvisitwithcomment/0076_request.json")),
          http("request_77")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
            .headers(headers_1)
            .body(RawFileBody("cancelvisitwithcomment/0077_request.json"))
        )
    )
    .pause(1)
    .exec(
      http("request_78")
        .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
        .headers(headers_1)
        .body(RawFileBody("cancelvisitwithcomment/0078_request.json"))
    )
    .pause(1)
    .exec(
      http("request_79")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
        .headers(headers_5)
        .resources(
          http("request_80")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_6),
          http("request_81")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
            .headers(headers_1)
            .body(RawFileBody("cancelvisitwithcomment/0081_request.json"))
        )
    )
    .pause(1)
    .exec(
      http("request_82")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
        .headers(headers_0)
        .resources(
          http("request_83")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_1)
            .body(RawFileBody("cancelvisitwithcomment/0083_request.json"))
        )
    )

  init {
	  setUp(scn.injectOpen(atOnceUsers(1))).protocols(httpProtocol)
  }
}
