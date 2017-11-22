package chaptor5


sealed trait Stream[+A]
case object Empty extends Stream[Nothing]
case class Cons[+A](h: () => A, t: () => Stream[A]) extends Stream[A]

object Stream {
  def cons[A](hd: => A, tl: => Stream[A]): Stream[A] = {
    lazy val head = hd
    lazy val tail = tl
    Cons(() => head, () => tail)
  }

  def empty[A]: Stream[A] = Empty

  def apply[A](as: A*): Stream[A] = {
    if (as.isEmpty) empty else cons(as.head, apply(as.tail: _*))
  }

//  def headOption = this match {
//    case Empty => None
//    case Cons(h, t) => Some(h())
//  }

//  def toList: List[A] = {
//    List()
//  }

//  def exists[A](p: A => Boolean): Boolean = this match {
//    case Cons(h, t) => p(h()) || t().exists(p)
//    case _ => false
//  }

//  def foldRight[B](z: => B)(f: (A, => B) => B): B = {
//    this match {
//      case Cons(h, t) => f(h(), t().foldRight(z)(f))
//      case _ => z
//    }
//  }


}


//class Stream {
//
//}
