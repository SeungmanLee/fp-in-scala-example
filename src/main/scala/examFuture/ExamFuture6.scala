package examFuture

import scala.util.{Failure, Success}

object ExamFuture6 extends App {
  import scala.concurrent._
  import ExecutionContext.Implicits.global
  import scala.io.Source

  val buildFile = Future { Source.fromFile("build.sbt").getLines()}

  val longestBuildLine = buildFile.map(lines => lines.maxBy(_.length))

  longestBuildLine.onComplete{
    case Success(line) => println(s"the longest line is $line")
    case Failure(t) => println(s"Failed due to $t")
  }

  Thread.sleep(1000*10)

}
