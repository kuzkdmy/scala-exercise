package algorithms.sort.insertion
import algorithms.sort.insertion.InsertionSort.insertionSort
import org.scalatest.{Matchers, WordSpecLike}

class InsertionSortTest extends WordSpecLike with Matchers {

  "InsertionSort" should {
    "work with empty seq" in {
      insertionSort(Seq.empty[Int]) shouldBe Nil
    }
    "sort seq" in {
      insertionSort(Seq(3, 2, 1, 4, 5, 6)) shouldBe Seq(1, 2, 3, 4, 5, 6)
    }
  }
}
