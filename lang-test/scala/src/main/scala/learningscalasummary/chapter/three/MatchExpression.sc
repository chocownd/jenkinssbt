// Match expressions are akin to C's and Java's "switch" statements, where a single input item is evaluated and the first pattern that is "matched" is executed and its value returned.
// Unlike them, only 0 or 1 patterns can match(remember Java's switch, without break it execute all cases when matched)
// The traditional "switch" statement is limited to matching by value, but Scala's match expressions are an amazingly flexible device that also enables matching such diverse items as types, regular expressions, numeric ranges, and data structure contents.
// So most Scala developers prefer match expressions over "if .. else" blocks because of their expressiveness and concise syntax.
// Below are syntax
// <expression> match {
//   case <pattern_match> => <expression>
//   [case...]
// }
// Example 1
val x = 10; val y = 20
val max = x > y match {
  case true => x
  case false => y
}
// Example 2
val status = 500
val message = status match {
  case 200 => "ok"
  case 400 =>
    println("ERROR - we called the service incorrectly")
    "error"
  case 500 =>
    println("ERROR - the service encountered an error")
    "error"
}

// pattern alternative, combine multiple patterns with pipe(|).
val day = "MON"
val kind = day match {
  case "MON" | "TUE" | "WED" | "THU" | "FRI" => "weekday"
  case "SAT" | "SUN" => "weekend"
}

// match error
val num = 1
val exc = try
  num match {
    case 2 => "two"
    case 3 => "three"
  }
catch {
  case e: MatchError => println(e)
}
// to prevent this, we can use "wildcard match-all" pattern(like last else in if..else)
// there are two kinds of wildcard patterns, first is value-binding(can access to value in case block), second is wildcard(aka "underscore")-binding(underscore usually means in scala "we know something exist at there, but don't regardless it's value", so can't access from case block. That symbol come from mathematics, denote unknown value)
// 1. value-binding
val str = "ERROR"
val res = str match {
  case "OK" => 200
  case other =>
    println(other)
    -1
}
// 2. underscore-binding
val res2 = str match {
  case "OK" => 200
  case _ =>
//    println(_) // not allowed
    -1
}

// Pattern guard. Protect case with if expression. For example,
val res3 = str match {
  case s if s != null /* can use "if" without parentheses */ => "non-null string"
  case _ => "null string"
}

// type match(with pattern variables)
val p = 12180
val q: Any = p
q match {
  case _: String => s"'x'"
  case x: Double => f"$x%.2f"
  case x: Float => f"$x%.2f"
  case x: Long => s"${x}l"
  case x: Int => s"${x}i"
}
