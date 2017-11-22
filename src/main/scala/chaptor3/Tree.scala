package chaptor3

sealed trait Tree[+A]
case class Leaf[A](value: A) extends Tree[A]
case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

object Tree {
  def size[A](t: Tree[A]): Int = {
    t match {
      case Leaf(x) => 1
      case Branch(l, r) => 1 + size(l) + size(r)
    }
  }

  def maximum[A](t: Tree[Int]): Int = {
    t match {
      case Leaf(x) => x
      case Branch(l, r) => maximum(l) max maximum(r)
    }
  }

  def depth[A](t: Tree[A]): Int = {
    t match {
      case Leaf(x) => 1
      case Branch(l, r) => {
        if( depth(l) > depth(r)) {
          1 + depth(l)
        } else {
          1 + depth(r)
        }
      }
    }
  }

  def map[A, B](t: Tree[A])(f: A => B): Tree[B] = {
    t match {
      case Leaf(x) => Leaf(f(x))
      case Branch(l, r) => Branch(map(l)(f), map(r)(f))
    }
  }

}

