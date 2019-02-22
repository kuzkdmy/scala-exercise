package algorithms.tree
import com.github.ghik.silencer.silent

import scala.Ordered._
import scala.annotation.tailrec

case class Tree[T](rootNode: Option[Node[T]] = None)
case class Node[T](value: T, left: Option[Node[T]] = None, right: Option[Node[T]] = None)

case object Tree {
  // just don't care that not binary tree will get this method,
  // only want to play with copy on immutable tree
  // todo smart insert in the middle that change tree
  @silent
  implicit class BinaryTree[T](val tree: Tree[T]) extends AnyVal {
    def insert(newNodeValue: T)(implicit ord: Ordering[T]): Tree[T] = {
      @tailrec
      def addFromNode(nodeOpt: Option[Node[T]], copyChain: Seq[NodeFlow[T]])(implicit ord: Ordering[T]): Tree[T] = {
        nodeOpt match {
          case None =>
            def rootWithNewNode(bottomNode: Node[T], chain: Seq[NodeFlow[T]]): Node[T] = {
              chain match {
                case Nil => bottomNode
                case head :: tail =>
                  rootWithNewNode(head.toSide match {
                    case LeftNodeSide  => head.toNode.copy(left = Some(bottomNode))
                    case RightNodeSide => head.toNode.copy(right = Some(bottomNode))
                  }, tail)
              }
            }
            tree.copy(rootNode = Some(rootWithNewNode(Node(newNodeValue), copyChain)))
          case Some(node) =>
            if (newNodeValue > node.value) addFromNode(node.right, NodeFlow(node, RightNodeSide) +: copyChain)
            else if (newNodeValue < node.value) addFromNode(node.left, NodeFlow(node, LeftNodeSide) +: copyChain)
            else tree
        }
      }
      addFromNode(tree.rootNode, Seq.empty)
    }
  }
  private[this] case class NodeFlow[T](toNode: Node[T], toSide: NodeSide)
  sealed private[this] trait NodeSide {}
  private[this] case object LeftNodeSide extends NodeSide
  private[this] case object RightNodeSide extends NodeSide
}
