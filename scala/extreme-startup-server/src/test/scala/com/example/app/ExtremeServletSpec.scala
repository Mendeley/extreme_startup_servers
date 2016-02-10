package com.example.app

import org.scalatra.test.specs2._

// For more on Specs2, see http://etorreborre.github.io/specs2/
class ExtremeServletSpec extends ScalatraSpec { def is =
  "GET / on ExtremeServlet"                     ^
    "should return status 200"                  ! root200^
                                                end

  addServlet(classOf[ExtremeServlet], "/*")

  def root200 = get("/") {
    status must_== 200
  }
}
