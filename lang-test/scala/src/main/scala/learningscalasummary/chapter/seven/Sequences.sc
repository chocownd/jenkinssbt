// Scala sequence collections hierarchy
//                                                 ---------------------------------------------------------
//                                                 | Seq(The root of all sequences. Shortcut for `List()`) |
//                                                 ---------------------------------------------------------
//                                                                           ^
//                                                                           |
//                                   -----------------------------------------------------------------------------------
//                                   |                                                                                 |
//   ----------------------------------------------------------------------                ---------------------------------------------------------
//   | IndexedSeq(The root of indexed sequences. Shortcut for `Vector()`) |                | LinearSeq(The root of linear (linked-list) sequences) |
//   ----------------------------------------------------------------------                ---------------------------------------------------------
//                                  ^                                                                                   ^
//                                  |                                                                                   |
//                --------------------------------------------------------                            -----------------------------------------------------------------------
//                |                                                      |                            |                                                             |       |
// -----------------------------------------------------------------     |      ---------------------------------------------------------------------------------   |       |
// | Vector(A list backed by an Array instance for indexed access) |     |      | Queue(A first-in-last-out (FIFO) list)/Stack(A last-in-first-out (LIFO) list) |   |       |
// -----------------------------------------------------------------     |      ---------------------------------------------------------------------------------   |       |
//                                 -------------------------------------------------------------                                ------------------------------------------  |
//                                 | Range(A range of integers. Generates its data on-the-fly) |                                | List(A singly linked list of elements) |  |
//                                 -------------------------------------------------------------                                ------------------------------------------  |
//                                                                                                                                 ^    ----------------------------------------------------------------
//                                                                                                                                 |    | Stream(A lazy list. Elements are added as they are accessed) |
//                                                                                                                                 |    ----------------------------------------------------------------
//                                                                                                                              -------
//                                                                                                                              | Nil |
//                                                                                                                              -------
// * Not in diagram but "String" also collection of Char
val inks1: Seq[Char] = Seq('C', 'M', 'Y', 'K') // it returns "List" concrete type
val inks2: Seq[Char] = List('C', 'M', 'Y', 'K') // same with above
val hi = "Hello, " ++ "worldly" take 12 replaceAll("w", "W") // ++, take come from "Iterable"

// Stream
// lazy collection
// generated from one or more starting elements and a recursive function, for example
def inc1(i: Int): Stream[Int] = Stream.cons(i, inc1(i + 1))
// Any other immutable collections receive 100% of their contents at instantiation time, but Stream is not.
// Elements are added to the Stream only when they are accessed for the first time.
// The elements that a stream generates are cached for later retrieval, ensuring that each element is only generated once.
// Streams can be unbounded, theoretically infinite collections where elements are only realized upon access.
// They can also be terminated with Stream.Empty, a counterpart to List.Nil.
val s = inc1(1)
s.take(5).toList
// alternate syntax for the Stream.cons operator is the slightly cryptic #:: operator
// similar with 1 :: 2 :: Nil in List right-associative construct operator
def inc2(head: Int): Stream[Int] = head #:: inc2(head + 1)
inc2(1).take(6).toList
// above are case of infinite stream, let's think bounded stream with simple trick
def to(head: Char, end: Char): Stream[Char] = head > end match {
  case true => Stream.empty
  case false => head #:: to((head + 1).toChar, end)
}
to('A', 'F').take(20).toList // take twenty characters, but ends with 'F', only six characters
