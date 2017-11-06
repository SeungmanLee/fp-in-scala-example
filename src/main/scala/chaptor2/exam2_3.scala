package chaptor2

object exam2_3 {

  def partial[A, B, C](a: A, f: (A, B) => C): B => C = {
    (b: B) => f(a, b)
  }

  def curry[A, B, C](f: (A, B) => C): A => (B => C) = {
    (a: A) => partial(a, f)
  }


  def main(args: Array[String]): Unit = {

    val c1 = curry((a: Int, b: Int) => a + b)
    val c2 = c1(7)
    println(c2(9))
    println(c2(10))
    println(c2(11))

  }
}
