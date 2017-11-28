package examFuture

object ExamFuture5 extends App {
  import scala.util._

  val threadName: Try[String] = Try(Thread.currentThread().getName)
  val someText: Try[String] = Try("Try objects are created synchronously")
//  val someText: Try[String] = Try(throw new Exception("Yeah this is exception  !"))
  val message: Try[String] = for {
    tn <- threadName
    st <- someText
  } yield s"$st, t = $tn"

  message match {
    case Success(msg) => println(msg)
    case Failure(t) => println(s"There should be no $t here")
  }

  Thread.sleep(1000*10)

}
