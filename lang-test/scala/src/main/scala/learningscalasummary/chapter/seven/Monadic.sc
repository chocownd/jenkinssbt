import scala.util.{Failure, Success, Try}

// Option
// in scala, Option type is itself unimplemented but relies on two subtypes for the implementation: Some, a type-parameterized collection of one element; and None, an empty collection
var x: String = "Indeed"
var a = Option(x)
x = null
a
var b = Option(null)
b
a.isDefined
b.isEmpty
val opt1: Option[Int] = List(1, 2, 3).filter(_ < 0).headOption
val opt2: Option[Int] = List(1, 2, 3).find(_ < 0)
// we can handle value in option safely with below approach
def nextOption: Option[Int] = if (util.Random.nextInt() > 0) Some(1) else None
nextOption.fold(-1)(x => x) // fold, Returns the value from the given function for Some or else the starting value. foldLeft, foldRight, reduce, ... also do same thing
nextOption.getOrElse(-1)
nextOption.getOrElse { println("error"); -1 } // Returns the value for Some or else the result of a by-name parameter.
nextOption.orElse(nextOption) // Doesn't actually extract the value, but attempts to fill in a value for None. Returns this Option if it is nonempty, otherwise returns an Option from the given by-name parameter
nextOption match {
  case Some(p) => p
  case None => -1
}

// Try
// util.Try collection turns error handling into collection management.
def loopAndFail(end: Int, failAt: Int): Int = {
  for (i <- 1 to end) {
    println(s"$i) ")
    if (i == failAt) throw new Exception("Too many iterations")
  }
  end
}
Try(loopAndFail(2, 5)) // util.Try() takes a function parameter, so our invocation of loopAndFail is automatically converted to a function literal.
Try { loopAndFail(10, 5) } // Invoking util.Try with expression blocks is also acceptable.
val succ = Try(loopAndFail(2, 5))
val fail = Try(loopAndFail(10, 5))
succ.flatMap(n => Try(loopAndFail(n + 1, 5))) == Success(3) // flat map(not Try(Try), just Try) monadic value to other Try when success
succ.foreach(x => println(s"succ: $x")) // consumer of monadic value
succ.getOrElse(0) == 2
fail.getOrElse(0) == 0
fail.orElse(Try(loopAndFail(3, 5))) == Success(3)
succ.toOption == Some(2)
fail.toOption == None
succ.map(n => n * 2) == Success(4)
(succ match {
  case Success(p) => p
  case Failure(_) => -1
}) == 2
(fail match {
  case Success(p) => p
  case Failure(_) => -1
}) == -1

// Future
import scala.concurrent.Future
import scala.concurrent.Await
import scala.concurrent.duration._
import concurrent.ExecutionContext.Implicits.global

Future(3) // will return Future(Success(3))
Future { throw new Exception } // will return Future(Failure(Exception))

def nextFtr(i: Int = 0) = Future({
  def rand(x: Int) = util.Random.nextInt(x)

  Thread.sleep(5000)
  if (rand(3) > 0) i + 1 else throw new Exception
})
nextFtr(1).fallbackTo(nextFtr(2)) // fallback with second future when first future fail
nextFtr(1).flatMap(n => nextFtr(n + 1)) // flat map(not Future(Future), just Future)
nextFtr(1).map(_ * 2)
nextFtr(1).onComplete {
  case Success(p) => p
  case Failure(_) => -1
}
nextFtr(1).onSuccess { case p => p } // onSuccess & onFailure are integrated in onComplete
nextFtr(1).onFailure { case _ => -1 }
Future.sequence(List(nextFtr(1), nextFtr(2))) // list of futures to future of list. If any future fail, the first exception that occurs across the futures will be returned.

Await.result(nextFtr(1), Duration(10, SECONDS)) // block current thread until background(future) thread finish or reach to duration(will trigger timeout exception)
