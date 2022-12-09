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

def myFoldLeft[A](acc: A)(l: List[A])(f: (A, A) => A): A = {
    def loop(acc: A)(l: List[A]): A = l match {
        case Nil[A]() => acc
        case Cons(h, t) => loop(f(h, acc))(t)
    }
    loop(acc)(l)
}

val l5 = Cons(1, Cons(2, Cons(3, Nil[Int]())))

myFoldLeft(0)(l5){ (acc, h) => h+acc }

/*
def myFlatMap[A, B](l: List[A])(f: A => List[B]): List[B] = {
    myFoldLeft(Nil[B]())( (List[A], List[A]) => List[A] )
}

val l3 = Cons(1, Cons(2, Cons(3, Nil[Int]())))
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
*/