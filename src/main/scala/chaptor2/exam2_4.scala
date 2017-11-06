package chaptor2

object exam2_4 {

  def partial[A, B, C](a: A, f: (A, B) => C): B => C = {
    (b: B) => f(a, b)
  }

  def curry[A, B, C](f: (A, B) => C): A => (B => C) = {
    (a: A) => partial(a, f)
  }




  def uncurry[A, B, C](f: A => (B => C)): (A, B) => C = {
    (a: A, b: B) => f(a)(b)
  }

  def main(args: Array[String]): Unit = {

    val funcCurry = curry((a: Int, b: Int) => (a * b))
    println(funcCurry(2)(3))
    println(funcCurry(5)(7))

    println("======================")
    val unCurry = uncurry(funcCurry)
    println(unCurry(8, 7))




  }

}
