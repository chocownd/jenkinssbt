// List(immutable)
val numbers /* type inference */ = List(1, 2, 3, 4, 5)
val colors = List("red", "green", "blue")
println(colors.size)
println(colors.head)
println(colors.tail)
println(colors(0))
for (n <- numbers) println(n)
colors.foreach(c => println(c))
colors.map(c => c.length).foreach(println)
println(colors.map(c => c.length).reduce((a: Int, b: Int) => a + b))

// Set(immutable)
// only different with List is don't contain duplicate item
val unique = Set(10, 20, 30, 20, 20, 10)
val sum = unique.reduce((a: Int, b: Int) => a + b)

class UniqClass(a: Int, b: Int)
val uniqClasses = Set(new UniqClass(1, 2), new UniqClass(1, 2))
uniqClasses.size == 2

case class CaseClass(a: Int, b: Int)
val uniqCaseClasses = Set(CaseClass(1, 2), CaseClass(1, 2))
uniqCaseClasses.size == 1

// Map(immutable), aka hashmap, dictionary, associative array in other language
val colorMap = Map(("red", 0xFF0000), "green" -> 0xFF00, "blue" -> 0xFF)
colorMap("red")
colorMap.contains("white")
for (pairs <- colorMap) println(pairs)
