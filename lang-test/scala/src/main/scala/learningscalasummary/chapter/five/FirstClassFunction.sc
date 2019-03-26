// scala is a functional program language.
// It means, scala support first-class function.
// first class mean,
// 1. can represent literally without assign to any identifier
def call(fun: Int => Int): Int = fun(2)
call((x: Int) => x /* literal function */)
call((x: Int) => x * 2 /* literal function */)
// 2. can assign to any container like val, var, any other data structure
def double(x: Int): Int = x * 2
val myDouble1: Int => Int /* explicit type is necessary because do not evaluate the "double" method */ = double
val myDoubleCopy = myDouble1
val myDouble2 /* with wildcard, can omit type */ = double _ /* the wildcard "_" means when you call "myDouble2 function" with parameter, the argument will be replace that wildcard */

def max(a: Int, b: Int): Int = if (a > b) a else b
def maximize: (Int, Int) /* multiple types must wrapped with parenthesis */ => Int = max
def maximize2 = maximize(_, _)
maximize(50, 30)
maximize2(20, 10)

def logStart() = "=" * 5 + " start " + "=" * 5
def start: () /* empty parenthesis is "Unit" type */ => String = logStart
// 3. can become parameter of function
// see #1
// 4. can become return of function
def through[A, B](fun: A => B): A => B = fun
through((x: Int) => x)(10)
