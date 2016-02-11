package com.example.app

import org.slf4j.LoggerFactory

class ExtremeServlet extends ExtremeStartupServerStack {
  val logger = LoggerFactory.getLogger(getClass)
  logger.info("Extreme Startup open for business")

  get("/") {
    logger.info("Entering / handler")

    val q = params.get("q")
    val maybeQuestion: Option[Question] = q match {
      case None => None
      case q => {
        logger.info("Parsing question")
        Question(q)
      }
    }

    logger.info("Handling query " + maybeQuestion.get.id)
    maybeQuestion.get.question match {
      case "whats your name" => "example"
      case _ => "unanswerable question " + maybeQuestion.get.id + ": \"" + maybeQuestion.get.question + "\""
    }
  }

  logger.info("Exiting / handler")
}
