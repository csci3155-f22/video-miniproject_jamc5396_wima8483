val l = List(1, 2, 3)

/*
As we can see, the difference between foldLeft and foldRight in the
most simplest terms is the order of evaluation of the list being folded
on. FoldLeft will read the list to be folded on from left to right, and
foldRight will read the list from right to left
*/

val fl = l.foldLeft(List.empty){ (acc, i) => i :: acc }
val fr = l.foldRight(List.empty){ (acc, i) => acc :: i }

