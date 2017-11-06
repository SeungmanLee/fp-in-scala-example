package chaptor3

object exam3_2 {
  def main(args: Array[String]): Unit = {
    val y = List(1,2,3,4,5)
    println(List.tail(y)) // 2,3,4,5

    val z = List("a","b","c","d")
    println(List.tail(z)) // b,c,d
  }
}
