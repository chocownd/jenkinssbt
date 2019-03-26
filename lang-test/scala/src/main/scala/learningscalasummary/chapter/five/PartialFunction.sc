// total function, like "x * 2" can applied to every domain
// partial function, like "2 / x" can applied to only partial domain(0 is unavailable)
// Scala's partial functions are function literals that apply a series of case patterns to their input, requiring that the input match at least one of the given patterns
// Invoking one of these partial functions with data that does not meet at least one case pattern results in a Scala error.
val statusHandler: Int => String = {
  case 200 => "OK"
  case 400 => "Your Error"
  case 500 => "Our Error"
}
statusHandler(200)
statusHandler(444)