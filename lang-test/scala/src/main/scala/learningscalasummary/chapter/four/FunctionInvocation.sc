// with expression block
// When invoking functions using a single parameter, you can choose to use an expression block surrounded with curly braces to send the parameter instead of surrounding the value with parentheses.
def fun1(n: Int): Int = n
fun1 {
       val a = 1
       a + 2
     }
// above is same as below
val a = 1 // we can remove this temporary variable when pass express block to function
fun1(a + 2)