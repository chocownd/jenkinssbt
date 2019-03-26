// can take either a value or a function that eventually returns the value
// By supporting invocations with both values and functions, a function that takes a by-name parameter leaves the choice of which to use up to its callers.
// syntax: <identifier>: => <type>
// !!!! CAUTION !!!!
// when pass function to parameter, it'll called every time when it invoked in function body
def doubles(x: => Int): Int = {
  println(s"Now doubling: $x")
  x * 2
}
doubles(5)
def f(i: Int): Int = { println(s"Hello from ($i)"); i }
doubles(f(8))
