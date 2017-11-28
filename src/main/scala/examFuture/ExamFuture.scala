package examFuture

object ExamFuture extends App {
  import scala.concurrent._
  import ExecutionContext.Implicits.global
  import scala.io.Source


  val myFuture: Future[String] = Future {
    val f = Source.fromFile("build.sbt")
    try f.getLines().mkString("\n") finally f.close()
  }

  println(s"started reading build file asynchronously")
  println(s"status: ${myFuture.isCompleted}")
  Thread.sleep(100)
  println(s"status: ${myFuture.isCompleted}")
  println(s"value: ${myFuture.value}")



  Future {
    println(s"the future is here")
  }

  println(s"the future is coming")





}
