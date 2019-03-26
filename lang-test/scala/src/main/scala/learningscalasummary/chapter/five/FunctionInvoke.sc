// invoke high-order function with function literal
def safeStringOp(s: String, f: String => String): String = {
  if (s != null) f(s) else s
}
val uuid = java.util.UUID.randomUUID().toString
val timedUUID = safeStringOp(uuid, { s =>
  val now = System.currentTimeMillis()
  val timed = s.take(24) + now
  timed.toUpperCase()
})
def safeStringOp2(s: String)(f: String => String): String = {
  if (s != null) f(s) else s
}
val timedUUID2 = safeStringOp2(uuid) { s =>
  val now = System.currentTimeMillis()
  val timed = s.take(24) + now
  timed.toUpperCase()}

def timer[A](f: => A): A = {
  val start = System.currentTimeMillis()
  val a = f
  val end = System.currentTimeMillis()
  println(s"execution time: ${end - start}")
  a
}

timer {
        util.Random.setSeed(System.currentTimeMillis())
        for (_ <- 1 to 100000) util.Random.nextDouble()
        util.Random.nextDouble()}