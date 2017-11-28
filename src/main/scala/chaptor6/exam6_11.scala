package chaptor6

sealed trait Input
case object Coin extends Input
case object Turn extends Input

case class Machine(locked: Boolean, candies: Int, coins: Int)


object exam6_11 {


//  def simulateMachine(inputs: List[Input]): State[Machine, (Int, Int)] = {
//
//    val m = Machine(false, 5, 10)
//
//    for {
//      input <- inputs
//    } yield {
//      input match {
//        case Coin => {
//          val ca = m.candies - 1
//          val co = m.coins + 1
//          (Machine(false, ca, co), (ca, co))
//        }
//        case Turn => _
//      }
//
//
//    }
//
//  }





  def main(args: Array[String]): Unit = {

  }

}
