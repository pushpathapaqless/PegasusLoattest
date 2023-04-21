
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class CancelVisitWithoutComment extends Simulation {

  private val httpProtocol = http
    .baseUrl("https://apps-api.staging.peg.qless.com")
    .inferHtmlResources()
    .acceptHeader("application/json, text/plain, */*")
    .acceptEncodingHeader("gzip, deflate, br")
    .acceptLanguageHeader("en-US,en;q=0.9,ru;q=0.8")
    .originHeader("https://console.staging.peg.qless.com")
    .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.0.0 Safari/537.36")
  
  private val headers_0 = Map(
  		"Sec-Fetch-Dest" -> "empty",
  		"Sec-Fetch-Mode" -> "cors",
  		"Sec-Fetch-Site" -> "same-site",
  		"authorization" -> "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxNTkiLCJ1c2VybmFtZSI6ImFydGVtLmt1Y2h1a0BxbGVzcy5jb20iLCJhY2NvdW50X2lkIjoiQUNDNjJEMTE5MDBBNDhBNEE3MThDQTJDQkQyREE0RTAyMEJVU0VBU1QxIiwicHJvdmlkZXIiOiJRTEVTUyIsIm9yZ2FuaXphdGlvbl9pZCI6Ik9SR0JDNTJEN0U5MUYzRTQwNTE5NzNDRDlBNkNDNzRENEUxVVNFQVNUMSIsImlhdCI6MTY4MjAzNTE4OSwiZXhwIjoxNjgyODk5MTg5LCJzYWx0ZXItdXVpZCI6IjBjZTc5MTlkLTE5N2QtNDhhZi04NzhhLWJhMjg0ZTcxNWRjYSJ9.0AJakceBLtgWXuYE9fKqIm2BvRCBChEkotp-18poBqV6CsurREZUrLRksMHKq0djYnCyAHqIn-p0N2V8V19pqg",
  		"sec-ch-ua" -> """Chromium";v="112", "Google Chrome";v="112", "Not:A-Brand";v="99""",
  		"sec-ch-ua-mobile" -> "?0",
  		"sec-ch-ua-platform" -> "Windows"
  )
  
  private val headers_1 = Map(
  		"Content-Type" -> "application/json",
  		"Sec-Fetch-Dest" -> "empty",
  		"Sec-Fetch-Mode" -> "cors",
  		"Sec-Fetch-Site" -> "same-site",
  		"authorization" -> "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxNTkiLCJ1c2VybmFtZSI6ImFydGVtLmt1Y2h1a0BxbGVzcy5jb20iLCJhY2NvdW50X2lkIjoiQUNDNjJEMTE5MDBBNDhBNEE3MThDQTJDQkQyREE0RTAyMEJVU0VBU1QxIiwicHJvdmlkZXIiOiJRTEVTUyIsIm9yZ2FuaXphdGlvbl9pZCI6Ik9SR0JDNTJEN0U5MUYzRTQwNTE5NzNDRDlBNkNDNzRENEUxVVNFQVNUMSIsImlhdCI6MTY4MjAzNTE4OSwiZXhwIjoxNjgyODk5MTg5LCJzYWx0ZXItdXVpZCI6IjBjZTc5MTlkLTE5N2QtNDhhZi04NzhhLWJhMjg0ZTcxNWRjYSJ9.0AJakceBLtgWXuYE9fKqIm2BvRCBChEkotp-18poBqV6CsurREZUrLRksMHKq0djYnCyAHqIn-p0N2V8V19pqg",
  		"sec-ch-ua" -> """Chromium";v="112", "Google Chrome";v="112", "Not:A-Brand";v="99""",
  		"sec-ch-ua-mobile" -> "?0",
  		"sec-ch-ua-platform" -> "Windows"
  )
  
  private val headers_3 = Map(
  		"Accept" -> "*/*",
  		"Access-Control-Request-Headers" -> "authorization,content-type",
  		"Access-Control-Request-Method" -> "POST",
  		"Sec-Fetch-Dest" -> "empty",
  		"Sec-Fetch-Mode" -> "cors",
  		"Sec-Fetch-Site" -> "same-site"
  )
  
  private val headers_5 = Map(
  		"Accept" -> "*/*",
  		"Access-Control-Request-Headers" -> "authorization",
  		"Access-Control-Request-Method" -> "GET",
  		"Sec-Fetch-Dest" -> "empty",
  		"Sec-Fetch-Mode" -> "cors",
  		"Sec-Fetch-Site" -> "same-site"
  )
  
  private val headers_23 = Map(
  		"Accept" -> "*/*",
  		"Access-Control-Request-Headers" -> "authorization,content-type",
  		"Access-Control-Request-Method" -> "PUT",
  		"Sec-Fetch-Dest" -> "empty",
  		"Sec-Fetch-Mode" -> "cors",
  		"Sec-Fetch-Site" -> "same-site"
  )


  private val scn = scenario("CancelVisitWithoutComment")
    .exec(
      http("request_0")
        .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
        .headers(headers_0)
        .resources(
          http("request_1")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_1)
            .body(RawFileBody("cancelvisitwithoutcomment/0001_request.json"))
        )
    )
    .pause(1)
    .exec(
      http("request_2")
        .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
        .headers(headers_1)
        .body(RawFileBody("cancelvisitwithoutcomment/0002_request.json"))
        .resources(
          http("request_3")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/services/SVCDDA21A92812D465D9F11FA2B9218BE03USEAST1/resources/walkins")
            .headers(headers_3),
          http("request_4")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/services/SVCDDA21A92812D465D9F11FA2B9218BE03USEAST1/resources/walkins")
            .headers(headers_1)
            .body(RawFileBody("cancelvisitwithoutcomment/0004_request.json")),
          http("request_5")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_5),
          http("request_6")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_0),
          http("request_7")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_3),
          http("request_8")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_1)
            .body(RawFileBody("cancelvisitwithoutcomment/0008_request.json"))
        )
    )
    .pause(1)
    .exec(
      http("request_9")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
        .headers(headers_3)
        .resources(
          http("request_10")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
            .headers(headers_1)
            .body(RawFileBody("cancelvisitwithoutcomment/0010_request.json"))
        )
    )
    .pause(1)
    .exec(
      http("request_11")
        .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
        .headers(headers_0)
        .resources(
          http("request_12")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_1)
            .body(RawFileBody("cancelvisitwithoutcomment/0012_request.json"))
        )
    )
    .pause(1)
    .exec(
      http("request_13")
        .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
        .headers(headers_1)
        .body(RawFileBody("cancelvisitwithoutcomment/0013_request.json"))
    )
    .pause(1)
    .exec(
      http("request_14")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
        .headers(headers_5)
        .resources(
          http("request_15")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_0),
          http("request_16")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_3),
          http("request_17")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_1)
            .body(RawFileBody("cancelvisitwithoutcomment/0017_request.json"))
        )
    )
    .pause(1)
    .exec(
      http("request_18")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
        .headers(headers_3)
        .resources(
          http("request_19")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
            .headers(headers_1)
            .body(RawFileBody("cancelvisitwithoutcomment/0019_request.json"))
        )
    )
    .pause(1)
    .exec(
      http("request_20")
        .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
        .headers(headers_0)
        .resources(
          http("request_21")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_1)
            .body(RawFileBody("cancelvisitwithoutcomment/0021_request.json")),
          http("request_22")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
            .headers(headers_1)
            .body(RawFileBody("cancelvisitwithoutcomment/0022_request.json")),
          http("request_23")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/WLKIBC4B77FEB7FE4057A5F0650C93DAA7EFUSEAST1/fields")
            .headers(headers_23),
          http("request_24")
            .put("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/WLKIBC4B77FEB7FE4057A5F0650C93DAA7EFUSEAST1/fields")
            .headers(headers_1)
            .body(RawFileBody("cancelvisitwithoutcomment/0024_request.json")),
          http("request_25")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/resources/walkins/WLKIBC4B77FEB7FE4057A5F0650C93DAA7EFUSEAST1")
            .headers(headers_23),
          http("request_26")
            .put("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/resources/walkins/WLKIBC4B77FEB7FE4057A5F0650C93DAA7EFUSEAST1")
            .headers(headers_1)
            .body(RawFileBody("cancelvisitwithoutcomment/0026_request.json")),
          http("request_27")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
            .headers(headers_1)
            .body(RawFileBody("cancelvisitwithoutcomment/0027_request.json")),
          http("request_28")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
            .headers(headers_1)
            .body(RawFileBody("cancelvisitwithoutcomment/0028_request.json")),
          http("request_29")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_5),
          http("request_30")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_3),
          http("request_31")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_0),
          http("request_32")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_1)
            .body(RawFileBody("cancelvisitwithoutcomment/0032_request.json"))
        )
    )
    .pause(1)
    .exec(
      http("request_33")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/WLKI06ACC94E18BE46CEB25B54F36CFD5884USEAST1/fields")
        .headers(headers_5)
        .resources(
          http("request_34")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/WLKI06ACC94E18BE46CEB25B54F36CFD5884USEAST1")
            .headers(headers_5),
          http("request_35")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/WLKI06ACC94E18BE46CEB25B54F36CFD5884USEAST1/fields")
            .headers(headers_0),
          http("request_36")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/WLKI06ACC94E18BE46CEB25B54F36CFD5884USEAST1")
            .headers(headers_0),
          http("request_37")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/WLKI06ACC94E18BE46CEB25B54F36CFD5884USEAST1/comments?page=0&size=100")
            .headers(headers_5),
          http("request_38")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/WLKI06ACC94E18BE46CEB25B54F36CFD5884USEAST1/comments?page=0&size=100")
            .headers(headers_0)
        )
    )
    .pause(1)
    .exec(
      http("request_39")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
        .headers(headers_3)
        .resources(
          http("request_40")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
            .headers(headers_1)
            .body(RawFileBody("cancelvisitwithoutcomment/0040_request.json")),
          http("request_41")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_0),
          http("request_42")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_1)
            .body(RawFileBody("cancelvisitwithoutcomment/0042_request.json"))
        )
    )
    .pause(1)
    .exec(
      http("request_43")
        .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/WLKI06ACC94E18BE46CEB25B54F36CFD5884USEAST1")
        .headers(headers_0)
        .resources(
          http("request_44")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/WLKI06ACC94E18BE46CEB25B54F36CFD5884USEAST1/comments?page=0&size=100")
            .headers(headers_0)
        )
    )
    .pause(1)
    .exec(
      http("request_45")
        .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
        .headers(headers_1)
        .body(RawFileBody("cancelvisitwithoutcomment/0045_request.json"))
        .resources(
          http("request_46")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_5),
          http("request_47")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_3),
          http("request_48")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_0),
          http("request_49")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_1)
            .body(RawFileBody("cancelvisitwithoutcomment/0049_request.json")),
          http("request_50")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/WLKI06ACC94E18BE46CEB25B54F36CFD5884USEAST1")
            .headers(headers_5),
          http("request_51")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/WLKI06ACC94E18BE46CEB25B54F36CFD5884USEAST1")
            .headers(headers_0),
          http("request_52")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/WLKI06ACC94E18BE46CEB25B54F36CFD5884USEAST1/comments?page=0&size=100")
            .headers(headers_5),
          http("request_53")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/WLKI06ACC94E18BE46CEB25B54F36CFD5884USEAST1/comments?page=0&size=100")
            .headers(headers_0),
          http("request_54")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/resources/walkins/WLKI06ACC94E18BE46CEB25B54F36CFD5884USEAST1")
            .headers(headers_23),
          http("request_55")
            .put("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/resources/walkins/WLKI06ACC94E18BE46CEB25B54F36CFD5884USEAST1")
            .headers(headers_1)
            .body(RawFileBody("cancelvisitwithoutcomment/0055_request.json")),
          http("request_56")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
            .headers(headers_3),
          http("request_57")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
            .headers(headers_3),
          http("request_58")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/WLKI06ACC94E18BE46CEB25B54F36CFD5884USEAST1")
            .headers(headers_0),
          http("request_59")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
            .headers(headers_1)
            .body(RawFileBody("cancelvisitwithoutcomment/0059_request.json")),
          http("request_60")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
            .headers(headers_1)
            .body(RawFileBody("cancelvisitwithoutcomment/0060_request.json")),
          http("request_61")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_0),
          http("request_62")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_1)
            .body(RawFileBody("cancelvisitwithoutcomment/0062_request.json"))
        )
    )
    .pause(2)
    .exec(
      http("request_63")
        .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
        .headers(headers_1)
        .body(RawFileBody("cancelvisitwithoutcomment/0063_request.json"))
        .resources(
          http("request_64")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_5),
          http("request_65")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_3),
          http("request_66")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_0),
          http("request_67")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_1)
            .body(RawFileBody("cancelvisitwithoutcomment/0067_request.json"))
        )
    )

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}
