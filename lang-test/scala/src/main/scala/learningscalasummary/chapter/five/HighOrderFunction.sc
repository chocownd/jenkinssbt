// again, scala is a functional program language.
// It means, scala support high-order function.
// high order function means
// 1. can get function as a parameter
def safeStringOp(s: String, f: String => String): String = {
  if (s != null) f(s) else s
}
def reverser(s: String): String = s.reverse
safeStringOp(null, reverser)
safeStringOp("Ready", reverser)
// 2. can use function as a return value
def retDoubleFun(): Int => Int = (x: Int) => x * 2
retDoubleFun()(3)
