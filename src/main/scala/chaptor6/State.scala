package chaptor6



case class State[S, +A](run: S => (A, S))

object State {

  type State[S, +A] = S => (A, S)
  type Rand[A] = State[RNG, A]


  def map[S, A, B](a: State[S, A])(f: A => B): State[S, B] = {
    s => {
      val (b, st) = a(s)
      (f(b), st)
    }
  }



  def map2[A, B, C](ra: Rand[A], rb: Rand[B])(f: (A, B) => C): Rand[C] = {
    rng => {
      val (a, rng2) = ra(rng)
      val (b, rng3) = rb(rng2)
      (f(a, b), rng3)
    }
  }

  def both[A, B](ra: Rand[A], rb: Rand[B]): Rand[(A, B)] = {
    map2(ra, rb)((_, _))
  }


  def flatMap[A, B](f: Rand[A])(g: A => Rand[B]): Rand[B] = {
    rng => {
      val (a, rng2) = f(rng)
      g(a)(rng2)
    }
  }






  def main(args: Array[String]): Unit = {
    println("hello ")



  }

}
