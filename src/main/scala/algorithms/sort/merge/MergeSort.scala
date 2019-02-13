package algorithms.sort.merge
import com.github.ghik.silencer.silent

import scala.Ordered._
import scala.annotation.tailrec

object MergeSort {
  def mergeSort[T](seq: Seq[T])(implicit ordering: Ordering[T]): Seq[T] = {
    @tailrec
    @silent
    def merge(ls: Seq[T], rs: Seq[T], acc: Seq[T] = Seq()): Seq[T] = {
      (ls, rs) match {
        case (Nil, _) => acc ++ rs
        case (_, Nil) => acc ++ ls
        case (l :: lt, r :: rt) =>
          if (l < r) merge(lt, rs, acc :+ l)
          else merge(ls, rt, acc :+ r)
      }
    }
    val n = seq.length / 2
    if (n == 0) seq
    else {
      val (left, right) = seq splitAt n
      merge(mergeSort(left), mergeSort(right))
    }
  }
}
