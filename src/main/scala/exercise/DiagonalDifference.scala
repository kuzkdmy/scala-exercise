package exercise

class DiagonalDifference {
  def diagonalDifference(arr: Array[Array[Int]]): Int = {
    val maxIdx = arr.length - 1
    var left = 0
    var right = 0
    for (x <- 0 to maxIdx) {
      left += arr(x)(x)
      right += arr(maxIdx - x)(x)
    }
    Math.abs(left - right)
  }
}
