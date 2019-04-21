// Lazy values, are only created the first time they are instantiated.
// You can create a lazy value by adding the keyword lazy before the val keyword when defining a value.
// In a way, lazy values are a mechanism situated between regular class values and methods.
// The expression used to initialize a regular class value is only executed once and at instantiation time, whereas the expression that makes up a method is executed every time the method is invoked.
// However, the expression that initializes a lazy value is executed when the value is invoked, but only the very first time.
// In this way, a lazy value is a sort of cached function result.
class RandomPoint {
  val x = { println("creating x"); util.Random.nextInt() }
  lazy val y = { println("now y"); util.Random.nextInt() }
}
val p = new RandomPoint()
println(s"Location is ${p.x}, ${p.y}")
println(s"Location is ${p.x}, ${p.y}")
