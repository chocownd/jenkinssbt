val res: (Int, String, String, String, Double, String) = tripleToSixth(1, "H", 3.3)

// 1
def calcCircleArea(radius: Double): Double = radius * radius * 3.141592

// 2
def calcCircleArea(radius: String): Double = radius.toDouble * radius.toDouble * 3.141592
print5to50()

// 3
@annotation.tailrec
def print5to50(n: Int = 5): Unit = {
  if (n > 50) {
    return
  }
  print(s"$n ")
  print5to50(n + 5)
}

// 4
def epochTimeToStr(epochTime: Long): String = {
  "skip..."
}
pow1(1, 0)

// 5
def pow1(x: Double, y: Double): Double = {
  math.pow(x, y)
}
pow2(2, 3)

def pow2(x: Double, y: Double, curr: Double = 1.0): Double = {
  if (y < 1) {
    return curr
  }
  pow2(x, y - 1, x * curr)
}
distance((1, 1), (2, 2))

// 6
def distance(point1: (Double, Double), point2: (Double, Double)): (Double, Double) = {
  val dist = math.sqrt(math.pow(point1._1 - point2._1, 2) +
                         math.pow(point1._2 - point2._2, 2))
  (dist, dist)
}

// 7
def firstIsInt[A, B](pair: (A, B)): (Any, Any) = {
  def isInt(x: Any): Boolean = x.isInstanceOf[Int]

  (isInt(pair._1), isInt(pair._2)) match {
    case (false, true) => (pair._2, pair._1)
    case _ => pair
  }
}
tripleToSixth(1, "H", 3.3)

// 8
def tripleToSixth[A, B, C](triple: (A, B, C)): (A, String, B, String, C, String) = {
  (triple._1, triple._1.toString, triple._2, triple._2.toString, triple._3, triple._3.toString)
}