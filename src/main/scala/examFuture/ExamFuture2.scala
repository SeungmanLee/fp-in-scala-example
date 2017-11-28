package examFuture

object ExamFuture2 extends App {
  import scala.concurrent._
  import ExecutionContext.Implicits.global
  import scala.io.Source

  def getUrlSpec: Future[Seq[String]] = Future {
    val f = Source.fromURL("http://www.w3.org/Addressing/URL/url-spec.txt")
    try f.getLines.toList finally f.close()
  }

  val urlSpec: Future[Seq[String]] = getUrlSpec

  def find(lines: Seq[String], word: String) = lines.zipWithIndex.collect{
    case (line, n) if line.contains(word) => (n, line)
  }.mkString("\n")

  urlSpec.foreach{
    lines => println(s"Found occurrences of 'telnet'\n${find(lines, "telnet")}\n")
  }

  urlSpec foreach {
    lines => println(s"Found occurrences of 'password'\n${find(lines, "password")}\n")
  }

  println("callbacks installed, continuing with other work")
  Thread.sleep(1000 * 10)

}
