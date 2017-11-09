package chaptor3

object exam3_19 {

  def filter[A](as: List[A])(f: A => Boolean): List[A] = {
    as match {
      case Cons(x, xs) => {
        if (f(x)) {
          Cons(x, filter(xs)(f))
        } else {
          filter(xs)(f)
        }
      }
      case Nil => Nil
    }
  }

  def main(args: Array[String]): Unit = {
    println(filter(List(1,2,3,4,5))(_ <= 3))  // 1,2,3
    println(filter(List(1,2,3,4,5))(_ >= 3))  // 3,4,5
    println(filter(List(1,2,3,4,5))(a => (a % 2) == 0)) // 2,4
    println(filter(List(1,2,3,4,5))(_ % 2 == 0)) // 2,4
  }
}
