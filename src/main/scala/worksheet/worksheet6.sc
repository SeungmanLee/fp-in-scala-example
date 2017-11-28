import chaptor6.RNG.Rand
import chaptor6.{RNG, SimpleRNG}

val rng = SimpleRNG(42)

val (n1, rng2) = rng.nextInt

val (n2, rng3) = rng2.nextInt

RNG.randomPair(rng3)

val (n3, rng4) = RNG.nonNegativeInt(rng)

RNG.nonNegativeInt(SimpleRNG(1).nextInt._2)
RNG.nonNegativeInt(SimpleRNG(-43).nextInt._2)
RNG.nonNegativeInt(SimpleRNG(40453).nextInt._2)
RNG.nonNegativeInt(SimpleRNG(23523543).nextInt._2)
RNG.nonNegativeInt(SimpleRNG(4453453).nextInt._2)
RNG.nonNegativeInt(SimpleRNG(-463464353).nextInt._2)
RNG.nonNegativeInt(SimpleRNG(42352353).nextInt._2)
RNG.nonNegativeInt(SimpleRNG(-64353543).nextInt._2)
RNG.nonNegativeInt(SimpleRNG(-3874873).nextInt._2)

RNG.nonPositiveInt(SimpleRNG(1).nextInt._2)
RNG.nonPositiveInt(SimpleRNG(-43).nextInt._2)
RNG.nonPositiveInt(SimpleRNG(40453).nextInt._2)
RNG.nonPositiveInt(SimpleRNG(23523543).nextInt._2)
RNG.nonPositiveInt(SimpleRNG(4453453).nextInt._2)
RNG.nonPositiveInt(SimpleRNG(-463464353).nextInt._2)
RNG.nonPositiveInt(SimpleRNG(42352353).nextInt._2)
RNG.nonPositiveInt(SimpleRNG(-64353543).nextInt._2)
RNG.nonPositiveInt(SimpleRNG(-3874873).nextInt._2)




RNG.double(SimpleRNG(1).nextInt._2)
RNG.double(SimpleRNG(2).nextInt._2)



val int: Rand[Int] = _.nextInt

5 - 5 % 2

6 - 6 % 2
7 - 7 % 2


//RNG.unit("a")
