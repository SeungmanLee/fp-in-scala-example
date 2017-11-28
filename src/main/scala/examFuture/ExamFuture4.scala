package examFuture

import scala.util.{Failure, Success}

object ExamFuture4 extends App {
  import scala.concurrent._
  import ExecutionContext.Implicits.global
  import scala.io.Source

  /**
    * 작업이 중간에 실패하면 실패까지만 진행되고 그 이후는 실행하지 않음
    *
    */
  val file: Future[String] = Future {
    Source.fromURL("http://www.w3.org/non-existent-url-spec.txt").mkString("\n")
//    Source.fromURL("http://www.w3.org/Addressing/URL/url-spec.txt").mkString
  }

  file foreach {
    text => println(s"foreach - $text")
  }

  /**
    * 실패시에만 호출
    */
  file.failed.foreach {
    case fnfe: java.io.FileNotFoundException => println(s"Cannot fild file - $fnfe")
    case t => println(s"#1 Failed due to $t")
  }

  /**
    * 성공 / 실패 결과에 따라서 항상 호출됨
    * 실패시  fild.failed 와 호출 순서는 비결정적 (순서가 그때그때 달라요) 이다
    */
  file.onComplete {
    case Success(text) => println(text)
    case Failure(t) => println(s"#2 Failed due to $t")
  }

  Thread.sleep(1000*10)


}
