// 1
val max: (Int, Int) => Int = (x: Int, y: Int) => if (x > y) x else y
def max(triple: (Int, Int, Int), max: (Int, Int) => Int): Int = max(triple._1, max(triple._2, triple._3))
max((1,2,3), max)

// 2
//omit

// 3
def highOrder(x: Int): Int => Int = (y: Int) => x * y
highOrder(2)(3)

// 4
def fzero[A](x: A)(f: A => Unit): A = { f(x); x }
fzero(1)((x: Int) => println(s"param $x"))

// 5
def square(m : Double): Double = m * m
val sq1 = square _
sq1(2.5)
val sq2: Double => Double = square
sq2(2.5)

// 6
def conditional[A](x: A, p: A => Boolean, f: A => A): A = if (p(x)) f(x) else x

// 7
def chk15(x: Int): Int = doOther(x, 15, "typesafe")
def chk5(x: Int): Int = doOther(x, 5, "safe")
def chk3(x: Int): Int = doOther(x, 3, "type")
def doOther(x: Int, y: Int, str: String): Int = conditional[Int](x,
                                                                 (a: Int) => a % y == 0,
                                                                 (_: Int) => { println(str); -1 })
val seq: Seq[Int] = 1 to 100
(1 to 100).foreach(x => if (chk15(x) != -1 && chk5(x) != -1 && chk3(x) != -1) println(x))
