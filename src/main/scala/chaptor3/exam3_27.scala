package chaptor3

object exam3_27 {

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

  def main(args: Array[String]): Unit = {

    println(depth(Leaf(5)))
    println(depth(Branch(Leaf(5), Leaf(3))))
    println(depth(Branch(Branch(Leaf(7), Leaf(3)),Branch(Leaf(5), Leaf(3)))))
    println(depth(Branch(Branch(Leaf(7), Leaf(9)),Branch(Leaf(5), Leaf(3)))))
    println(depth(Branch(Branch(Leaf(7), Leaf(3)),Branch(Leaf(11), Leaf(3)))))
    println(depth(Branch(Branch(Leaf(7), Leaf(3)),Branch(Leaf(11), Leaf(13)))))
    println(depth(Branch(Branch(Leaf(7), Leaf(3)),Branch(Leaf(11), Branch(Leaf(13), Branch(Leaf(15), Leaf(17)))))))

  }
}
