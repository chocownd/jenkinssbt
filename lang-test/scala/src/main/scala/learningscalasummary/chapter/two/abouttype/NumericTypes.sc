// Base numeric types
// 1. Byte, signed integer, 1 byte, -128 ~ 127
var byte: Byte
Byte.MinValue
Byte.MaxValue
7 // byte literal
// 2. Short, signed integer, 2 byte, -32768 ~ 32767
var short: Short
Short.MinValue
Short.MaxValue
7 // short literal
// 3. Int, signed integer, 4 byte, -2^31 ~ 2^31 - 1(two's comprehension)
var int: Int
Int.MinValue
Int.MaxValue
7 // int literal
0x0f // int literal, "0x' prefix denotes hexadecimal notation
// 4. Long, signed integer, 8 byte, -2^63 ~ 2^63 - 1(two's comprehension)
var long: Long
Long.MinValue
Long.MaxValue
5l // long literal
5L // "l" suffix case insensitive
// 5. Float, signed floating point, 4 byte(https://en.wikipedia.org/wiki/IEEE_754)
var float: Float
5f // float literal
5F // "f" suffix case insensitive
// 6. Double, signed floating point, 8 byte(https://en.wikipedia.org/wiki/IEEE_754)
var double: Double
5.0 // double literal
5d // double literal
// All these types are wrappers around the core JVM types of same names.(except Int <-> Integer)
// Wrapping JVM types ensures that scala and java are interoperable, and that scala can make use of every java library.

// Type conversion
// Scala supports the ability to automatically convert numbers from one type to another based on the rank of the type, called `upconverted`.
// Above number types(Byte to Double) are sorted by rank. Lowest byte can conversion to any other types, converse is not allowed to prevent data loss.
byte = 1
//byte = 1000 // error
short = 30000
short = byte // conversion
//short = 40000 // error
int = 40000
int = byte
int = short
long = 4294967296L
long = byte
long = short
long = int
float = byte
float = short
float = int
float = long
double = byte
double = short
double = int
double = long
double = float
// if user accept data loss, explicit conversion is possible
float = double.toFloat
long = double.toLong
long = float.toLong
int = double.toInt
int = float.toInt
int = long.toInt
short = double.toShort
short = float.toShort
short = long.toShort
short = int.toShort
byte = double.toByte
byte = float.toByte
byte = long.toByte
byte = int.toByte
byte = short.toByte
