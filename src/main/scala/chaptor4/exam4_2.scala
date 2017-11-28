package chaptor4

object exam4_2 {

  def variance(xs: Seq[Double]): Option[Double] = {

    //    평균 : m
    //    요소들 : x
    //    분산 : math.pow(x - m, 2)

    //    xs.head
    def mean(xs: Seq[Double]): Option[Double] = {
      if (xs.isEmpty) None
      else Some(xs.sum / xs.length)
    }

    val mo = mean(xs)

//    val vari = xs.map {
//      x => {
//        mo.flatMap {
//          m => {
//            Some(math.pow(x - m, 2))
//          }
//        }
//      }
//    }
//    mean(vari.map(_.get))

    mo.flatMap(m => mean(xs.map(x => math.pow(x - m, 2))))
  }

  def main(args: Array[String]): Unit = {
    println(variance(Seq(1,2,3,4,5)))
  }

}
