package tailrec.factorial

import scala.annotation.tailrec

object Factorial {
  // indexes(0=>1) =>   1,  2, 3,  4,   5
  // factorials    =>   1,  2, 6, 24, 120
  // reverse       => 120, 24, 6,  2,   1
  def factorial(n: Int): Either[IllegalArgumentException, BigInt] = {
    @tailrec
    def fac(curr: BigInt, idx: Int): BigInt = {
      if (idx == 0) curr
      else fac(curr * idx, idx - 1)
    }
    n match {
      case 0            => Right(1)
      case el if el < 0 => Left(new IllegalArgumentException("should be positive"))
      case _            => Right(fac(1, n))
    }
  }
}
