package com.example.app

import org.specs2.mutable.Specification

class QueryTest extends Specification {
  "QueryTest" should {
    "apply" in {
      Query("foo: bar") must_== new Query("foo", "bar")
      Query("foo: bar: baz") must_== new Query("foo", "bar: baz")
      Query("foo:bar: baz") must_== new Query("foo", "bar: baz")
    }
  }
}
