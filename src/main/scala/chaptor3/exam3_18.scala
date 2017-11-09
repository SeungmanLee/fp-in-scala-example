package chaptor3

object exam3_18 {



  def printSame[A](as: List[A]): List[A] = {
    as match {
      case Cons(x, xs) => Cons(x, printSame(xs))
      case Nil => Nil
    }
  }

  def main(args: Array[String]): Unit = {
    println(List.map(List(1,2,3,4,5))(a => (a + 1).toString))
    println(List.map(List(1,2,3,4,5))(a => a.toString))
    println(printSame(List(1,2,3,4,5)))
  }
}
