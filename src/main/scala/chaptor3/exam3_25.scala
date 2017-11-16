package chaptor3

object exam3_25 {

  def size[A](t: Tree[A]): Int = {
    t match {
      case Leaf(x) => 1
      case Branch(l, r) => 1 + size(l) + size(r)
    }
  }


  def main(args: Array[String]): Unit = {

    println(size(Leaf(5)))
    println(size(Branch(Leaf(5), Leaf(3))))
    println(size(Branch(Branch(Leaf(5), Leaf(3)),Branch(Leaf(5), Leaf(3)))))
  }
}
