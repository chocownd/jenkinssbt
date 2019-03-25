// syntax: def <identifier>[([<identifier>: <type> [= <expression>]]*)][: <type>] = <expression>
// 1. def <identifier> = <expression>
def fun1 = 1
fun1
// 2. def <identifier>: <type> = <expression>
def fun2: Int = 2
fun2
// 3. def <identifier>() = <expression>
def fun3() = 3
fun3()
// 4. def <identifier>(): <type> = <expression>
def fun4(): Int = 4
fun4()
// 5. def <identifier>(<identifier>: <type>, <identifier>: <type>) = <expression>
def fun5(param1: Int, param2: String) = 5
fun5(1, "1")
// 6. def <identifier>(<identifier>: <type>, <identifier>: <type>): <type> = <expression>
def fun6(param1: Int, param2: String): Int = 6
fun6(1, "1")
// 7. def <identifier>(<identifier>:<type> = <expression>): <type> = <expression>
def fun7(param1: Int = 1): Int = param1 + 6
fun7()

// keyword "return"
// generally function defined by expression block, but there are important difference between general expression block
// expression block assigned to function can use keyword "return" which terminate it's flow and return value directly
val impossible: Int = {
//  return 1 // invalid
  2
}
def possible(): Int = {
  return 1 // here, return keyword
  2
}
possible()

// procedure
// A procedure is a function that doesn't have a return value. It means, return value is Unit(void).
// 1. implicit return type(use statement in expression)
def log1(d: Double) = println(f"Got value $d.2f")
log1(1.1)
// 2. explicit return type
def log2(d: Double): Unit = println(f"Got value $d.2f")
log2(1.1)