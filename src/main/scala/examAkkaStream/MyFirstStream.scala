package examAkkaStream

import akka.actor.Props
import akka.stream.{Materializer, OverflowStrategy}

import scala.concurrent.Future

object MyFirstStream {
  import akka.actor.ActorSystem
  import akka.stream.ActorMaterializer
  import akka.stream.scaladsl._

  import scala.concurrent.ExecutionContext.Implicits.global


  def main(args: Array[String]): Unit = {
    implicit val system = ActorSystem("MyActorSystem")
    implicit val materializer: Materializer = ActorMaterializer()

    val sourceFromRange = Source(1 to 10)
    val sourceFromIterable = Source(List(1,2,3))
    val sourceFromFuture = Source(Future.successful("hello"))
    val sourceWithSingleElement = Source.single("just one")
    val sourceEmittingTheSameElement = Source.repeat("again and again")
    val emptySource = Source.empty


    val sinkPriningOutElements = Sink.foreach[String](println(_))
    val sinkCalculatingASumOfElements = Sink.fold[Int, Int](0)(_ + _)
    val sinkReturningTheFirstElement = Sink.head
    val sinkNoop = Sink.ignore



    val flowDoublingElements = Flow[Int].map(_ * 2)
    val flowFilteringOutOddElements = Flow[Int].filter(_ % 2 == 0)
    val flowBatchingElements = Flow[Int].grouped(10)
    val flowBufferingElements = Flow[String].buffer(1000, OverflowStrategy.backpressure)

    val streamCalculatingSumOfElements: RunnableGraph[Future[Int]] =
      sourceFromIterable.toMat(sinkCalculatingASumOfElements)(Keep.right)


    val streamCalculatingSumOfDoubledElements: RunnableGraph[Future[Int]] =
      sourceFromIterable.via(flowDoublingElements).toMat(sinkCalculatingASumOfElements)(Keep.right)

    // akka.stream.Materializer
    val sumOfElements = streamCalculatingSumOfElements.run()
    sumOfElements.foreach(println)

    val sumOfDoubledElements: Future[Int] = streamCalculatingSumOfDoubledElements.run()
    sumOfDoubledElements.foreach(println)


    sourceFromIterable.via(flowDoublingElements).runWith(sinkCalculatingASumOfElements).foreach(println)

    Source(List(1,2,3)).map(_ * 2).runFold(0)(_ + _).foreach(println)
//    val streamCalculatingSumOfElements: Runnable[Future[Int]] =

  }

}
