package chaptor3


object exam3_15 {


  def flatten[A](as: List[List[A]]) = {
//    List.foldRight(as, Cons())


    as match {
      case Cons(x, xs) => List.foldRight(as, Cons(x, Nil)){
        (a, b) => Cons(a, b)
      }
//      {
//        x match
//        {
//          case Cons(y, ys) => List.foldRight(ys, Cons(y, Nil))((a, b) => Cons(a, b))
//          case _ => Nil
//        }
//      }
    }

//    val l = immutable.List(1,2,3)
//    l.flatten
  }


  /**
    * ㅠㅠ GG  아직은 때가 아니다.. ㅠㅠ
    * @param args
    */
  def main(args: Array[String]): Unit = {

    println(List(List(1,2,3,4),List(5,6,7),List(8,9)))
    println(flatten(List(List(1,2,3,4),List(5,6,7),List(8,9))))


//    println(immutable.List(immutable.List(1,2,3),immutable.List(4,5,6),immutable.List(7,8,9)).flatten)
  }
}
