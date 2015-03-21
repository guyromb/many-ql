package ql.typechecker

import org.specs2.mutable.Specification
import ql.ast.{BooleanType, Form, Question, Sequence, Variable}

class DuplicateLabelsCheckerSpec extends Specification {

  val checker = new DuplicateLabelsChecker

  "duplicate labels checker" should {
    "detect duplicate label" in {
      val form = Form("form", Sequence(List(
        Question(BooleanType(), Variable("X"), "label", None),
        Question(BooleanType(), Variable("Y"), "label", None),
        Question(BooleanType(), Variable("Z"), "label", None),
        Question(BooleanType(), Variable("A"), "label2", None),
        Question(BooleanType(), Variable("B"), "label2", None)
      )))
      val result = List(Warning("Label \'label2\' is used 2 times"), Warning("Label \'label\' is used 3 times"))

      checker.check(form) must beEqualTo(result)
    }
  }
}