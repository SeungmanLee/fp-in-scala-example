
class A {
  class B

  def f(b: B) = println("Got my B!")
  def g(b: A#B) = println("Got a B.")
}

val a1 = new A

val a2 = new A

//a2.f(new a1.B)
a2.f(new a2.B)

a2.g(new a1.B)



val x: Either[String, Int] = Right(7)


val str = "a\nb"

s"$str"
raw"$str"

s"a\nb"
val rawStr = raw"a\nb"






