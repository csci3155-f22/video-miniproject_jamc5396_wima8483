val l = List(1, 2, 3)

/*
As we can see, the difference between foldLeft and foldRight in the
most simplest terms is the order of evaluation of the list being folded
on. FoldLeft will read the list to be folded on from left to right, and
foldRight will read the list from right to left
*/

val fl = l.foldLeft(List.empty){ (acc, i) => i :: acc }
val fr = l.foldRight(List.empty){ (acc, i) => acc :: i }

sealed trait Tree
case object  Empty extends Tree
case class Node(l:Tree, d:Int, r:Tree) extends Tree

val t: Tree = Node(Node(Empty, 2, Empty), 1, Empty)
t

def myFoldLeft(acc: Int)(t: Tree)(f: (Int, Int) => Int): Int = t match {
    case Empty => acc
    case Node(l, d, r) => {
        val res = f(acc, d)
        myFoldLeft(myFoldLeft(res)(l)(f))(r)(f)
    }
}

myFoldLeft(0)(t){ (acc, d) => acc + d }

val t2: Tree = Node(Node(Empty, 10, Empty), 5, Node(Empty, 2, Empty))
myFoldLeft(0)(t2) { (acc, d) => acc + d } 