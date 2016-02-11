package com.example.app

import org.slf4j.LoggerFactory

class ExtremeServlet extends ExtremeStartupServerStack {
  val logger = LoggerFactory.getLogger(getClass)
  logger.info("Extreme Startup open for business")

  get("/") {
    val query = Query(params.getOrElse("q", "-1: no question"))

    val answer = query.question match {
      case "ping" => "pong"
      case _ => "無"
    }

    logger.info(s"""${query.id} "${query.question}" -> "$answer"""")

    answer
  }
}
