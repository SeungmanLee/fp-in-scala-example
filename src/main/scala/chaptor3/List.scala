package chaptor3


sealed trait List[+A]
case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {


  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case Cons(x, xs) => x + sum(xs)
  }

  def product(ds: List[Double]): Double = ds match {
    case Nil => 1.0
    case Cons(0.0, _) => 0.0
    case Cons(x, xs) => x * product(xs)
  }

  def tail[A](as: List[A]): List[A] = as match {
    case Nil => Nil
    case Cons(_, xs) => xs
  }

  def drop[A](l: List[A], n: Int): List[A] = {
    if (n <= 0) l
    else {
      val xs = l match {
        case Cons(h, t) => t
        case Nil => Nil
      }
      drop(xs, n - 1)
    }
  }

  def dropWhile[A](l: List[A], f: A => Boolean): List[A] = {
    l match {
      case Cons(h, t) => {
        if (f(h)) t
        else dropWhile(t, f)
      }
      case _ => Nil
    }
  }

  def setHead[A](newHead: A, xs: List[A]): List[A] = {
    Cons(newHead, tail(xs))
  }

  def apply[A](as: A*): List[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))

  def reverse(value: List[Int]): Any = ???

  def init[A](l: List[A]): List[A] = ???
  //  {
  //    def loop(m: List[A]) = {
  //      m match {
  //        case Nil => Nil
  //        case Cons(h, Nil) => Nil
  //        case Cons(h1, Cons(h2, Nil)) => Cons(h1, Nil)
  //      }
  //    }
  //
  //    l match {
  //      case Cons(h1, t) => loop(t)
  //      case Nil => Nil
  //    }
  //  }
}

