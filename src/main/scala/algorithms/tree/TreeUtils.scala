package algorithms.tree
import cats.kernel.Monoid
import cats.syntax.semigroup._

object TreeUtils {
  def max[T](node: Node[T])(implicit ordering: Ordering[T]): T = {
    val nodeVal = node.value
    val leftMax = node.left.map(n => max(n)(ordering)).getOrElse(nodeVal)
    val rightMax = node.right.map(n => max(n)(ordering)).getOrElse(nodeVal)
    Seq(nodeVal, leftMax, rightMax).max
  }

  def sum[T](node: Node[T])(implicit ev: Monoid[T]): T = {
    node.value |+| node.left.map(n => sum(n)(ev)).getOrElse(ev.empty) |+| node.right.map(n => sum(n)(ev)).getOrElse(ev.empty)
  }
}
