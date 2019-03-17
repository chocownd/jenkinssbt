// A tuple is an ordered container of two or more values, all of which may have different types.
// You may be familiar with this term from working with relational databases, where a single row of a table is considered its own tuple.
// syntax: ( <value 1>, <value 2>[, <value 3>...] )
val person = (19, "Hi", true)
person._1
person._2
person._3
// special syntax for 2-size tuple is with relation operator(->): <value 1> -> <value 2>
val red = "red" -> "0xff0000"
red._1
red._2