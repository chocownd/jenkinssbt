// The convention for calling functions is that the parameters are specified in the order in which they are originally defined. However, in Scala you can call parameters by name, making it possible to specify them out of order.
def fun1(param1: Int, param2: String): Int = 1
fun1(1, "Hi")
fun1(param2 = "Hi", param1 = 1)

// with default values
// unlike other language, optional parameter with default value can precede than mandatory parameter.
// but in this case, call parameters by name is mandatory
def fun2(param1: Int = 1, param2: String): Int = 1
fun2(param2 = "Hi")

// otherwise, if default value become later than mandatory parameter, call parameters by name is not mandatory
def fun3(param1: Int, param2: String = "Hi"): Int = 1
fun3(1)