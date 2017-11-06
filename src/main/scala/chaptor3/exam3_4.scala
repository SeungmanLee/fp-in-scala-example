package chaptor3

object exam3_4 {


  def main(args: Array[String]): Unit = {

    val x = List(1,2,3,4,5)
    val y = List.drop(x, 3)

    println(x)
    println(y)

    println(List.drop(List(), 3)) // Nil
    println(List.drop(List(1,2,3), 9)) // Nil



  }
}
