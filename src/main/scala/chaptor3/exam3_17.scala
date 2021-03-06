package chaptor3

object exam3_17 {

  def convertListDoubleToString(as: List[Double]): List[String] = {
    as match {
      case Cons(x, xs) => List.reverse(List.foldLeft(xs, Cons(x.toString, Nil))((b, a) => Cons(a.toString, b)))
      case _ => Nil
    }
  }



  def main(args: Array[String]): Unit = {
    println(convertListDoubleToString(List(1,2,3,4,5)))
    println(convertListDoubleToString(List()))

    println(List.map(List(1.0,2.0,3.0,4.0,5.0))(_.toString))
  }
}
