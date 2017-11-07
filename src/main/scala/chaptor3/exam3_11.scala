package chaptor3

object exam3_11 {


  def main(args: Array[String]): Unit = {

    def sum(as: List[Int]) = {
      List.foldLeft(as, 0)((x, y) => x + y)
    }

    def product(as: List[Double]) = {
      List.foldLeft(as, 1.0)(_ * _)
    }

    def length[A](as: List[A]): Int = {
      List.foldLeft(as, 0)((b, a) => 1 + b)
    }

    println(sum(List(1,2,3,4,5)))
    println(product(List(1,2,3,4,5)))
    println(length(List(1,2,3,4,5)))
  }
}
