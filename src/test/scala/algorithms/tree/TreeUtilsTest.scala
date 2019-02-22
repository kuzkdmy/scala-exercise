package algorithms.tree
import algorithms.tree.TreeUtils.max
import org.scalatest.{Matchers, WordSpecLike}

class TreeUtilsTest extends WordSpecLike with Matchers {

  "TreeUtils" should {
    "find max in three" in {
      max(Node(1, Some(Node(2)), Some(Node(3)))) shouldBe 3
      max(Node(2, Some(Node(3)), Some(Node(1)))) shouldBe 3
      max(Node(3, Some(Node(1)), Some(Node(2)))) shouldBe 3
    }
    "correctly add node for empty tree" in {
      Seq(1).foldLeft(Tree[Int]()) {
        case (tree, childNodeValue) => tree.insert(childNodeValue)
      } shouldBe Tree(Some(Node(1)))
    }
    "correctly add node check two level tree" in {
      Seq(2, 1).foldLeft(Tree[Int]()) {
        case (tree, childNodeValue) => tree.insert(childNodeValue)
      } shouldBe Tree(
        Some(
          Node(
            value = 2,
            left = Some(Node(1)),
            right = None
          )
        )
      )
    }
    "correctly add node check insert to right empty node" in {
      val tree = Tree(Some(Node(value = 10, left = Some(Node(value = 5, left = Some(Node(3)))))))
      val expected = Tree(Some(Node(value = 10, left = Some(Node(value = 5, left = Some(Node(3)))), right = Some(Node(15)))))
      tree.insert(15) shouldBe expected
    }
    "correctly add node check insert to right existing node" in {
      val tree = Tree(Some(Node(value = 10, left = Some(Node(value = 5, left = Some(Node(3)))), right = Some(Node(15)))))
      val expected = Tree(Some(Node(value = 10, left = Some(Node(value = 5, left = Some(Node(3)))), right = Some(Node(15, left = Some(Node(14)))))))
      tree.insert(14) shouldBe expected
    }

    // todo
    "correctly add node check insert that modify root" ignore {
      Seq(1, 2).foldLeft(Tree[Int]()) {
        case (tree, childNodeValue) => tree.insert(childNodeValue)
      } shouldBe Tree(
        Some(
          Node(
            value = 2,
            left = Some(Node(1)),
            right = None
          )
        )
      )
    }
    "correctly add node check two level tree both sides" in {
      Seq(2, 1, 3).foldLeft(Tree[Int]()) {
        case (tree, childNodeValue) => tree.insert(childNodeValue)
      } shouldBe Tree(
        Some(
          Node(
            value = 2,
            left = Some(Node(1)),
            right = Some(Node(3))
          )
        )
      )
    }
    "correctly add node check three level tree both sides" in {
      Seq(10, 5, 3, 7, 15, 13, 17).foldLeft(Tree[Int]()) {
        case (tree, childNodeValue) => tree.insert(childNodeValue)
      } shouldBe Tree(
        Some(
          Node(
            value = 10,
            left = Some(
              Node(
                value = 5,
                left = Some(Node(3)),
                right = Some(Node(7))
              )
            ),
            right = Some(
              Node(
                value = 15,
                left = Some(Node(13)),
                right = Some(Node(17))
              )
            )
          )
        )
      )
    }
  }

}
