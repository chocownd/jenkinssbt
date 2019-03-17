// every data in scala is mapping to specific type.
val num: Int = 1
// No primitive data type in scala, everything is class.
//val num2: int // error
// every type in scala defined by class which had the method to handle that data itself. ex) String, Integer... => has own method to handle it's data.
num.toString

// Scala type system(= type hierarchy)
// every scala type is element of `scala type hierarchy`, of course include user defined type
// below are hierarchy diagram
//                                 -----------------------------------------------------------
//                                 | Any(root of every type in scala, like `Object` in java) |
//                                 -----------------------------------------------------------
//                                                            ^
//                                                            |
//                               ---------------------------------------------------------------
//                               |                                                             |
//               ------------------------------------                  -----------------------------------------------------
//               | AnyVal(root of every value type) |                  | AnyRef(root of every reference[= not value] type) |
//               ------------------------------------                  -----------------------------------------------------
//                               ^                                                                ^
//                               |                                                                |
//         --------------------------------------------------                        -------------|--------------
//         |                  |               |             |                        |              |           |
// -----------------  -----------------  -----------  --------------          ---------------  -----------  ----------
// | Numeric Types |  | Char(Unicode) |  | Boolean |  | Unit(void) |          | Collections |  | Classes |  | String |
// -----------------  -----------------  -----------  --------------          ---------------  -----------  ----------
//                       ^      ^      ^      ^                                          ^      ^      ^      ^
//                       |      |      |      |                                          |      |      |      |
//                       |      |      |      |            ------------------------------------------------------------------
//                       |      |      |      |            | Null(The subclass of all AnyRef types signifying a null value) |
//                       |      |      |      |            ------------------------------------------------------------------
//                       |      |      |      |                                             ^
//                       |      |      |      |                                             |
//                       |      |      |      |                                             |
//                       |      |      |      |                                             |
//                       |      |      |      |                                             |
//                  ----------------------------------                                      |
//                  | Nothing(subclass of all types) |--------------------------------------|
//                  ----------------------------------
// * The types that extend AnyVal are known as value types because they are the core values used to represent data.
// * AnyVal types are accessed just like other types but may be allocated at runtime either on the heap as objects or 'locally on the stack as a JVM primitive value'.
// * All other types have AnyRef as their root and are 'only ever allocated on the heap as objects'.
// * Nothing is only used as a type, because it cannot be instantiated.
// * Null, a subtype of all AnyRef types that exists to provide a type for the keyword null. For make everything in scala as a Type.
