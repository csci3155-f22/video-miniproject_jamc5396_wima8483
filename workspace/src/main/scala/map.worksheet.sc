val l = List(1, 2, 3)
l map { i => i+1 }
l
l map { i => i.toString() + 'z' }

/*
As we can see by the above code, the higher-order function map takes
each element of a data structure, and performs some sort of transformation
on it. We can also nest calls to maps for even more concise code
*/

l map { i => i+1 } map { i => i+1 }
// or
l map { i => i+1 } map 
    { i => i.toString() + 'z' }


/*
To deepen our understanding we will now implement our own list class
and our own map function
*/

sealed trait List[A]
case class Nil[A]() extends List[A]
case class Cons[A](h: A, tail: List[A]) extends List[A]

val l1: List[Int] = Cons(1, Cons(2, Cons(3, Nil[Int]())))

def myMap[A, B](l: List[A])(f: A => B): List[B] = {
    def loop(l: List[A]): List[B] = l match {
        case Nil[A]() => Nil[B]()
        case Cons(h, tail) => Cons(f(h), loop(tail))
    }
    loop(l)
}

myMap(l1){ i => i+1 }

//can nest myMap as well
myMap(myMap(l1){i => i+1 }){ i => i+1 }
