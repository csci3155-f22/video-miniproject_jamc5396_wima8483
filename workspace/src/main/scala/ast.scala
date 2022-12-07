sealed trait Tree
case object Empty extends Tree
case class Node(l:Tree, d:Int, r:Tree) extends Tree

sealed trait List
case object Empty extends List
case class Cons(h: Int, tail: List) extends List