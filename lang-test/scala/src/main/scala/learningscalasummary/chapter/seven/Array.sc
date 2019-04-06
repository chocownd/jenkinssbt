import java.io.File

// !!!! CAUTION !!!!
// Array is not "one of collection type in Scala" in strict meaning.
// It is actually just a wrapper around Java's array type with an "implicit class" allowing it to be used like a sequence.
// Scala provides the Array type for compatibility with JVM libraries and Java code
// So it's not recommended using Array in regular practice unless when need JVM code.
// There are so many other fine "Indexed Sequence" in Scala instead Array.
// Array can't change size, but possible to modify it's contents.
val colors = Array("red", "green", "blue")
colors(0)
colors(0) = "purple" // change content
colors
println(s"very purple: $colors") // println require toString. Common collections in scala override toString internally, but Array is not. So it shows combination of type parameter & reference of object.
val files: Array[File] = new java.io.File(".").listFiles // the return of Java Array, automatically mapping to Scala Array
