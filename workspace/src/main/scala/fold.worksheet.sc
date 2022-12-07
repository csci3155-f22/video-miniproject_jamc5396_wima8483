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
sealed trait Tree
case object  Empty extends Tree
case class Node(l:Tree, d:Int, r:Tree) extends Tree

val t: Tree = Node(Node(Empty, 2, Empty), 1, Empty)
t


/*
Our foldLeft implements post-order traversal. We will traverse in order of
left subtree, right subtree, root, which gives us a true foldLeft with
tail recursion, preventing stack overflows.
*/
def myFoldLeft(acc: Int)(t: Tree)(f: (Int, Int) => Int): Int = {
    def loop(acc: Int)(t: Tree): Int = t match {
        case Empty => acc
        case Node(l, d, r) => {
            val lAndR = f(loop(acc)(l), loop(acc)(r))
            loop(f(d, lAndR))(Empty)
        }
    }
    loop(0)(t)
}

myFoldLeft(0)(t){ (acc, d) => acc + d }

val t2: Tree = Node(Node(Empty, 20, Empty), 5, Node(Empty, 4, Empty))
myFoldLeft(0)(t2) { (acc, d) => acc + d } 