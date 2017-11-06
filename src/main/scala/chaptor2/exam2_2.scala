package chaptor2

object exam2_2 {

  def isSorted[A](as: Array[A], ordered: (A,A) => Boolean): Boolean = {

    def canCalc(n: Int): Boolean = {
      (n < as.length && (n + 1) < as.length)
    }

    @annotation.tailrec
    def loop(n: Int): Boolean = {
      if (canCalc(n)) {
        if (ordered(as(n), as(n + 1))) loop(n + 1)
        else false
      } else true
    }

    loop(0)
  }

  def main(args: Array[String]): Unit = {

    println(isSorted[Int](Array(1, 2, 3, 5), _ < _))
    println(isSorted[Int](Array(1, 2, 3, 5, 3), _ < _))
    println(isSorted[Int](Array(1, 2), _ < _))
    println(isSorted[Int](Array(2, 1), _ < _))
    println(isSorted[Int](Array(1), _ < _))
    println(isSorted[Int](Array(5), _ < _))

  }

}
