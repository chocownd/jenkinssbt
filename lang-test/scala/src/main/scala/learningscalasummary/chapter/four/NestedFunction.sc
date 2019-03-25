// Functions are named, parameterized expression blocks and expression blocks are nestable, so it should be no great surprise that functions are themselves nestable.
def max(a: Int, b: Int, c: Int): Int = {
  // The nested function here has the same name as its outer function, but because their parameters are different there is no conflict between them.
  // Scala functions are differentiated by their name and the list of their parameter types.
  def max(a: Int, b: Int): Int = if (a > b) a else b

  max(a, max(b, c))
}
max(42, 181, 19)
