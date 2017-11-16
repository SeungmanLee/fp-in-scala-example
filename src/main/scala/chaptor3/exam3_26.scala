package chaptor3

object exam3_26 {

  def maximum[A](t: Tree[Int]): Int = {
    t match {
      case Leaf(x) => x
      case Branch(l, r) => maximum(l) max maximum(r)
    }
  }

  def main(args: Array[String]): Unit = {

    println(maximum(Leaf(5)))
    println(maximum(Branch(Leaf(5), Leaf(3))))
    println(maximum(Branch(Branch(Leaf(7), Leaf(3)),Branch(Leaf(5), Leaf(3)))))
    println(maximum(Branch(Branch(Leaf(7), Leaf(9)),Branch(Leaf(5), Leaf(3)))))
    println(maximum(Branch(Branch(Leaf(7), Leaf(3)),Branch(Leaf(11), Leaf(3)))))
    println(maximum(Branch(Branch(Leaf(7), Leaf(3)),Branch(Leaf(11), Leaf(13)))))

  }
}
