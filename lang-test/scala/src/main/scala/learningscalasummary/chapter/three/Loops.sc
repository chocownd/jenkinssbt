// for-comprehension
// syntax: for (<identifier> <- <iterator>) [yield] [<expression>]
// also can use for {...} than for (...)
// 1. keyword "yield" is optional. If yield exist, the return value of every expression that gets invoked will be returned as a collection. Otherwise, return value of for loop is Unit.
val forLoopCollections: Seq[Int] = for (i <- 1 to 10) yield {
  i
}
val forLoopUnit: Unit = for {i <- 1 to 10} {
  i
}
// 2. iterator guard(similar as pattern guard in pattern matching)
// When an iterator guard is used, an iteration will be skipped unless the if expression returns true.
for (i <- 1 to 10 if i % 2 == 0) println(i)
// same as
for (i <- 1 to 10) {
  if (i % 2 == 0) {
    println(i)
  }
}
// 3. nested iterator
for {
  x <- 1 to 2
  y <- 3 to 5
} println(s"($x, $y)")
// same as
for (x <- 1 to 2) {
  for (y <- 3 to 5) {
    println(s"($x, $y)")
  }
}
// 4. value binding
for (i <- 1 to 10; pow = 1 << i) yield pow
// same as
for (i <- 1 to 10) yield {
  val pow = 1 << i
  pow
}
// above all syntax help make body of for loop more concise. you can concentrate describe only business logic in for loop

// scala also provide while and do-while loop like other language. However, Scala offers a number of more expressive and more functional ways to handle loops than while and do/while loops.
// syntax: while (<boolean expression>) statement
// syntax: do statement while (<boolean expression>)
