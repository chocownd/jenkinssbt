// abstract class
abstract class Car {
  val year: Int
  val automatic: Boolean = true
  def color: String
}

class RedMini(val year: Int /* super field as a class parameter */) extends Car {
  override def color = "Red"
}

class Mini(
  val year: Int,
  val color: String /* Invoking a parentheses- and parameter-free method on an instance has the same appearance as accessing one of its values, so it should be unsurprising that you can implement a required method using a value. */)
  extends Car
