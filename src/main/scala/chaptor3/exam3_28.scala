package chaptor3

object exam3_28 {

  def map[A, B](t: Tree[A])(f: A => B): Tree[B] = {
    t match {
      case Leaf(x) => Leaf(f(x))
      case Branch(l, r) => Branch(map(l)(f), map(r)(f))
    }
  }

  def main(args: Array[String]): Unit = {
    println(map(Leaf(5))(_ + 5))
    println(map(Branch(Leaf(5), Leaf(3)))(_ * 2))
    println(map(Branch(Branch(Leaf(7), Leaf(3)),Branch(Leaf(5), Leaf(3))))(_ * 2))
    println(map(Branch(Branch(Leaf(7), Leaf(9)),Branch(Leaf(5), Leaf(3))))(_ * 2))
    println(map(Branch(Branch(Leaf(7), Leaf(3)),Branch(Leaf(11), Leaf(3))))(_ * 2))
    println(map(Branch(Branch(Leaf(7), Leaf(3)),Branch(Leaf(11), Leaf(13))))(_ * 2))
    println(map(Branch(Branch(Leaf(7), Leaf(3)),Branch(Leaf(11), Branch(Leaf(13), Branch(Leaf(15), Leaf(17))))))(_ * 2))


    println(map(Leaf(5))(_ / 2))
    println(map(Branch(Leaf(5), Leaf(3)))(_ / 2))
    println(map(Branch(Branch(Leaf(7), Leaf(3)),Branch(Leaf(5), Leaf(3))))(_ / 2))
    println(map(Branch(Branch(Leaf(7), Leaf(9)),Branch(Leaf(5), Leaf(3))))(_ / 2))
    println(map(Branch(Branch(Leaf(7), Leaf(3)),Branch(Leaf(11), Leaf(3))))(_ / 2))
    println(map(Branch(Branch(Leaf(7), Leaf(3)),Branch(Leaf(11), Leaf(13))))(_ / 2))
    println(map(Branch(Branch(Leaf(7), Leaf(3)),Branch(Leaf(11), Branch(Leaf(13), Branch(Leaf(15), Leaf(17))))))(_ / 2))


    println(map(Leaf(5))(_.toString))
    println(map(Branch(Leaf(5), Leaf(3)))(_.toString))
    println(map(Branch(Branch(Leaf(7), Leaf(3)),Branch(Leaf(5), Leaf(3))))(_.toString))
    println(map(Branch(Branch(Leaf(7), Leaf(9)),Branch(Leaf(5), Leaf(3))))(_.toString))
    println(map(Branch(Branch(Leaf(7), Leaf(3)),Branch(Leaf(11), Leaf(3))))(_.toString))
    println(map(Branch(Branch(Leaf(7), Leaf(3)),Branch(Leaf(11), Leaf(13))))(_.toString))
    println(map(Branch(Branch(Leaf(7), Leaf(3)),Branch(Leaf(11), Branch(Leaf(13), Branch(Leaf(15), Leaf(17))))))(_.toString))

  }
}
