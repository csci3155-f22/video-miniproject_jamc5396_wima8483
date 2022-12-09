val l = List(1, 2, 3)

/*
As we can see, the difference between foldLeft and foldRight in the
most simplest terms is the order of evaluation of the list being folded
on. FoldLeft will read the list to be folded on from left to right, and
foldRight will read the list from right to left
*/

val fl = l.foldLeft(List.empty){ (acc, i) => i :: acc }
val fr = l.foldRight(List.empty){ (acc, i) => acc :: i }

//Tree data structure where nodes contain integers
sealed trait Tree[A]
case class Empty[A]() extends Tree[A]
case class Node[A](l:Tree[A], d: A, r:Tree[A]) extends Tree[A]

val t: Tree[Int] = Node(Node(Empty[Int](), 2, Empty[Int]()), 1, Empty[Int]())
t


/*
Our foldLeft implements post-order traversal. We will traverse in order of
left subtree, right subtree, root, which gives us a true foldLeft with
tail recursion, preventing stack overflows.
*/
def myFoldLeft[A](acc: A)(t: Tree[A])(f: (A, A) => A): A = {
    def loop(acc: A)(t: Tree[A]): A = t match {
        case Empty[A]() => acc
        case Node(l, d, r) => {
            val lAndR = f(loop(acc)(l), loop(acc)(r))
            loop(f(d, lAndR))(Empty[A]())
        }
    }
    loop(acc)(t)
}

myFoldLeft(0)(t){ (acc, d) => acc + d }

val t2: Tree[Int] = Node(Node(Empty[Int](), 30, Empty[Int]()), 5, Node(Empty[Int](), 4, Empty[Int]()))
myFoldLeft(0)(t2) { (acc, d) => acc + d } 