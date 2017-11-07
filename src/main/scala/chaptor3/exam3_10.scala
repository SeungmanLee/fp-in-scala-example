package chaptor3

object exam3_10 {


  def main(args: Array[String]): Unit = {
    println(List.foldLeft(List(1,2,3,4,5), 0)((x, y) => (x + y)))
    println(List.foldLeft(List(1,2,3,4,5), 0)((x, y) => (x * y)))
    println(List.foldLeft(List(1,2,3,4,5), 1)((x, y) => (x * y)))
  }
}
