// function literal, aka anonymous function or lambda [expression]
(x: Int) => x * 2
((x: Int) => x * 3)(2)
// function literal is actually parameterized expression
// we already know how to write expression which return value,
1
// but also know how to write expression which receive parameter
((x: Int) => x)(1)

def max(a: Int, b: Int): Int = if (a > b) a else b
val maximizeWithFunValue: (Int, Int) => Int = max
val maximizeWithFunLiteral = (a: Int, b: Int) => if (a > b) a else b
maximizeWithFunValue(10, 20)
maximizeWithFunLiteral(10, 20)

def getFunAsParam(fun: (Int, String) => Int): (Int, String) => Int = fun
getFunAsParam((a: Int, b: String) => a + b.length)(1, "abc")
getFunAsParam((a, b) => a + b.length)(1, "abc")

// Placeholder syntax
// shortened form of function literals
// replacing named parameters with wildcard operators (_)
// It can be used when
// (a) the explicit type of the function is specified outside the literal and
// (b) the parameters are used no more than once.
val doubler: Int => Int = _ * 2
getFunAsParam(_ + _.length)(1, "abc")
