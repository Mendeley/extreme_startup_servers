package com.example.app

import org.specs2.mutable.Specification

class QuestionTest extends Specification {
  "QuestionTest" should {
    "apply" in {
      Question("") must_== None
      Question("foo") must_== None
      Question("foo: ") must_== None
      Question("foo: bar") must_== Some(new Question("foo", "bar"))
      Question("foo: bar: baz") must_== Some(new Question("foo", "bar: baz"))
      Question("foo:bar: baz") must_== Some(new Question("foo", "bar: baz"))
    }
  }
}
