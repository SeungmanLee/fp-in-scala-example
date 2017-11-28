package examFuture

object ExamFuture9 extends App {
  import scala.concurrent._
  import ExecutionContext.Implicits.global
  import scala.io.Source

  val netiquette = Future { Source.fromURL("http://www.ietf.org/rfc/rfc1855.txt").mkString }
  val urlSpec = Future { Source.fromURL("http://www.w3.org/Addressing/URL/url-spec.txt").mkString }

//  val answer = netiquette.flatMap{ nettext =>
//    urlSpec.map { urlText =>
//      s"First, read this: $nettext . Now, try this: $urlText"
//    }
//  }

  val answer = for {
    nettext <- netiquette
    urlText <- urlSpec
  } yield s"First, read this: $nettext . Now, try this: $urlText"

  answer.foreach{
    case contents => println(contents)
  }

  Thread.sleep(1000*10)
}
