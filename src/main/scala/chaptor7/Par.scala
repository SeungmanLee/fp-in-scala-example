package chaptor7

import scala.concurrent.duration.TimeUnit


class ExecutorService {
  def submit[A](a: Callable[A]): Future[A] = ???
}

trait Callable[A] { def call: A }
trait Future[A] {
  def get: A
  def get(timeout: Long, unit: TimeUnit): A
  def cancel(evenIfRunning: Boolean): Boolean
  def isDone: Boolean
  def isCanceled: Boolean
}


trait Par[A]

object Par {
  def unit[A](a: A): Par[A] = ???
//  def get[A](a: Par[A]): A = ???
  def map2[A, B, C](a: Par[A], b: Par[B], f: (A, B) => C): Par[C] = ???
  def fork[A](a: => Par[A]): Par[A] = ???
  def lazyUnit[A](a: => A): Par[A] = fork(unit(a))
  def run[A](a: Par[A]): A = ???

}




object Sum {

  def sum(ints: IndexedSeq[Int]): Int = {
    if (ints.size <= 1)
      ints.headOption getOrElse 0
    else {
      val (l, r) = ints.splitAt(ints.length / 2)
      val sumL: Par[Int] = Par.unit(sum(l))
      val sumR: Par[Int] = Par.unit(sum(r))
      Par.run(sumL) + Par.run(sumR)
    }
  }

//  def unit[A](a: => A): Par[A] = {
//
//  }
//
//  def get[A](a: Par[A]): A = {
//
//  }





  def main(args: Array[String]): Unit = {


//    println(sum(List(1,2,3,4,5)))


    println(sum(IndexedSeq(1,2,3,4,5,6,7,8,9)))


  }
}
