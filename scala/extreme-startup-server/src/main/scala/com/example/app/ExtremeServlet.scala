package com.example.app
import java.lang.String

class ExtremeServlet extends ExtremeStartupServerStack {

  case class Question(id: String, question: String)

  get("/") {
    val q = params.get("q")
    val query: Option[Question] = q match {
      case None => None

      case _ => {
        val parts = q.get.split(": ")
        if (parts.length != 2)
          None
        else {
          val (id, question) = (parts(0), parts(1))
          Option(Question(id, question))
        }
      }

    }
    query match {
      case None => "無" // should be 400 bad request

      case _ => "unanswerable question " + query.get.id + ": \"" + query.get.question + "\""
    }
  }

}
