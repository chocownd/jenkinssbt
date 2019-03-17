// 1
val celsius = 1
val step1 = celsius * 9
val step2 = step1 / 5.0
val step3 = step2 + 32

// 2
val celsius2 = 1
val step2_1 = celsius2 * 9
val step2_2 = step2_1 / 5
val step2_3 = step2_2 + 32

// 3
val input = 2.7255
f"You owe $$$input%.2f."

// 4
val flag = false
val result = !flag

// 5
128.toChar
128.toString
128.toDouble
128.toChar.toInt
128.toString.toInt
128.toDouble.toInt

// 6
val inputStr = "Frank,123 Main,925-555-1943,95122"
val pattern = """.*,(\d+)-(\d+)-(\d+),.*""".r
val pattern(m1, m2, m3) = inputStr
val phoneNum = (m1.toInt, m2.toInt, m3.toInt)
