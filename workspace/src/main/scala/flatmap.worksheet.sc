val l = List(Some(1), Some(2), None, Some(3))
l.flatten map { i => i+1 }
val l2 = l map { i => i match {
    case None => None
    case Some(value) => Some(value+1)
} }
l2.flatten

l flatMap { i => i match {
    case None => Nil
    case Some(value) => (value+1).toString()
} }

sealed trait List
case object Empty extends List
case class Cons(h: Option[Int], tail: List) extends List
case class Cons2(h: Int, tail: List) extends List

val l1 = Cons(Some(1), Cons(Some(2), Cons(None, Cons(Some(3), Empty))))

def myFlatMap(l: List)(f: Int => Int): List = {
    def loop(l: List): List = l match {
        case Empty => Empty
        case Cons(h, t) => (h, t) match {
            case (None, tail) => loop(tail)
            case (Some(value), tail) => Cons2(f(value), loop(tail))
        }
    }
    loop(l)
}

myFlatMap(l1){ i => i+1 }