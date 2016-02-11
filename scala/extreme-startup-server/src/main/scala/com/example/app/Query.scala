package com.example.app

case class Query(var id: String, var question: String)

object Query {
  def apply(q: String): Query ={
    val parameterList = q
      .split(":\\s*", 2)
      .filter(_.nonEmpty)
    new Query(parameterList(0), parameterList(1))
  }
 }