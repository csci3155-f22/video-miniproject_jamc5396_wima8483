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

sealed trait List
case object Empty extends List
case class Cons(h: Int, tail: List) extends List

val l1: List = Cons(1, Cons(2, Cons(3, Empty)))

def myMap(l: List)(f: Int => Int): List = {
    def loop(l: List): List = l match {
        case Empty => Empty
        case Cons(h, tail) => (f(h), tail) match {
            case (res, t) => Cons(res, loop(t))
        }
    }
    loop(l)
}

myMap(l1){ i => i+1 }

//can nest myMap as well
myMap(myMap(l1){i => i+1 }){ i => i+1 }