// class definition
// syntax:
// class <identifier; class name> [type-parameters]
//                                ([val|var] <identifier; field>: <type> = <expression; default value>[, ...])
//                                [extends <identifier; super class>[type-parameters](<input parameters>)
//                                [{ fields and methods }]
// * when use named parameter, you can shuffle class parameter order
class ShuffleClassParameterOrder(a: String, b: Int, c: Double, d: Boolean)
new ShuffleClassParameterOrder(b = 1, a = "a", d = true, c = 1.1)
new ShuffleClassParameterOrder("a", 1, d = true, c = 1.1)
