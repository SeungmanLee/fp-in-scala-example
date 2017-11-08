package chaptor3

object exam3_15 {


  def flatten[A](as: List[List[A]]) = {
//    as match {
//      case Cons(x, xs) => List.foldRight(xs, Cons(x, Nil))((a, b) => {
//        List.foldRight(a, b)((a, b) => Cons(a, b))
//      }  )
//    }


  }


  /**
    * ㅠㅠ GG  아직은 때가 아니다.. ㅠㅠ
    * @param args
    */
  def main(args: Array[String]): Unit = {

    println(List(List(1,2,3,4),List(5,6,7),List(8,9)))
    println(flatten(List(List(1,2,3,4),List(5,6,7),List(8,9))))

  }
}
