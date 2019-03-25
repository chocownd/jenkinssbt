val d: Double = 65.642
d.+(1.1) // There actually is no addition operator in Scala, nor are there any other arithmetic operators.
// All of the arithmetic operators we have used in Scala are actually methods, written as simple functions using their operator symbol as the function name and bound to a specific type.
// This is possible because of an alternate form of invoking methods on objects known as operator notation, which forsakes the traditional dot notation and uses spaces to separate the object, its operator method, and the single parameter to the method.
// Every time we write 2 + 3, the Scala compiler recognizes this as "OPERATOR NOTATION" and treats it as if you had written 2.+(3)
// below are custom example
class MyClass {
  def call(n: Int): Int = 1 + n
  def call(n: Int, p: String): Int = n + p.length
}
val myClass = new MyClass
myClass call 1 // operator notation(= infix operator notation)
myClass.call(1) // traditional notation
// we can do similar approach with count of n parameters, like
myClass call (1, "Hi") // actually can replace dot to space
