package chaptor1


class Coffee {
  val price: Int = 0
}

case class Charge(cc: CreditCard, amount: Double) {
  def combine(other: Charge): Charge =
    if (cc == other.cc)
      Charge(cc, amount + other.amount)
    else
      throw new Exception("Can't combine charges to different cards")
}

class CreditCard {
  def charge(creditCard: CreditCard, price: Int) = Charge(creditCard, price)
}

class Payment {}

class Cafe {

  def buyCoffee(cc: CreditCard, p: Payment): (Coffee, Charge) = {
    val cup = new Coffee()
    (cup, cc.charge(cc, cup.price))

  }

  def coalesce(charges: List[Charge]): List[Charge] =
    charges.groupBy(_.cc).values.map(_.reduce(_ combine _)).toList
}


object chaptor1 {

  def main(args: Array[String]): Unit = {



  }

}
