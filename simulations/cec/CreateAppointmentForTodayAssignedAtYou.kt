
import java.time.Duration

import io.gatling.javaapi.core.*
import io.gatling.javaapi.http.*
import io.gatling.javaapi.jdbc.*

import io.gatling.javaapi.core.CoreDsl.*
import io.gatling.javaapi.http.HttpDsl.*
import io.gatling.javaapi.jdbc.JdbcDsl.*

class CreateAppointmentForTodayAssignedAtYou : Simulation() {

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
  
  private val headers_2 = mapOf(
    "Accept" to "*/*",
    "Access-Control-Request-Headers" to "authorization",
    "Access-Control-Request-Method" to "GET",
    "Sec-Fetch-Dest" to "empty",
    "Sec-Fetch-Mode" to "cors",
    "Sec-Fetch-Site" to "same-site"
  )
  
  private val headers_3 = mapOf(
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
    "Sec-Fetch-Dest" to "empty",
    "Sec-Fetch-Mode" to "cors",
    "Sec-Fetch-Site" to "same-site",
    "authorization" to "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxNTkiLCJ1c2VybmFtZSI6ImFydGVtLmt1Y2h1a0BxbGVzcy5jb20iLCJhY2NvdW50X2lkIjoiQUNDNjJEMTE5MDBBNDhBNEE3MThDQTJDQkQyREE0RTAyMEJVU0VBU1QxIiwicHJvdmlkZXIiOiJRTEVTUyIsIm9yZ2FuaXphdGlvbl9pZCI6Ik9SR0JDNTJEN0U5MUYzRTQwNTE5NzNDRDlBNkNDNzRENEUxVVNFQVNUMSIsImlhdCI6MTY4MjAzNTE4OSwiZXhwIjoxNjgyODk5MTg5LCJzYWx0ZXItdXVpZCI6IjBjZTc5MTlkLTE5N2QtNDhhZi04NzhhLWJhMjg0ZTcxNWRjYSJ9.0AJakceBLtgWXuYE9fKqIm2BvRCBChEkotp-18poBqV6CsurREZUrLRksMHKq0djYnCyAHqIn-p0N2V8V19pqg",
    "sec-ch-ua" to """Chromium";v="112", "Google Chrome";v="112", "Not:A-Brand";v="99""",
    "sec-ch-ua-mobile" to "?0",
    "sec-ch-ua-platform" to "Windows"
  )
  
  private val headers_48 = mapOf(
    "Accept" to "*/*",
    "Access-Control-Request-Headers" to "authorization,content-type",
    "Access-Control-Request-Method" to "PUT",
    "Sec-Fetch-Dest" to "empty",
    "Sec-Fetch-Mode" to "cors",
    "Sec-Fetch-Site" to "same-site"
  )


  private val scn = scenario("CreateAppointmentForTodayAssignedAtYou")
    .exec(
      http("request_0")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
        .headers(headers_0)
        .resources(
          http("request_1")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_0),
          http("request_2")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_2),
          http("request_3")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
            .headers(headers_3)
            .body(RawFileBody("createappointmentfortodayassignedatyou/0003_request.json")),
          http("request_4")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_3)
            .body(RawFileBody("createappointmentfortodayassignedatyou/0004_request.json")),
          http("request_5")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_5)
        )
    )
    .pause(2)
    .exec(
      http("request_6")
        .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
        .headers(headers_3)
        .body(RawFileBody("createappointmentfortodayassignedatyou/0006_request.json"))
        .resources(
          http("request_7")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_3)
            .body(RawFileBody("createappointmentfortodayassignedatyou/0007_request.json")),
          http("request_8")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_5)
        )
    )
    .pause(2)
    .exec(
      http("request_9")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/services/SVCDDA21A92812D465D9F11FA2B9218BE03USEAST1/available-time-slots/list")
        .headers(headers_0)
        .resources(
          http("request_10")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/services/SVCDDA21A92812D465D9F11FA2B9218BE03USEAST1/available-time-slots/list")
            .headers(headers_3)
            .body(RawFileBody("createappointmentfortodayassignedatyou/0010_request.json")),
          http("request_11")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
            .headers(headers_0),
          http("request_12")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_0),
          http("request_13")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_2),
          http("request_14")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
            .headers(headers_3)
            .body(RawFileBody("createappointmentfortodayassignedatyou/0014_request.json")),
          http("request_15")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_3)
            .body(RawFileBody("createappointmentfortodayassignedatyou/0015_request.json")),
          http("request_16")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_5)
        )
    )
    .pause(2)
    .exec(
      http("request_17")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/services/SVCDDA21A92812D465D9F11FA2B9218BE03USEAST1/resources/appointments")
        .headers(headers_0)
        .resources(
          http("request_18")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/services/SVCDDA21A92812D465D9F11FA2B9218BE03USEAST1/resources/appointments")
            .headers(headers_3)
            .body(RawFileBody("createappointmentfortodayassignedatyou/0018_request.json")),
          http("request_19")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
            .headers(headers_3)
            .body(RawFileBody("createappointmentfortodayassignedatyou/0019_request.json")),
          http("request_20")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_3)
            .body(RawFileBody("createappointmentfortodayassignedatyou/0020_request.json")),
          http("request_21")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_5)
        )
    )
    .pause(2)
    .exec(
      http("request_22")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
        .headers(headers_0)
        .resources(
          http("request_23")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_0),
          http("request_24")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
            .headers(headers_3)
            .body(RawFileBody("createappointmentfortodayassignedatyou/0024_request.json")),
          http("request_25")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_3)
            .body(RawFileBody("createappointmentfortodayassignedatyou/0025_request.json")),
          http("request_26")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_2),
          http("request_27")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_5)
        )
    )
    .pause(2)
    .exec(
      http("request_28")
        .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
        .headers(headers_3)
        .body(RawFileBody("createappointmentfortodayassignedatyou/0028_request.json"))
        .resources(
          http("request_29")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_3)
            .body(RawFileBody("createappointmentfortodayassignedatyou/0029_request.json")),
          http("request_30")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_5)
        )
    )
    .pause(2)
    .exec(
      http("request_31")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
        .headers(headers_0)
        .resources(
          http("request_32")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_0),
          http("request_33")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
            .headers(headers_3)
            .body(RawFileBody("createappointmentfortodayassignedatyou/0033_request.json")),
          http("request_34")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_3)
            .body(RawFileBody("createappointmentfortodayassignedatyou/0034_request.json")),
          http("request_35")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_2),
          http("request_36")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_5)
        )
    )
    .pause(2)
    .exec(
      http("request_37")
        .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
        .headers(headers_3)
        .body(RawFileBody("createappointmentfortodayassignedatyou/0037_request.json"))
        .resources(
          http("request_38")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_3)
            .body(RawFileBody("createappointmentfortodayassignedatyou/0038_request.json")),
          http("request_39")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_5)
        )
    )
    .pause(2)
    .exec(
      http("request_40")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
        .headers(headers_0)
        .resources(
          http("request_41")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_0),
          http("request_42")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
            .headers(headers_3)
            .body(RawFileBody("createappointmentfortodayassignedatyou/0042_request.json")),
          http("request_43")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_3)
            .body(RawFileBody("createappointmentfortodayassignedatyou/0043_request.json")),
          http("request_44")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_2),
          http("request_45")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_5)
        )
    )
    .pause(2)
    .exec(
      http("request_46")
        .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
        .headers(headers_3)
        .body(RawFileBody("createappointmentfortodayassignedatyou/0046_request.json"))
        .resources(
          http("request_47")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_3)
            .body(RawFileBody("createappointmentfortodayassignedatyou/0047_request.json")),
          http("request_48")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/APTE557F1CA18384B9C953C20D4B33F6904USEAST1/fields")
            .headers(headers_48),
          http("request_49")
            .put("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/APTE557F1CA18384B9C953C20D4B33F6904USEAST1/fields")
            .headers(headers_3)
            .body(RawFileBody("createappointmentfortodayassignedatyou/0049_request.json")),
          http("request_50")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_5),
          http("request_51")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/resources/appointments/APTE557F1CA18384B9C953C20D4B33F6904USEAST1")
            .headers(headers_48),
          http("request_52")
            .put("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/resources/appointments/APTE557F1CA18384B9C953C20D4B33F6904USEAST1")
            .headers(headers_3)
            .body(RawFileBody("createappointmentfortodayassignedatyou/0052_request.json")),
          http("request_53")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_3)
            .body(RawFileBody("createappointmentfortodayassignedatyou/0053_request.json")),
          http("request_54")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_3)
            .body(RawFileBody("createappointmentfortodayassignedatyou/0054_request.json")),
          http("request_55")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_5)
        )
    )
    .pause(2)
    .exec(
      http("request_56")
        .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
        .headers(headers_0)
        .resources(
          http("request_57")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
            .headers(headers_3)
            .body(RawFileBody("createappointmentfortodayassignedatyou/0057_request.json")),
          http("request_58")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_0),
          http("request_59")
            .options("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_2),
          http("request_60")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_3)
            .body(RawFileBody("createappointmentfortodayassignedatyou/0060_request.json")),
          http("request_61")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_5)
        )
    )
    .pause(2)
    .exec(
      http("request_62")
        .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/walkins/search")
        .headers(headers_3)
        .body(RawFileBody("createappointmentfortodayassignedatyou/0062_request.json"))
        .resources(
          http("request_63")
            .post("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/appointments/search")
            .headers(headers_3)
            .body(RawFileBody("createappointmentfortodayassignedatyou/0063_request.json")),
          http("request_64")
            .get("/api/v1/organizations/ORGBC52D7E91F3E4051973CD9A6CC74D4E1USEAST1/locations/LOC040FFCD16C5547AF9B10E17B90333FDEUSEAST1/visits/score-card")
            .headers(headers_5)
        )
    )

  init {
	  setUp(scn.injectOpen(atOnceUsers(1))).protocols(httpProtocol)
  }
}
