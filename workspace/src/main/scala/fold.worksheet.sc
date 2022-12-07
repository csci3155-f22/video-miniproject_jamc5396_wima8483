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
Our foldLeft is very easy to grasp; when we have reached the end of the tree, return the accumulator.
If we have not reached the end of the tree (case Node(l, d, r)) we have a nested call to myFoldLeft
that recurses down every left subtree before calling the fold on the right subtree
*/
def myFoldLeft(acc: Int)(t: Tree)(f: (Int, Int) => Int): Int = t match {
    case Empty => acc
    case Node(l, d, r) => {
        myFoldLeft(myFoldLeft(f(acc, d))(l)(f))(r)(f)
    }
}

myFoldLeft(0)(t){ (acc, d) => acc + d }

val t2: Tree = Node(Node(Empty, 10, Empty), 5, Node(Empty, 2, Empty))
myFoldLeft(0)(t2) { (acc, d) => acc + d } 