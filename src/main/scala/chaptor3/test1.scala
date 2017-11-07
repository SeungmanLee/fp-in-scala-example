package chaptor3

// illegal inheritance error
//case class myList[+A](tail: A, prev: List[A]) extends List[A]

object test1 {

  def main(args: Array[String]): Unit = {

    List("a", "b")
    val ex1: List[Double] = Nil
    val ex2: List[Int] = Cons(1, Nil)
    val ex3: List[String] = Cons("a", Cons("b", Nil))

    println(List.sum(ex2))
    println(List.product(ex1))
    println(List.sum(Cons(5, Cons(4, Nil))))
    println(List.product(Cons(2, Cons(3, Nil))))

//


//    println(List(1,2,3) match { case _ => 42})
//    println(List(1,2,3) match { case Cons(h, _) => h})
//    println(List(1,2,3) match { case Cons(_, t) => t})
//    println(List(1,2,3) match { case Nil => 42})


//    println(List.reverse(List(1,2,3)))

//    println(List.loop(1, List(2,3), Cons(1, List(2))))



  }

}
