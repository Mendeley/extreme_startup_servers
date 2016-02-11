package com.example.app

case class Question(var id: String, var question: String)

object Question {
  def apply(q: Option[String]): Option[Question] = {
    q match {
      case None => None
      case _ => Question(q)
    }
  }

  def apply(queryString: String) = {
    val parameterList = queryString.split(":\\s*", 2).filter(_.nonEmpty)

    parameterList.length match {
      case 2 => Option(new Question(parameterList(0), parameterList(1)))
      case _ => None
    }
  }

 }