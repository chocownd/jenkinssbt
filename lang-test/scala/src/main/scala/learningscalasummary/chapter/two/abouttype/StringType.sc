// Scala’s String is built on Java’s String and adds unique features ex) multiline literals, string interpolation, etc...

// Multiline literal
"""
  | this is
  | multiline literal
  | multiline literal can't recognize escape character like \t \n
"""
"of course common string literal support escape character \n \t haha"

// Supported operator
val str1: String = "a"
val str2: String = "a"
str1 == str2 // unlike java, == operator doesn't evaluate identity, but equality

// String interpolation
// traditional approach in java
val age = 20
"my age is " + age + " years old"
// use scala interpolation
s"my age is $age years old"
s"my age is ${age + 0} years old"
f"my age is ${age.toFloat}%.3f today" // printf interpolation notation

// REGEX
// The format for Scala’s regular expressions is based on the Java class java.util.regex.Pattern. I recommend reading the Javadoc (the Java API documentation) for java.util.regex.Pattern if you are unfamiliar with this type, because Java’s (and thus Scala’s) regular expressions may be different from the format you have used with other languages and tools.
// below are built-in regex operation
// 1. matches
// Returns true if the regular expression matches the entire string.
"Froggy went a' courting" matches ".* courting"
// 2. replaceAll
// Replaces all matches with replacement text.
"milk, tea, muck" replaceAll("m[^ ]+k", "coffee")
// 3. replaceFirst
// Replaces the first match with replacement text.
"milk, tea, muck" replaceFirst("m[^ ]+k", "coffee")
// 4. others...
// For more advanced handling of regular expressions, convert a string to a regular expression type by invoking its r operator.
val input = "Enjoying this apple 3.14159 times today"
val pattern = """.* apple ([\d.]+) times .*""".r
val pattern(amountText) = input
amountText.toDouble
