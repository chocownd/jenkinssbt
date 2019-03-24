// The term `expression` indicates a unit of code that returns a value after it has been executed.
// One or more lines of code can be considered an expression if they are collected together using curly braces ({ and }). This is known as an expression block.
// !!! attention !!!
// Don't forget expression != expression block. Follow above definition, if some code returns a value, it's a expression.
{
  "hello"
} // expression with expression block
"hello" // expression without expression block
"he" + "ll" + "o" // also expression
val amount = {
  val x = 5 * 20
  x + 10
}
// Expressions provide a foundation for functional programming because they make it possible to return data instead of modifying existing data (such as a variable).

// Expression blocks are also nestable, with each level of expression block having its own scoped values and variables.
{
  val a = 1
  val c = 10
  a.+ {
        val a = 100 // shadow outer block a
        val b = 1000 // define in inner block
        a + c // 110
      }
  //  b // can't reach to inner block
}