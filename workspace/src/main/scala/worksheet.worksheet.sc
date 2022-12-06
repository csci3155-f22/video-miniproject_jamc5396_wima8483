/*
We want to implement 4 functions to operate on integers:
sum, product, dividend, and difference. On our first attempt,
we may try something like the following code.
*/
def sum(x: Int, y: Int): Int = {
    x + y
}

def product(x: Int, y: Int): Int = {
    x * y
}

def dividend(x: Int, y: Int): Int = {
    x / y
}

def difference(x: Int, y: Int): Int = {
    x - y
}

//As we can see, the functions complete their intended function

sum(2, 2)
product(2, 2)
dividend(2, 2)
difference(2, 2)

/*
We may notice that the functions above all have something in
common; they are of type (Int, Int) => Int, meaning that they
take in two integers and return an integer. This indicates that
there is a higher level of abstraction and code simplification
that can occur, thus, the introduction of a higher-order function
atomicOps that takes in a function that can be modified based on
which operation on the two integers we would like to perform.
*/
def atomicOps(x: Int, y: Int, f: (Int, Int) => Int) = {
    f(x, y)
}

//Our code is now achieving the same result and is reduced significantly

atomicOps(2, 2, (x, y) => x + y) //sum
atomicOps(2, 2, (x, y) => x * y) //product
atomicOps(2, 2, (x, y) => x / y) //dividend
atomicOps(2, 2, (x, y) => x - y) //difference
