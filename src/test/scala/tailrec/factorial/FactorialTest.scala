package tailrec.factorial
import tailrec.factorial.Factorial.factorial
import org.scalatest.{Matchers, WordSpecLike}

class FactorialTest extends WordSpecLike with Matchers {

  "Factorial" should {
    "expect left on negative input" in {
      factorial(-1).isLeft shouldBe true
    }
    "check positive seq" in {
      // (0 => 1), 1,  2, 6, 24, 120
      factorial(0).right.get shouldBe 1
      factorial(1).right.get shouldBe 1
      factorial(2).right.get shouldBe 2
      factorial(3).right.get shouldBe 6
      factorial(4).right.get shouldBe 24
      factorial(5).right.get shouldBe 120
    }
    "check work on big value" in {
      factorial(10000).isRight shouldBe true
    }
  }
}
