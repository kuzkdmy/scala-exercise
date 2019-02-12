package tailrec.fibonacci
import scala.annotation.tailrec

object Fibonacci {
  // tailrec.fibonacci   1,  1, 2, 3, 5, 8, 13, 21
  // reverse    21, 13, 8, 5, 3, 2,  1,  1
  def fibonacci(n: Int): Either[IllegalArgumentException, BigInt] = {
    @tailrec
    def f(prev: BigInt, curr: BigInt, idx: Int): BigInt = {
      if (idx == 0) curr
      else f(curr, curr + prev, idx - 1)
    }
    n match {
      case 1 | 2         => Right(1)
      case el if el <= 0 => Left(new IllegalArgumentException("should be positive"))
      case _             => Right(f(1, 1, n - 2))
    }
  }
}
