package algorithms.sort.merge
import algorithms.sort.merge.MergeSort.mergeSort
import org.scalatest.{Matchers, WordSpecLike}

class MergeSortTest extends WordSpecLike with Matchers {

  "MergeSort" should {
    "work with empty seq" in {
      mergeSort(Seq.empty[Int]) shouldBe Nil
    }
    "sort seq" in {
      mergeSort(Seq(3, 2, 1, 4, 5, 6)) shouldBe Seq(1, 2, 3, 4, 5, 6)
    }
  }
}
