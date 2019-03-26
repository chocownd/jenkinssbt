// partially applied function
def factorOf1(x: Int, y: Int): Boolean = y % x == 0
val f1 = factorOf1 _
val x = f1(7, 20)
val multipleOf3 = factorOf1(3 /* partially maintain factor */ ,
                            _: Int /* partially accept new factor */)
multipleOf3(78)

// currying
def factorOf2(x: Int)(y: Int): Boolean = y % x == 0
val f2: Int => Int => Boolean = factorOf2
val isEven: Int => Boolean = factorOf2(2)
val z = isEven(32)