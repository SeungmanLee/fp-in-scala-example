package chaptor2

object MyModule {

  def abs(n: Int): Int =
    if (n < 0) -n
    else n


  private def formatAbs(x: Int) = {
    val msg = "The absolute value of %d is %d"
    msg.format(x, abs(x))
  }

  private def formatFactorial(x: Int) = {
    val msg = "The factorial of %d is %d."
    msg.format(x, factorial(x))
  }

  def factorial(n: Int): Int = {
    @annotation.tailrec
    def go(n: Int, acc: Int): Int =
      if (n <= 0) acc
      else go(n-1, n*acc)

    go(n, 1)
  }

  def formatResult(name: String, n: Int, f: Int => Int) = {
    val msg = "The %s of %d is %d."
    msg.format(name, n, f(n))
  }


  def findFirst(ss: Array[String], key: String): Int = {
    @annotation.tailrec
    def loop(n: Int): Int =
      if (n >= ss.length) -1
      else if (ss(n) == key) n
      else loop(n + 1)

    loop(0)
  }

  def findFirstGeneric[A](as: Array[A], p: A => Boolean): Int = {
    def loop(n: Int): Int = {
      if (n >= as.length) -1
      else if (p(as(n))) n
      else loop(n + 1)
    }
    loop(0)
  }

  def partial1[A, B, C](a: A, f: (A, B) => C): B => C = {
    (b: B) => f (a, b)
  }





  def main(args: Array[String]): Unit = {
    println(formatAbs(-42))

    println(formatFactorial(1))
    println(formatFactorial(2))
    println(formatFactorial(3))
    println(formatFactorial(4))
    println(formatFactorial(5))

    println(formatResult("absolute", -88, abs))
    println(formatResult("factorial", 5, factorial))
    println(formatResult("factorial", 7, factorial))

    val arr = List("a", "b", "c", "d").toArray
    println(findFirst(arr, "a"))
    println(findFirst(arr, "b"))
    println(findFirst(arr, "c"))
    println(findFirst(arr, "d"))
    println(findFirst(arr, "e"))

    println("========================")
    val arrInt = List(1, 2, 3, 4).toArray
    def mydef(n: Int): Boolean = {
      if (n == 3) true
      else false
    }

    println(findFirstGeneric[Int](arrInt, mydef))
    println(findFirstGeneric[Int](arrInt, _ == 3))

    println("========================")
    val func1 = partial1(5, (a: Int, b: Int) => a + b)
    println(func1(3))
    println(func1(5))


  }


}
