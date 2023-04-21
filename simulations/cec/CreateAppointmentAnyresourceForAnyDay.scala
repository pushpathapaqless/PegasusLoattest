
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class CreateAppointmentAnyresourceForAnyDay extends Simulation {

  private val httpProtocol = http
    .baseUrl("https://apps-api.staging.peg.qless.com")
    .inferHtmlResources()
    .acceptHeader("application/json, text/plain, */*")
    .acceptEncodingHeader("gzip, deflate, br")
    .acceptLanguageHeader("en-US,en;q=0.9,ru;q=0.8")
    .originHeader("https://console.staging.peg.qless.com")
    .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.0.0 Safari/537.36")
  
  private val headers_0 = Map(
  		"Accept" -> "*/*",
  		"Access-Control-Request-Headers" -> "authorization",
  		"Access-Control-Request-Method" -> "GET",
  		"Sec-Fetch-Dest" -> "empty",
  		"Sec-Fetch-Mode" -> "cors",
  		"Sec-Fetch-Site" -> "same-site"
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
  		"Access-Control-Request-Headers" -> "authorization,content-type",
  		"Access-Control-Request-Method" -> "POST",
  		"Sec-Fetch-Dest" -> "empty",
  		"Sec-Fetch-Mode" -> "cors",
  		"Sec-Fetch-Site" -> "same-site"
  )
  
  private val headers_47 = Map(
  		"Accept" -> "*/*",
  		"Access-Control-Request-Headers" -> "authorization,content-type",
  		"Access-Control-Request-Method" -> "PUT",
  		"Sec-Fetch-Dest" -> "empty",
  		"Sec-Fetch-Mode" -> "cors",
  		"Sec-Fetch-Site" -> "same-site"
  )


  private val scn = scenario("CreateAppointmentAnyresourceForAnyDay")
    .exec(
      http("request_0")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
        .headers(headers_0)
        .resources(
          http("request_1")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
            .headers(headers_1)
            .body(RawFileBody("createappointmentanyresourceforanyday/0001_request.json")),
          http("request_2")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_2)
        )
    )
    .pause(1)
    .exec(
      http("request_3")
        .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
        .headers(headers_1)
        .body(RawFileBody("createappointmentanyresourceforanyday/0003_request.json"))
        .resources(
          http("request_4")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
            .headers(headers_4),
          http("request_5")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_2),
          http("request_6")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
            .headers(headers_1)
            .body(RawFileBody("createappointmentanyresourceforanyday/0006_request.json")),
          http("request_7")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/services/SVCDDA21A92812D465D9F11FA2B9218BE03USEAST1/available-time-slots/list")
            .headers(headers_4),
          http("request_8")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/services/SVCDDA21A92812D465D9F11FA2B9218BE03USEAST1/available-time-slots/list")
            .headers(headers_1)
            .body(RawFileBody("createappointmentanyresourceforanyday/0008_request.json")),
          http("request_9")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_4),
          http("request_10")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_1)
            .body(RawFileBody("createappointmentanyresourceforanyday/0010_request.json")),
          http("request_11")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_0),
          http("request_12")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
            .headers(headers_1)
            .body(RawFileBody("createappointmentanyresourceforanyday/0012_request.json")),
          http("request_13")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_2)
        )
    )
    .pause(1)
    .exec(
      http("request_14")
        .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
        .headers(headers_1)
        .body(RawFileBody("createappointmentanyresourceforanyday/0014_request.json"))
        .resources(
          http("request_15")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
            .headers(headers_4),
          http("request_16")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_2),
          http("request_17")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
            .headers(headers_1)
            .body(RawFileBody("createappointmentanyresourceforanyday/0017_request.json")),
          http("request_18")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/services/SVCDDA21A92812D465D9F11FA2B9218BE03USEAST1/resources/appointments")
            .headers(headers_4),
          http("request_19")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/services/SVCDDA21A92812D465D9F11FA2B9218BE03USEAST1/resources/appointments")
            .headers(headers_1)
            .body(RawFileBody("createappointmentanyresourceforanyday/0019_request.json"))
        )
    )
    .pause(1)
    .exec(
      http("request_20")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
        .headers(headers_4)
        .resources(
          http("request_21")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_1)
            .body(RawFileBody("createappointmentanyresourceforanyday/0021_request.json")),
          http("request_22")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_0),
          http("request_23")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
            .headers(headers_1)
            .body(RawFileBody("createappointmentanyresourceforanyday/0023_request.json")),
          http("request_24")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_2)
        )
    )
    .pause(1)
    .exec(
      http("request_25")
        .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
        .headers(headers_1)
        .body(RawFileBody("createappointmentanyresourceforanyday/0025_request.json"))
        .resources(
          http("request_26")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
            .headers(headers_4),
          http("request_27")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_2),
          http("request_28")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
            .headers(headers_1)
            .body(RawFileBody("createappointmentanyresourceforanyday/0028_request.json"))
        )
    )
    .pause(1)
    .exec(
      http("request_29")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
        .headers(headers_4)
        .resources(
          http("request_30")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_1)
            .body(RawFileBody("createappointmentanyresourceforanyday/0030_request.json")),
          http("request_31")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_0),
          http("request_32")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
            .headers(headers_1)
            .body(RawFileBody("createappointmentanyresourceforanyday/0032_request.json")),
          http("request_33")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_2)
        )
    )
    .pause(1)
    .exec(
      http("request_34")
        .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
        .headers(headers_1)
        .body(RawFileBody("createappointmentanyresourceforanyday/0034_request.json"))
        .resources(
          http("request_35")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
            .headers(headers_4),
          http("request_36")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
            .headers(headers_1)
            .body(RawFileBody("createappointmentanyresourceforanyday/0036_request.json")),
          http("request_37")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_2)
        )
    )
    .pause(1)
    .exec(
      http("request_38")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
        .headers(headers_4)
        .resources(
          http("request_39")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_1)
            .body(RawFileBody("createappointmentanyresourceforanyday/0039_request.json")),
          http("request_40")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
            .headers(headers_1)
            .body(RawFileBody("createappointmentanyresourceforanyday/0040_request.json")),
          http("request_41")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_0),
          http("request_42")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_2)
        )
    )
    .pause(1)
    .exec(
      http("request_43")
        .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
        .headers(headers_1)
        .body(RawFileBody("createappointmentanyresourceforanyday/0043_request.json"))
        .resources(
          http("request_44")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
            .headers(headers_4),
          http("request_45")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
            .headers(headers_1)
            .body(RawFileBody("createappointmentanyresourceforanyday/0045_request.json")),
          http("request_46")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_2),
          http("request_47")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/APT556C155403DE4B83AB674EA25FCE22D3USEAST1/fields")
            .headers(headers_47),
          http("request_48")
            .put("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/APT556C155403DE4B83AB674EA25FCE22D3USEAST1/fields")
            .headers(headers_1)
            .body(RawFileBody("createappointmentanyresourceforanyday/0048_request.json")),
          http("request_49")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/resources/appointments/APT556C155403DE4B83AB674EA25FCE22D3USEAST1")
            .headers(headers_47),
          http("request_50")
            .put("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/resources/appointments/APT556C155403DE4B83AB674EA25FCE22D3USEAST1")
            .headers(headers_1)
            .body(RawFileBody("createappointmentanyresourceforanyday/0050_request.json")),
          http("request_51")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_4),
          http("request_52")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_4),
          http("request_53")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_1)
            .body(RawFileBody("createappointmentanyresourceforanyday/0053_request.json")),
          http("request_54")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_2),
          http("request_55")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_1)
            .body(RawFileBody("createappointmentanyresourceforanyday/0055_request.json"))
        )
    )
    .pause(1)
    .exec(
      http("request_56")
        .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
        .headers(headers_1)
        .body(RawFileBody("createappointmentanyresourceforanyday/0056_request.json"))
    )
    .pause(1)
    .exec(
      http("request_57")
        .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
        .headers(headers_1)
        .body(RawFileBody("createappointmentanyresourceforanyday/0057_request.json"))
        .resources(
          http("request_58")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_0),
          http("request_59")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_2)
        )
    )

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}
