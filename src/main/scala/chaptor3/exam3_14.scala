package chaptor3

object exam3_14 {

  def appendFoldRight[A](as: List[A], attach: A) = {
    List.foldRight(as, Cons(attach, Nil))((b, a) => Cons(b, a))
  }

  def appendFoldLeft[A](as: List[A], attach: A) = {
    List.foldLeft(List.reverse(as), Cons(attach, Nil))((b, a) => Cons(a, b))
  }

  def main(args: Array[String]): Unit = {
    println(appendFoldRight(List(1,2,3,4), 5))
    println(appendFoldLeft(List(1,2,3,4), 5))
  }
}
