package exercise
import org.scalatest.{Matchers, WordSpecLike}

class DiagonalDifferenceTest extends WordSpecLike with Matchers {
  "DiagonalDifference" should {
    "work" in {
      val arr = Array.ofDim[Int](3, 3)
      arr(0)(0) = 11
      arr(0)(1) = 2
      arr(0)(2) = 4
      arr(1)(0) = 4
      arr(1)(1) = 5
      arr(1)(2) = 6
      arr(2)(0) = 10
      arr(2)(1) = 8
      arr(2)(2) = -12
      new DiagonalDifference().diagonalDifference(arr) shouldBe 15
    }
  }
}
