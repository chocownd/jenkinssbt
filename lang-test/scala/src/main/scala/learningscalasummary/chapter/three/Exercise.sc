// 1
val name = "somename"
name match {
  case "" => "n/a"
  case common => common
}
name match {
  case common if common != "" => common
  case _ => "n/a"
}

// 2
val amount: Double = 1.2
if (amount > 0) {
  "greater"
}
else if (amount == 0) {
  "same"
}
else {
  "less"
}
amount match {
  case v if v > 0 => "greater"
  case v if v == 0 => "same"
  case _ => "less"
}

// 3
val color = "cyan"
color match {
  case "cyan" => "00ffff"
  case "magenta" => "00ff00"
  case "yellow" => "ffff00"
  case _ => ""
}

// 4
for (n <- 1 to 100) {
  val str = n match {
    case 100 => "100"
    case other if other % 5 == 0 => s"$other,\n"
    case other => s"$other, "
  }
  print(str)
}
for (i <- 1 to 100 by 5) {
  for (j <- i to (i + 4)) print(s"$j, ")
  println
}

// 5
for (n <- 1 to 100) {
  val str = n match {
    case num if num % 3 == 0 && num % 5 == 0 => "typesafe"
    case num if num % 3 == 0 => "type"
    case num if num % 5 == 0 => "safe"
    case num => num
  }
  print(s"$str, ")
}

// 6
for (n <- 1 to 100) print(s"${if (n % 3 == 0 && n % 5 == 0) "typesafe" else if (n % 3 == 0) "type" else if (n % 5 == 0) "safe" else n}, ")