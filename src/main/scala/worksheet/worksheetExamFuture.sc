


val fruits = Seq("apple", "banana", "orange")

fruits.map(_.toUpperCase)

fruits.flatMap(_.toUpperCase)


def toInt(s: String): Option[Int] = {
  try {
    Some(Integer.parseInt(s.trim))
  } catch {
    case e: Exception => None
  }
}

val strings = Seq("1", "2", "3", "foo", "bar")

val strMap = strings.map(toInt)

val strFlatMap = strings.flatMap(toInt)

strFlatMap.sum


