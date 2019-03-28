import scala.collection.mutable.ArrayBuffer
import collection.JavaConverters._

List(24, 99, 104).mkString(", ") == "24, 99, 104"
List("f", "t").toBuffer == ArrayBuffer("f", "t") // ArrayBuffer is mutable
Map("a" -> 1, ("b", 2)).toList == List(("a", 1), ("b", 2))
List(2, 5, 5, 3, 2).toSet == Set(2, 5, 3)
List(2, 5, 5, 3, 2).toString() == "List(2, 5, 5, 3, 2)"

// java collections <-> scala collections
List(12, 29).asJava
new java.util.ArrayList(5).asScala