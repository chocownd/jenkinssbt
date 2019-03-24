// "if" is expression in scala. It means "if" block return value
val a = if (true) "t" else "f"
a
// But when use "if" block solitary, it's more suited for statement because the type will be "Any" what we didn't expect.
val b: Any = if (false) "f"
b
// otherwise, "if-else" is well suited to working with expressions.
val c: String = if (false) "f" else "t"
c

// As a matter of formal syntax, Scala only supports a single "if" and optional "else" block, and does not recognize the "else if" block as a single construct.
// Because expression block can be nestable, "if..else..if..else" is actually "if..else { if..else }"
// for example,
val d: Boolean = if (true) {
  true
}
else false // any expression replace this "false", so below are correct
val e: Boolean = if (true) {
  true
}
else /*{*/if (true) { true } else { false }/*}*/ // actually "if..else..if..else" is nested "is..else..{if..else}"
