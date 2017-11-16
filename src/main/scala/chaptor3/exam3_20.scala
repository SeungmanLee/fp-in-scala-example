package chaptor3

object exam3_20 {


  def flatMap[A, B](as: List[A])(f: A => List[B]): List[B] = {



    as match {
//      case Cons(x, xs) => {
//        val b = f(x)
//        b match {
//          case Cons(y, ys) => Cons(y, flatMap(xs)(f))
//        }
////        flatMap(xs)(f)
//      }
      case Cons(x, xs) => {

        flatMap(xs)(f)
//
//        f(x) match {
//          case Cons(b, bs) =>
//        }
      }
      case Nil => Nil
    }
  }

  def main(args: Array[String]): Unit = {
    println(flatMap(List(1,2,3))(i => List(i, i)))



  }
}
