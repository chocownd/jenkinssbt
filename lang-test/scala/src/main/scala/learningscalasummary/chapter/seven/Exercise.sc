import scala.io.BufferedSource
import scala.util.control.Breaks._
import scala.util.{Failure, Success, Try}

// 1
// a
def fibo(cnt: Int): List[Int] = {
  def fiboStream(terms: (Int, Int)): Stream[Int] = {
    Stream.cons(
      terms._1,
      fiboStream((terms._2, terms._1 + terms._2)))
  }
  fiboStream((0, 1)).take(cnt).toList
}
fibo(10)

// b
def fibo(list: List[Int], cnt: Int): List[Int] = {
  def fiboStream(terms: (Int, Int)): Stream[Int] = {
    val nextTerm = terms._1 + terms._2
    Stream.cons(
      nextTerm,
      fiboStream(terms._2, nextTerm)
    )
  }
  val lastTwo = list.takeRight(2)
  list ::: fiboStream(lastTwo.head, lastTwo.last).take(cnt).toList
}
fibo(List(0, 1), 8)

// c
def fiboStream(cnt: Int): Stream[Long] = {
  def fiboStream(terms: (Long, Long)): Stream[Long] =
    terms._1 #:: fiboStream(terms._2, terms._1 + terms._2)
  fiboStream((0, 1)).take(cnt)
}
@annotation.tailrec
def listPrint[T](list: List[T]): Unit = {
  val (headList, tailList) = list.splitAt(10)
  print(headList.map(_.toString).reduceLeft((p, q) => s"$p, $q"))
  if (tailList.nonEmpty) {
    print(",")
    println
    listPrint(tailList)
  }
}
listPrint(fiboStream(100).toList)

// d
def fiboNext(elem: Long): Long = {
  @annotation.tailrec
  def findTerm(terms: (Long, Long), targetTerm: Long): Long = {
    if (terms._1 > targetTerm) {
      throw new RuntimeException(s"invalid input $targetTerm")
    }
    else if (terms._1 == targetTerm) {
      terms._2
    }
    else {
      findTerm((terms._2, terms._1 + terms._2), targetTerm)
    }
  }
  findTerm((0, 1), elem)
}
Try(fiboNext(9))

// 2
def fileNames(path: String): List[String] = {
  new java.io.File(path)
    .listFiles()
    .toList
    .map(_.toString)
    .filter(!_.split('/').last.startsWith("."))
    .sorted
}
def printConcatFileNames(fileNames: List[String]): Unit = {
  println(fileNames.reduceLeft((f1, f2) => s"$f1;$f2"))
}
printConcatFileNames(fileNames("/Users/chohc"))

// 3
def countFileNames(fileNames: List[String]): Unit = {
  fileNames
    .map(_.split('/').last)
    .map(_.head)
    .map(_.toUpper)
    .filter(('A' to 'Z').contains)
    .map(c => Map(c -> 1))
    .foldLeft(Map[Char, Int]())((cntMap1, cntMap2) => {
      (cntMap1.keySet ++ cntMap2.keySet)
        .map(c => {
          (c, Try(cntMap1(c)).getOrElse(0) + Try(cntMap2(c)).getOrElse(0))
        })
        .toMap
    })
    .toList
    .sortBy(_._1)
    .map({ case (c, cnt) => s"$c : $cnt" })
    .foreach(println)
}
countFileNames(fileNames("/Users/chohc"))

// 4
def productTwoStringNum(num1: String, num2: String): Double = {
  (Try(num1.toDouble), Try(num2.toDouble)) match {
    case (Failure(t), _) => throw t
    case (_, Failure(t)) => throw t
    case (Success(x), Success(y)) => x * y
  }
}
Try(productTwoStringNum("1.1", "2.3"))

// 5
def optGetProperty(prop: String): String = {
  Try(Option(System.getProperty(prop)).getOrElse("")).getOrElse("")
}
optGetProperty("java.home")
optGetProperty(null)
optGetProperty("aaaaaa")

// 6
// a
def fetchGithubFeed(user: String,
                    repo: String,
                    branch: String): BufferedSource = {
  io.Source.fromURL(s"https://github.com/$user/$repo/commits/$branch.atom")
}
def parseGithubLatestCommit(user: String,
                            repo: String,
                            branch: String): (String, String, String) = {
  def extractTagFirstMatch(xmlStr: String, tag: String): Option[String] = {
    if (!xmlStr.matches(s".*<$tag>(.*)</$tag>.*")) return None
    Some(xmlStr.split(s"<$tag>").last.split(s"</$tag>").head)
  }

  val source = fetchGithubFeed(user, repo, branch).bufferedReader()
  breakable {
    while (true) {
      if (source.readLine().trim == """<entry>""") break
    }
  }
  var concatLines = ""
  breakable {
    while (true) {
      val line = source.readLine().trim
      if (line == """</entry>""") break
      concatLines += line
    }
  }
  val title = extractTagFirstMatch(concatLines, "title").getOrElse("")
  val date = extractTagFirstMatch(concatLines, "updated").getOrElse("")
  val author = extractTagFirstMatch(
    extractTagFirstMatch(concatLines, "author").getOrElse(""),
    "name")
    .getOrElse("")
  (title, author, date)
}
// b
def parseGithubLatestCommits(
  infos: List[Map[String, String]]): List[(String, String, String)] = {

  infos
    .map(info =>
      parseGithubLatestCommit(info("user"), info("repo"), info("branch")))
}
val githubInfos = List(
  Map("user" -> "chocownd", "repo" -> "xnixc", "branch" -> "master"),
  Map("user" -> "akka", "repo" -> "akka", "branch" -> "master"),
  Map("user" -> "scala", "repo" -> "scala", "branch" -> "2.13.x"),
  Map("user" -> "sbt", "repo" -> "sbt", "branch" -> "develop"),
  Map("user" -> "scalaz", "repo" -> "scalaz", "branch" -> "series/7.3.x"))

try {
  parseGithubLatestCommits(githubInfos)
}
catch {
  case e: Exception => println(e)
}
// c
import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.concurrent.duration.SECONDS
def parseGithubLatestCommitsAsync(
  infos: List[Map[String, String]]): List[Future[(String, (String, String, String))]] = {

  infos
    .map(info =>
      Future({
        (info("repo"), parseGithubLatestCommit(info("user"), info("repo"), info("branch"))) }))
}

parseGithubLatestCommitsAsync(githubInfos)
  .map(f => Try(Await.result(f, Duration(5, SECONDS))))
  .filter(t => t.isSuccess)
  .map(_.get)

// d
parseGithubLatestCommitsAsync(githubInfos)
  .map(f => Try(Await.result(f, Duration(5, SECONDS))))
  .filter(t => t.isSuccess)
  .map(_.get)
  .sortBy(_._2._3)
  .map(_._1)

// 7
// skip