package chaptor3

object exam3_16 {

  def allAddOne(as: List[Int]) = {
    as match {
      case Cons(x, xs) => List.reverse(List.foldLeft(xs, Cons(x + 1, Nil))((b, a) => Cons(a + 1, b)))
      case _ => Nil
    }
  }

  def main(args: Array[String]): Unit = {

    println(allAddOne(List(1,2,3,4,5)))
    println(allAddOne(List()))

  }

}
