sealed trait List[A]
case class Nil[A]() extends List[A]
case class Cons[A](h: A, tail: List[A]) extends List[A]

val l1 = Cons(None, Cons(Some(2), Cons(None, Cons(Some(3), Nil[Option[Int]]()))))


def myMapFirst[A](l: List[A])(f: A => Option[A])(g: A => A): List[A] = l match {
    case Nil[A]() => l
    case Cons(h, t) => f(h) match {
      case None => {
            val tp = myMapFirst(t)(f)(g)
            Cons(h, tp)
        }
      case Some(hp) => Cons(g(hp), t)
    }
}

val ltest = Cons(1, Cons(2, Cons(3, Nil())))

myMapFirst(ltest)((i: Int) => if (i > 1) Some(i) else None )(i => i * 2)

/*
def myMapFirst[A](l: List[A])(f: A => Option[A]): List[A] = {
    l match{
        case None => ???
        case Some(A) => 

    }
    /*
    def loop(acc: A)(l: List[A]): A = l match {
        case Nil[A]() => acc
        case Cons(h, t) => loop(f(h, acc))(t)
    }
    loop(acc)(l)*/
}*/
