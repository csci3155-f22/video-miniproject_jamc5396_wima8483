val l = List(Some(1), Some(2), None, Some(3))
l.flatten map { i => i+1 }
val l2 = l map { i => i match {
    case None => None
    case Some(value) => Some(value+1)
} }
l2.flatten

l flatMap {_.map { i => i+1 } }

sealed trait List[A]
case class Nil[A]() extends List[A]
case class Cons[A](h: A, tail: List[A]) extends List[A]

val l1 = Cons(None, Cons(Some(2), Cons(None, Cons(Some(3), Nil[Option[Int]]()))))

def myFlatMap(l: List)(f: Int => Int): List = {
    def loop(l: List): List = l match {
        case Empty => Empty
        case Cons(h, t) => (h, t) match {
            case (None, tail) => loop(tail)
            case (Some(value), tail) => Conz(f(value), loop(tail))
        }
        case Conz(h, t) => Conz(f(h), loop(t))
    }
    loop(l)
}

val l3 = Conz(1, Conz(2, Conz(3, Empty)))
myFlatMap(l3){ i => i+1 }

myFlatMap(l1){ i => i+1 }
myFlatMap(l1){ i => i%2 }

sealed trait Tree
case object  EmptyT extends Tree
case class Node(l:Tree, d:Option[Int], r:Tree) extends Tree
case class Node2(l:Tree, d:Int, r:Tree) extends Tree


val t = Node(Node(Node(EmptyT, Some(3), EmptyT), None, EmptyT), Some(1), Node(EmptyT, Some(2), EmptyT))

/* WRONG
def myFlatMapT(t: Tree)(f: Int => Int): Tree = {
    def loop(t: Tree): Tree = t match {
        case EmptyT => EmptyT
        case Node(l, d, r) => (l, d, r) match {
            case (EmptyT, None, EmptyT) => EmptyT
            case (l, None, EmptyT) => l match {
                case Node(l, Some(value), r) => Node2(loop(l), f(value), loop(r))
                case Node(l, None, EmptyT) => loop(l)
                case Node(EmptyT, None, r) => loop(r)
                case Node(l, None, r) => loop(l)
            }

            case (EmptyT, Some(value), EmptyT) => Node2(l, f(value), r)
            case (l, Some(value), EmptyT) => loop(l)
            case (EmptyT, Some(value), r) => loop(r)
        }
    }
    loop(t)
}
myFlatMapT(t){ i => i+1 }
*/