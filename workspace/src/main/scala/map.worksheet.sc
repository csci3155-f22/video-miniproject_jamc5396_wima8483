sealed trait List
case object Empty extends List
case class Cons(h: Int, tail: List) extends List

val l: List = Cons(1, Cons(2, Cons(3, Empty)))
