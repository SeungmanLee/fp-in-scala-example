package examFuture

object ExamFuture3 extends App {
  import scala.concurrent._
  import ExecutionContext.Implicits.global
  import scala.io.Source

  val urlSpec: Future[String] = Future {
    Source.fromURL("http://www.w3.org/non-existent-url-spec.txt").mkString
//    Source.fromURL("http://www.w3.org/Addressing/URL/url-spec.txt").mkString

  }

  // 정상적인 경우 호출되지 않음. 실패한 경우에만 호출됨
  urlSpec.failed.foreach{
    case t => println(s"exception occured - $t")
  }

  Thread.sleep(1000*10)






}
