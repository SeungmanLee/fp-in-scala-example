import scala.util.Try


val p = ("Bob", 42)

p._1

p._2

val newB = p match { case (a, b) => b }


val p5 = ("bob", 42, false, true, "yes")

p5._1
p5._2
p5._3
p5._4
p5._5



val s = Some("abc")
val e = s.getOrElse("def")
val oe = s.orElse(Some("def"))
None.orElse(Some("ghi"))




Seq(1,2,3,4).map(_ * 2.2)





def lift[A, B](f: A => B): Option[A] => Option[B] = _ map f

val abs0: Option[Double] => Option[Double] = lift(math.abs)

abs0(Some(5.7))
abs0(Some(6.7))
abs0(Some(7.7))


abs0(None)

//val r:Option[Double] = Try{"hello".toDouble}
//abs0(r.toOption)


val r2: Option[Int] = Try{ "123".toInt}.toOption


//abs0()

//abs0(_*3)



def if2[A](cond: Boolean, onTrue: => A, onFalse: => A): A = {
  if (cond) onTrue else onFalse
}

if2(false, sys.error("fail"), 3)




def maybeTwice(b: Boolean, i: => Int) = if (b) i + i else 0
maybeTwice(true, { println("hi"); 1 + 41})

def maybeTwice2(b: Boolean, i: => Int) = {
  lazy val j = i
  if (b) j + j else 0
}
maybeTwice2(true, { println("hello"); 1 + 41})



