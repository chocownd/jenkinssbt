// 1
def createOddNumList(size: Long): List[Long] = {
  @annotation.tailrec
  def createJumpList(size: Long, start: Long, list: List[Long]): List[Long] = {
    if (size == 0) {
      return list
    }
    createJumpList(size - 1, start + 2, list :+ start)
  }
  createJumpList(size, 1, Nil)
}
createOddNumList(20)

// 2
def factors(n: Long): List[Long] =
  (2L to (n - 1)).filter(n % _ == 0).toList
createOddNumList(10).flatMap(factors)

// 3
def first[A](items: List[A], count: Int): List[A] = {
  @annotation.tailrec
  def first[B](curr: List[B], remain: List[B], count: Int): List[B] = {
    if (count == 0 || remain == Nil) {
      return curr
    }
    first(curr :+ remain.head, remain.tail, count - 1)
  }
  first(Nil, items, count)
}
first(List(1,2,3), 0)
first(List(1,2,3), 1)
first(List(1,2,3), 4)

// 4
List("a", "b", "cd", "e")
  .fold("")((str1: String, str2: String) => if (str1.length > str2.length) str1 else str2)

// 5
def listReverse[A](list: List[A]): List[A] = {
  @annotation.tailrec
  def listReverse[B](curr: List[B], remain: List[B]): List[B] = {
    if (remain == Nil) {
      return curr
    }
    listReverse(remain.head :: curr, remain.tail)
  }
  listReverse(Nil, list)
}
listReverse(List(1, 2, 3))

// 6
List("a", "b", "c", "di", "racecar", "abc")
  .partition(str => str == str.reverse)
