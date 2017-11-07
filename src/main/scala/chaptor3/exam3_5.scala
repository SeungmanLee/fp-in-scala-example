package chaptor3

object exam3_5 {

  def main(args: Array[String]): Unit = {

    val x = List(1,2,3,4,5)

    println(List.dropWhile(x, (a: Int) => a == 3))  // Cons(4,Cons(5,Nil))
    println(List.dropWhile(x, (a: Int) => a == 7))  // Nil
    println(List.dropWhile(x, (a: Int) => a == 0))  // Nil
    println(List.dropWhile(x, (a: Int) => a == 1))  // 2,3,4,5

    println("=============")
    println(List.dropWhile2(x)(y => y < 4))
  }

}
