package chaptor2

object exam2_5 {


  def compose[A, B, C](f: B => C, g: A => B): A => C = {
    (a: A) => f(g(a: A))
  }

  def main(args: Array[String]): Unit = {

    def f = (b: Double) => b * 3
    def g = (a: Double) => a / 5

    def funcComp = compose(f, g)

    println(funcComp(5))


  }
}
