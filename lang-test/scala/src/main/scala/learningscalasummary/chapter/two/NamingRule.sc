// below characters are allowed for naming.
// 1. (english)character
// 2. number
// 3. standard mathematical operator like *, :+, etc... more specific, “all other characters in \u0020-007F and Unicode categories Sm [Symbol/Math] … except parentheses ([]) and periods.”
// 4. constants like π, φ, etc...

// below are rules for combining valid identifier.
// 1. A letter followed by zero or more letters and digits.
val a: Int
val aa: Int
val a1: Int
val aa1: Int
val π: Double = 3.141592
// 2. A letter followed by zero or more letters and digits, then an underscore (_), and then one or more of either letters and digits or operator characters.
val b_b: Int
val b_1: Int
val b_bb: Int
// 4. One or more of any character except a backquote, all enclosed in a pair of backquotes.
val `c`: Int
val `c.c`: Int

// 3. One or more operator characters.
def +(): Int

def ++(): Int

// Scala recommend camelCase.
def camelCaseMethod(): Unit
class CamelCaseClass
