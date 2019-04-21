// How can we know last element in list?
val list = List(1, 2, 3, 4)
// 1. count size
// it's inefficient when linked list, traverse always
list.size
// 2. empty check
list.isEmpty
list.nonEmpty
// 3. tail Nil check
@annotation.tailrec
def trav[A, B](i: List[A], doSomething: A => B): Unit = {
  if (i != Nil /* Nil is singleton of List[Nothing], List[Nothing] is same as empty list */) {
    doSomething(i.head)
    trav(i.tail, doSomething)
  }
}
trav(list, println)
// 4. list apply
list.apply(1) == list(1)

List() == Nil
List(1).tail == Nil

// cons(construct) operator
// right-associative cons operator
// In right-associative notation, triggered when operators end with a colon (:), operators are invoked on the entity to their immediate right.
// :: method: takes a single value that becomes the head of a new list
// so, 3 :: Nil means "Nil list" take a "3" for it's head
1 :: 2 :: 3 :: Nil == Nil.::(3).::(2).::(1)

// list concat operator
// right-associative operator
// Prepends another list to this one.
List(1, 2) ::: List(2, 3) == List(1, 2, 2, 3)

// collection concat operator
// Appends another collection to this list
List(1, 2) ++ Set(3, 4, 3) == List(1, 2, 3, 4)

// compare list operator
// Returns true if the collection types and contents are equal
List(1, 2) == List(1, 2)

// deduplicate item operator
// Returns a version of the list without duplicate elements.
List(3, 5, 4, 3, 4).distinct == List(3, 5, 4)

// cut off front part
// Subtracts the first n elements from the list.
List(1, 2, 3, 4).drop(2) == List(3, 4)

// filter item
// Returns elements from the list that pass a true/ false function.
List(1, 2, 3, 4).filter(i => i % 2 == 0) == List(2, 4)

// flatten
// Converts a list of lists into a single list of elements.
List(List(1, 2), List(3, 4)).flatten == List(1, 2, 3, 4)

// split with condition
// Groups elements into a tuple of two lists based on the result of a true/false function.
List(100, 20, 30, 400, 5).partition(i => i < 50) == (List(20, 30, 5), List(100, 400))

// reverse
List(1, 2, 3).reverse == List(3, 2, 1)

// fetch mid of list
// Returns a segment of the list from the first index up to but not including the second index.
List(10, 20, 30, 40, 50).slice(1, 4) == List(20, 30, 40)

// sort with condition
// Orders the list by the value returned from the given function.
List("apple", "to").sortBy(_.length) == List("to", "apple")

// sort
// Orders a list of core Scala types by their natural value.
List("to", "apple").sorted == List("apple", "to")

// split
// Groups elements into a tuple of two lists based on if they fall before or after the given index.
List(10, 20, 30, 40, 50, 60).splitAt(2) == (List(10, 20), List(30, 40, 50, 60))

// cut off rear part
// Extracts the first n elements from the list.
List(2, 3, 5, 7, 11, 13).take(3) == List(2, 3, 5)

// Combines two lists into a list of tuples of elements at each index.
List(1, 2).zip(List("a", "b")) == List((1, "a"), 2 -> "b")

// An important point to make about these arithmetic methods is that ::, drop, and take act on the front of the list and thus do not have performance penalties.
// Recall that List is a linked list, so adding items to or removing items from its front does not require a full traversal.
// But these operations have corollary operations that act on the end of the list and thus do require a full list traversal.
// Usually, use corollary operator is not a pain-point with small size list
// But in general it is best to operate on the front of a list, not its end.
1 :: 2 :: 3 :: Nil == Nil :+ 1 :+ 2 :+ 3
List(10, 20, 30, 40, 50, 60, 70).dropRight(3) == List(10, 20, 30, 40)
List(10, 20, 30, 40, 50, 60, 70).takeRight(3) == List(50, 60, 70)

// map-reduce
// map part
List(0, 1, 0).collect({
                        case 0 => "Zero"
                        case 1 => "One"}) == List("Zero", "One", "Zero")
List("milk,tea", "very,nice").flatMap(_.split(",")) == List("milk", "tea", "very", "nice")
List("milk", "tea").map(_.toUpperCase()) == List("MILK", "TEA")
// reduce part
List(41, 59, 26).max == 59
List(10.9, 32.5, 3.23, 5.55).min == 3.23
List(5, 6, 7).product == 210 // 5 * 6 * 7
List(10, 20, 30).sum == 60
List(10, 20, 30).contains(15) == false
List(1, 2, 3).endsWith(List(2, 3))
List(24, 17, 32).exists(_ < 18) == true
List(24, 17, 32).forall(_ < 18) == false
List(0, 4, 3).startsWith(List(0, 4)) == true
// Reduces the list given a starting value and a reduction function.reduction function.
List("a", "b", "c").fold("!")(_ + _) == "!abc"
// Reduces the list from left to right given a starting value and a reduction function.
List(1, 2, 10).foldLeft(0)((a: Int, b: Int) => if (a == 10) -10 + b else a + b) == 13 // (1, 2) => (3, 10) => 13
// Reduces the list from right to left given a starting value and a reduction function.
List(1, 2, 10).foldRight(0)((a: Int, b: Int) => if (a == 10) -10 + b else a + b) == - 7 // (10, 2) => (-8, 1) => -7
// Reduces the list given a reduction function, starting with the first element in the list.
List(4, 5, 6).reduce(_ + _) == 15 // (4, 5) => (9, 6) => 15
// Reduces the list from left to right given a reduction function, starting with the first element in the list.
List(1, 2, 10).reduceLeft((a: Int, b: Int) => if (a == 10) -10 + b else a + b) == 13 // (1, 2) => (3, 10) => 13
// Reduces the list from right to left given a reduction function, starting with the first element in the list.
List(1, 2, 10).reduceRight((a: Int, b: Int) => if (a == 2) -2 + b else a + b) == 9 // (2, 10) => (8, 1) => 9
// Takes a starting value and a reduction function and returns a list of each accumulated value.
List(4, 5, 6).scan(0)(_ + _) == List(0, 4, 9, 15)
// Takes a starting value and a reduction function and returns a list of each accumulated value from left to right.
List(4, 5, 6).scanLeft(0)((a: Int, b: Int) => if (a == 4) -4 + b else a + b) == List(0, 4, 1, 7)
// Takes a starting value and a reduction function and returns a list of each accumulated value from right to left.
//List(4, 5, 6).scanRight(0)((a: Int, b: Int) => if (a == 4) -4 + b else a + b)
List("a", "b", "c").scanRight("!")((a: String, b: String) => if (a == "a") "z" + b else a + b) == List("zbc!", "bc!", "c!", "!")
// !!!! CAUTION !!!!
// 1. fold, reduce, and scan are all limited to returning a value of the same type as the list elements, while the left/right varities of each operation support unique return types.
// Thus you could implement the forall Boolean operation on a list of integers with foldLeft but would not be able to do so with fold.
// 2. Another major difference is in the ordering. Whereas foldLeft and foldRight, as an example, specify the direction in which they will iterate through the list,
// the non-directional operations specify no order to their iteration.
// 3. it is better to select the “left” operations than "right" because they require fewer traversals through the list in their implementation.