package chaptor4

object exam4_1_1 {


  def failingFn(i: Int): Int = {
    try {
      val x = 42 + 5
      x + ((throw new Exception("fail!")): Int)
    }
    catch {case e: Exception => 43}
  }


  def main(args: Array[String]): Unit = {
    println(failingFn(42))
  }
}
