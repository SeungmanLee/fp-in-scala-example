package chaptor3

object exam3_13 {



  def main(args: Array[String]): Unit = {

    println(List.foldRight(List(1,2,3,4,5), 0)((a, b) => a + b))
    println(List.foldRight(List(1,2,3,4,5), 0)((a, b) => a + b))

    println(List.foldRightUsingFoldLeft(List(1,2,3,4,5), 0)((a, b) => a + b))
    println(List.foldRightUsingFoldLeft(List(1,2,3,4,5,6,7,8,9,10), 0)((a, b) => a + b))
//    println(foldRightFromLeft(Nil, 0)((a, b) => a + b))  // error. ambiguous reference   A: Nothing, B: Int
//    println(List.foldLeft(List(), 0)((a, b) => a + b))    // error. ambiguous reference  Nothing , Int


    println(List.foldRight(List(1,2,3,4,5), 0)((a, b) => { println( s"a=$a, b=$b" ); a + b }))

    println(List.foldRightUsingFoldLeft(List(1,2,3,4,5), 0)((a, b) => { println( s"a=$a, b=$b" ); a + b }))

    println(List.foldLeft(List(1,2,3,4,5), 0)((a, b) => { println( s"a=$a, b=$b" ); a + b }))

  }
}
