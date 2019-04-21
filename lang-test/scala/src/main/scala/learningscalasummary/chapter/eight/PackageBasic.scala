// syntax: package <identifier>
package learningscalasummary.chapter.eight

// syntax: import <package>.<class>
// The import command is a statement.
// Unlike in Java (which has a similar import keyword), an import can be placed anywhere in your code where you might use a statement.
import java.util.Date
// of course you can do partial import
import java.util
// import all with underscore
import collection.mutable._
// unlike java, group import in same path
// syntax: import <package>.{<class 1>[, <class 2>...]}
import scala.collection.{BitSet, DebugUtils}

class PackageBasic {
  def accessPackage(): Unit = {
    val d1 = new java.util.Date()
    val d2 = new Date()
  }

  def importAnywhere(): Unit = {
    println("Your new UUID is " + {import java.util.UUID; UUID.randomUUID()})
  }

  def partialImport(): Unit = {
    val d = new util.Date()
  }

  def importAll(): Unit = {
    val ab = new ArrayBuffer[Int]()
    val q = new Queue[Int]()
  }

  // !!!! CAUTION !!!!
  // Scala does its own automatic imports in every Scala class, importing the entire scala._ and java.lang._ packages.
  // This makes it possible to access the classes and packages in scala and java.lang directly without using the full path.
  def autoImport(): Unit = {
    val th = new Thread() // package is java.lang, but we can omit java.lang.
    val f = concurrent.Promise() // package is scala.concurrent, but we can omit scala.
  }

  // !!!! CAUTION !!!!
  // There is a potential downside to importing every class and subpackage from a package.
  // If the package you’re importing has a class name that duplicates one already in your namespace, the class that was already in your namespace will no longer be accessible.
  def shadowPackage(): Unit = {
    import scala.collection.mutable.Map
    val m = Map[String, Int]() // it shadow immutable Map
  }

  def importAlias(): Unit = {
    import collection.mutable.{Map => MutMap}
    var m: MutMap[String, Int] = MutMap[String, Int]()
    m = collection.mutable.Map[String, Int]()
  }
}
