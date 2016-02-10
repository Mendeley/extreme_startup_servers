package com.example.app

import org.scalatra._

trait ExtremeStartupServerStack extends ScalatraServlet {

  notFound {
    // remove content type in case it was set through an action
    contentType = null
    serveStaticResource() getOrElse resourceNotFound()
  }

}
