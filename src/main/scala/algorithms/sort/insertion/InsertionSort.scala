package algorithms.sort.insertion
import scala.Ordered._
object InsertionSort {
  // more functional, sure this is not for pure book example with mutable array
  def insertionSort[T](list: Seq[T])(implicit ordering: Ordering[T]): Seq[T] = {
    def insert(list: List[T], el: T): List[T] = {
      val (lt, gt) = list.span(_ < el)
      lt ::: (el :: gt)
    }
    list.foldLeft(List[T]())((acc, e) => insert(acc, e))
  }
}
