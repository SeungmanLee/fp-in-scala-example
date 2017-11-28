package chaptor4

sealed trait Option[+A]{
  def isEmpty: Boolean
  def get: A

  def map[B](f: A => B): Option[B] = {
    if (isEmpty) None
    else
      Some(f(get))
  }

  def flatMap[B](f: A => Option[B]): Option[B] = {
    if (isEmpty) None
    else f(get)
  }

  def getOrElse[B >: A](default: => B): B = {
    if (isEmpty) default else get
  }

  def orElse[B >: A](ob: => Option[B]): Option[B] = {
    if (isEmpty) ob else Some(get)
  }

  def filter(f: A => Boolean): Option[A] = {
    if (isEmpty) None else if (f(get)) Some(get) else None
  }
}

case class Some[+A](v: A) extends Option[A] {
  override def isEmpty = false
  override def get = v

}
case object None extends Option[Nothing] {
  override def isEmpty = true
  override def get: Nothing = throw new Error("None.get")
}

object Option {


}
