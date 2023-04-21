
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class CreateWalkIn extends Simulation {

  private val httpProtocol = http
    .baseUrl("https://apps-api.staging.peg.qless.com")
    .inferHtmlResources()
    .acceptHeader("application/json, text/plain, */*")
    .acceptEncodingHeader("gzip, deflate, br")
    .acceptLanguageHeader("en-US,en;q=0.9,ru;q=0.8")
    .originHeader("https://console.staging.peg.qless.com")
    .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.0.0 Safari/537.36")
  
  private val headers_0 = Map(
  		"Content-Type" -> "application/json",
  		"Sec-Fetch-Dest" -> "empty",
  		"Sec-Fetch-Mode" -> "cors",
  		"Sec-Fetch-Site" -> "same-site",
  		"authorization" -> "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxNTkiLCJ1c2VybmFtZSI6ImFydGVtLmt1Y2h1a0BxbGVzcy5jb20iLCJhY2NvdW50X2lkIjoiQUNDNjJEMTE5MDBBNDhBNEE3MThDQTJDQkQyREE0RTAyMEJVU0VBU1QxIiwicHJvdmlkZXIiOiJRTEVTUyIsIm9yZ2FuaXphdGlvbl9pZCI6Ik9SR0JDNTJEN0U5MUYzRTQwNTE5NzNDRDlBNkNDNzRENEUxVVNFQVNUMSIsImlhdCI6MTY4MjAzNTE4OSwiZXhwIjoxNjgyODk5MTg5LCJzYWx0ZXItdXVpZCI6IjBjZTc5MTlkLTE5N2QtNDhhZi04NzhhLWJhMjg0ZTcxNWRjYSJ9.0AJakceBLtgWXuYE9fKqIm2BvRCBChEkotp-18poBqV6CsurREZUrLRksMHKq0djYnCyAHqIn-p0N2V8V19pqg",
  		"sec-ch-ua" -> """Chromium";v="112", "Google Chrome";v="112", "Not:A-Brand";v="99""",
  		"sec-ch-ua-mobile" -> "?0",
  		"sec-ch-ua-platform" -> "Windows"
  )
  
  private val headers_1 = Map(
  		"Accept" -> "*/*",
  		"Access-Control-Request-Headers" -> "authorization,content-type",
  		"Access-Control-Request-Method" -> "POST",
  		"Sec-Fetch-Dest" -> "empty",
  		"Sec-Fetch-Mode" -> "cors",
  		"Sec-Fetch-Site" -> "same-site"
  )
  
  private val headers_2 = Map(
  		"Sec-Fetch-Dest" -> "empty",
  		"Sec-Fetch-Mode" -> "cors",
  		"Sec-Fetch-Site" -> "same-site",
  		"authorization" -> "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxNTkiLCJ1c2VybmFtZSI6ImFydGVtLmt1Y2h1a0BxbGVzcy5jb20iLCJhY2NvdW50X2lkIjoiQUNDNjJEMTE5MDBBNDhBNEE3MThDQTJDQkQyREE0RTAyMEJVU0VBU1QxIiwicHJvdmlkZXIiOiJRTEVTUyIsIm9yZ2FuaXphdGlvbl9pZCI6Ik9SR0JDNTJEN0U5MUYzRTQwNTE5NzNDRDlBNkNDNzRENEUxVVNFQVNUMSIsImlhdCI6MTY4MjAzNTE4OSwiZXhwIjoxNjgyODk5MTg5LCJzYWx0ZXItdXVpZCI6IjBjZTc5MTlkLTE5N2QtNDhhZi04NzhhLWJhMjg0ZTcxNWRjYSJ9.0AJakceBLtgWXuYE9fKqIm2BvRCBChEkotp-18poBqV6CsurREZUrLRksMHKq0djYnCyAHqIn-p0N2V8V19pqg",
  		"sec-ch-ua" -> """Chromium";v="112", "Google Chrome";v="112", "Not:A-Brand";v="99""",
  		"sec-ch-ua-mobile" -> "?0",
  		"sec-ch-ua-platform" -> "Windows"
  )
  
  private val headers_4 = Map(
  		"Accept" -> "*/*",
  		"Access-Control-Request-Headers" -> "authorization",
  		"Access-Control-Request-Method" -> "GET",
  		"Sec-Fetch-Dest" -> "empty",
  		"Sec-Fetch-Mode" -> "cors",
  		"Sec-Fetch-Site" -> "same-site"
  )
  
  private val headers_44 = Map(
  		"Accept" -> "*/*",
  		"Access-Control-Request-Headers" -> "authorization,content-type",
  		"Access-Control-Request-Method" -> "PUT",
  		"Sec-Fetch-Dest" -> "empty",
  		"Sec-Fetch-Mode" -> "cors",
  		"Sec-Fetch-Site" -> "same-site"
  )


  private val scn = scenario("CreateWalkIn")
    .exec(
      http("request_0")
        .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
        .headers(headers_0)
        .body(RawFileBody("createwalkin/0000_request.json"))
        .resources(
          http("request_1")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
            .headers(headers_1),
          http("request_2")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_2),
          http("request_3")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
            .headers(headers_0)
            .body(RawFileBody("createwalkin/0003_request.json")),
          http("request_4")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/services/tree?linkedUserRequired=true&serviceStatus=ACTIVE&serviceAvailabilityTypes=QUEUE,ALL")
            .headers(headers_4),
          http("request_5")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/services/tree?linkedUserRequired=true&serviceStatus=ACTIVE&serviceAvailabilityTypes=QUEUE,ALL")
            .headers(headers_2)
        )
    )
    .pause(1)
    .exec(
      http("request_6")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/services/SVCDDA21A92812D465D9F11FA2B9218BE03USEAST1/resources/walkins")
        .headers(headers_1)
        .resources(
          http("request_7")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/services/SVCDDA21A92812D465D9F11FA2B9218BE03USEAST1/resources/walkins")
            .headers(headers_0)
            .body(RawFileBody("createwalkin/0007_request.json")),
          http("request_8")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_1),
          http("request_9")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_0)
            .body(RawFileBody("createwalkin/0009_request.json")),
          http("request_10")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_4),
          http("request_11")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
            .headers(headers_0)
            .body(RawFileBody("createwalkin/0011_request.json")),
          http("request_12")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_2)
        )
    )
    .pause(2)
    .exec(
      http("request_13")
        .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
        .headers(headers_0)
        .body(RawFileBody("createwalkin/0013_request.json"))
        .resources(
          http("request_14")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
            .headers(headers_1),
          http("request_15")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_2),
          http("request_16")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
            .headers(headers_0)
            .body(RawFileBody("createwalkin/0016_request.json"))
        )
    )
    .pause(2)
    .exec(
      http("request_17")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
        .headers(headers_1)
        .resources(
          http("request_18")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_0)
            .body(RawFileBody("createwalkin/0018_request.json")),
          http("request_19")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_4),
          http("request_20")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
            .headers(headers_0)
            .body(RawFileBody("createwalkin/0020_request.json")),
          http("request_21")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_2)
        )
    )
    .pause(2)
    .exec(
      http("request_22")
        .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
        .headers(headers_0)
        .body(RawFileBody("createwalkin/0022_request.json"))
        .resources(
          http("request_23")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
            .headers(headers_1),
          http("request_24")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
            .headers(headers_0)
            .body(RawFileBody("createwalkin/0024_request.json")),
          http("request_25")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_2)
        )
    )
    .pause(2)
    .exec(
      http("request_26")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
        .headers(headers_1)
        .resources(
          http("request_27")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_0)
            .body(RawFileBody("createwalkin/0027_request.json")),
          http("request_28")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
            .headers(headers_0)
            .body(RawFileBody("createwalkin/0028_request.json")),
          http("request_29")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_4),
          http("request_30")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_2)
        )
    )
    .pause(1)
    .exec(
      http("request_31")
        .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
        .headers(headers_0)
        .body(RawFileBody("createwalkin/0031_request.json"))
        .resources(
          http("request_32")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
            .headers(headers_1),
          http("request_33")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
            .headers(headers_0)
            .body(RawFileBody("createwalkin/0033_request.json")),
          http("request_34")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_2)
        )
    )
    .pause(2)
    .exec(
      http("request_35")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
        .headers(headers_1)
        .resources(
          http("request_36")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_0)
            .body(RawFileBody("createwalkin/0036_request.json")),
          http("request_37")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
            .headers(headers_0)
            .body(RawFileBody("createwalkin/0037_request.json")),
          http("request_38")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_4),
          http("request_39")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_2)
        )
    )
    .pause(1)
    .exec(
      http("request_40")
        .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
        .headers(headers_0)
        .body(RawFileBody("createwalkin/0040_request.json"))
        .resources(
          http("request_41")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
            .headers(headers_1),
          http("request_42")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
            .headers(headers_0)
            .body(RawFileBody("createwalkin/0042_request.json")),
          http("request_43")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_2),
          http("request_44")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/WLKI06ACC94E18BE46CEB25B54F36CFD5884USEAST1/fields")
            .headers(headers_44),
          http("request_45")
            .put("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/WLKI06ACC94E18BE46CEB25B54F36CFD5884USEAST1/fields")
            .headers(headers_0)
            .body(RawFileBody("createwalkin/0045_request.json")),
          http("request_46")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/resources/walkins/WLKI06ACC94E18BE46CEB25B54F36CFD5884USEAST1")
            .headers(headers_44),
          http("request_47")
            .put("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/resources/walkins/WLKI06ACC94E18BE46CEB25B54F36CFD5884USEAST1")
            .headers(headers_0)
            .body(RawFileBody("createwalkin/0047_request.json")),
          http("request_48")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
            .headers(headers_0)
            .body(RawFileBody("createwalkin/0048_request.json")),
          http("request_49")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
            .headers(headers_0)
            .body(RawFileBody("createwalkin/0049_request.json")),
          http("request_50")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_2),
          http("request_51")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_1),
          http("request_52")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_0)
            .body(RawFileBody("createwalkin/0052_request.json"))
        )
    )
    .pause(2)
    .exec(
      http("request_53")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
        .headers(headers_4)
        .resources(
          http("request_54")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
            .headers(headers_0)
            .body(RawFileBody("createwalkin/0054_request.json")),
          http("request_55")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_2),
          http("request_56")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_0)
            .body(RawFileBody("createwalkin/0056_request.json"))
        )
    )
    .pause(2)
    .exec(
      http("request_57")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
        .headers(headers_1)
        .resources(
          http("request_58")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
            .headers(headers_0)
            .body(RawFileBody("createwalkin/0058_request.json"))
        )
    )

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}
