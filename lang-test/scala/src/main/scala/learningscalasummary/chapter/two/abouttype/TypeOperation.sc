// 1. asInstanceOf[<Type>], Converts the value to a value of the desired type. Causes an error if the value is not compatible with the new type.
1.asInstanceOf[Double]
// avoid  use asInstanceOf! if type is not compatible, error occur
try "abc".asInstanceOf[Int] catch {
  case _: Throwable =>
}
// 2. getClass, Returns the type (i.e., the class) of a value.
(7.0 / 5).getClass
// 3. isInstanceOf, Returns true if the value has the given type.
5.0f.isInstanceOf[Double]
5.0d.isInstanceOf[Double]
// 4. hashCode, Returns the hash code of the value, useful for hashbased collections.
"A".hashCode
// 5. to<type>, Conversion functions to convert a value to a compatible value.
1.toDouble
// 6. toString, Renders the value to a String.
1.toString