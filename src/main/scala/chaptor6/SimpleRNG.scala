package chaptor6


trait RNG {
  def nextInt: (Int, RNG)
}

case class SimpleRNG(seed: Long) extends RNG {
  def nextInt: (Int, RNG) = {
    val newSeed = (seed * 0x5DEECE66DL + 0xBL) & 0xFFFFFFFFFFFFFL
    val nextRNG = SimpleRNG(newSeed)
    val n = (newSeed >>> 16).toInt
    (n, nextRNG)
  }

}


object RNG {

  type Rand[+A] = RNG => (A, RNG)

  def randomPair(rng: RNG): ((Int, Int), RNG) = {
    val (i1, rng2) = rng.nextInt
    val (i2, rng3) = rng2.nextInt
    ((i1, i2), rng3)
  }

  def nonNegativeInt(rng: RNG): (Int, RNG) = {
    val (i, rng2) = rng.nextInt
    if (i < 0) nonNegativeInt(rng2)
    else (i, rng2)
  }

  def nonPositiveInt(rng: RNG): (Int, RNG) = {
    val (i, rng2) = rng.nextInt
    if (i > 0) nonPositiveInt(rng2)
    else (i, rng2)
  }

  val int: Rand[Int] = _.nextInt

  def double(rng: RNG): (Double, RNG) = {
    val (i1, rng2) = RNG.nonNegativeInt(rng)
    val res = i1.toDouble / Int.MaxValue
    (res, rng2)
  }

  def unit[A](a: A): Rand[A] = {
    rng => (a, rng)
  }

  def nonNegativeEven: Rand[Int] = {
    map(nonNegativeInt)(i => i - i % 2)
  }

  def map[A, B](s: Rand[A])(f: A => B): Rand[B] = {
    rng => {
      val (a, rng2) = s(rng)
      (f(a), rng2)
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

  val randIntDouble: Rand[(Int, Double)] = both(int, double)

  val randDoubleInt: Rand[(Double, Int)] = both(double, int)

  def flatMap[A, B](f: Rand[A])(g: A => Rand[B]): Rand[B] = {
    rng => {
      val (a, rng2) = f(rng)
      g(a)(rng2)
    }
  }

  def nonNegativeLessThan(n: Int): Rand[Int] = {
    flatMap(nonNegativeInt){
      i => {
        val mod = i % n
        if (i + (n - 1 ) - mod >= 0)
          unit(mod)
        else
          nonNegativeLessThan(n)
      }
    }
  }


  def rollDie: Rand[Int] = map(nonNegativeLessThan(6))(_ + 1)
}




object SimpleRNG {
  def main(args: Array[String]): Unit = {

    println(RNG.double(SimpleRNG(1)))
    println(RNG.double(SimpleRNG(2)))

    val a = RNG.int

    println(a)
    println(SimpleRNG(1))
    println(a(SimpleRNG(1)))

    println(RNG.randIntDouble)
    println(RNG.randIntDouble(SimpleRNG(1)))
    println(RNG.randIntDouble(SimpleRNG(21)))

    println(RNG.randDoubleInt)
    println(RNG.randDoubleInt(SimpleRNG(1)))
    println(RNG.randDoubleInt(SimpleRNG(21)))

    println(RNG.nonNegativeEven)
    println(RNG.nonNegativeEven(SimpleRNG(1)))
    println(RNG.nonNegativeEven(SimpleRNG(2)))
    println(RNG.nonNegativeEven(SimpleRNG(3)))
    println(RNG.nonNegativeEven(SimpleRNG(4)))
    println(RNG.nonNegativeEven(SimpleRNG(5)))
    println(RNG.nonNegativeEven(SimpleRNG(6)))
    println(RNG.nonNegativeEven(SimpleRNG(7)))
    println(RNG.nonNegativeEven(SimpleRNG(8)))
    println(RNG.nonNegativeEven(SimpleRNG(9)))
    println(RNG.nonNegativeEven(SimpleRNG(21)))


    println(RNG.nonNegativeLessThan(500)(SimpleRNG(1)))
    println(RNG.nonNegativeLessThan(400)(SimpleRNG(1)))
    println(RNG.nonNegativeLessThan(300)(SimpleRNG(1)))

    println(RNG.rollDie)
    println(RNG.rollDie(SimpleRNG(1)))
    println(RNG.rollDie(SimpleRNG(2)))
    println(RNG.rollDie(SimpleRNG(3)))
    println(RNG.rollDie(SimpleRNG(4)))
    println(RNG.rollDie(SimpleRNG(5)))
    println(RNG.rollDie(SimpleRNG(6)))
    println(RNG.rollDie(SimpleRNG(7)))
    println(RNG.rollDie(SimpleRNG(8)))
    println(RNG.rollDie(SimpleRNG(9)))
    println(RNG.rollDie(SimpleRNG(10)))

  }
}


