(List(500, 404) match {
  case x if x contains 500 => "has error"
  case _ => "okay"
}) == "has error"

(List(500, 404) match {
  case List(500, x) => s"Error followed by $x"
  case List(e, x) => s"$e was followed by $x"
}) == "Error followed by 404"

(List('r', 'g', 'b') match {
  case x :: _ => x
  case Nil => ' '
}) == 'r'

(('h', 204, true) match {
  case (_, _, false) => 501
  case ('c', _, true) => 302
  case ('h', x, true) => x
  case (c, x, true) => {
    println(s"Did not expect code $c")
    x
  }
}) == 204