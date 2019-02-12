package tailrec.fibonacci
import tailrec.fibonacci.Fibonacci.fibonacci
import org.scalatest.{Matchers, WordSpecLike}

class FibonacciTest extends WordSpecLike with Matchers {

  "Fibonacci" should {
    "expect left on zero and on negative input" in {
      fibonacci(0).isLeft shouldBe true
      fibonacci(-1).isLeft shouldBe true
    }
    "check positive seq" in {
      // 1,  1, 2, 3, 5, 8, 13, 21
      fibonacci(1).right.get shouldBe 1
      fibonacci(2).right.get shouldBe 1
      fibonacci(3).right.get shouldBe 2
      fibonacci(4).right.get shouldBe 3
      fibonacci(5).right.get shouldBe 5
      fibonacci(6).right.get shouldBe 8
      fibonacci(7).right.get shouldBe 13
      fibonacci(8).right.get shouldBe 21
    }
    "check work on big value" in {
      fibonacci(10000).isRight shouldBe true
    }
  }
}
