import scala.collection.mutable

// Sometimes use mutable collections is arguably safe
// For example,
// creating a mutable data structure that is only used within a function
// one that is converted to immutability before being returned
// immutable package, collection.immutable._ is automatically added to the current namespace, but mutable is not
// to use mutable collections, import scala.collection.mutable._ or
val mutableList = scala.collection.mutable.Buffer(1)
for (i <- 2 to 10) mutableList += i
mutableList
val mutableSet = scala.collection.mutable.Set(1, 2, 3)
mutableSet
val mutableMap = scala.collection.mutable.Map((1, 2), 3 -> 4)
mutableMap

// can convert mutable collection to immutable
mutableList.toList
mutableSet.toSet
mutableMap.toMap
// contrary also work well
List(1, 2, 3).toBuffer
Map("AAPL" -> 597, "MSFT" -> 40).toBuffer // become tuples buffer
Set(1, 2, 3).toBuffer // buffer allow duplicate, but when convert to Set duplication will remove

// also you can use "builder" to create collection
val listBuilder: mutable.Builder[Char, List[Char]] = List.newBuilder
listBuilder += 'h'
listBuilder ++= List('e', 'l', 'l', 'o')
listBuilder.result()
val setBuilder: mutable.Builder[Char, Set[Char]] = Set.newBuilder
setBuilder += 'h'
setBuilder ++= List('e', 'l', 'l', 'o')
setBuilder.result()
val mapBuilder: mutable.Builder[(Int, Char), Map[Int, Char]] = Map.newBuilder
mapBuilder += (1 -> 'h')
mapBuilder ++= Map(2 -> 'e', 3 -> 'l', 4 -> 'l', 5 -> 'o')
mapBuilder.result()
// The Builder type is a good choice if you are only building a mutable collection iteratively in order to convert it to an immutable collection.
