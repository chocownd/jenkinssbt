// Methods named "apply", sometimes referred to as a default method or an injector method, can be invoked without the method name.
class Multiplier(factor: Int) {
  def apply(input: Int): Int = input * factor
}
val tripleMe = new Multiplier(3)
val tripled = tripleMe.apply(10)
val tripled2 = tripleMe(10)

// !!!! CAUTION !!!!
// One potential disadvantage to making a method be the default one is if it makes the code look odd.
// Accessing the default method should be natural, like the accessor method for lists.
// Try to only use the apply method where it makes sense, like an accessor method for a list.