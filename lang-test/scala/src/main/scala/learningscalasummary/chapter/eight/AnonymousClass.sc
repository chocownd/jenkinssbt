// anonymous class
abstract class Listener { def trigger() }
val myListener = new Listener {
  override def trigger(): Unit = { println(s"Trigger at ${new java.util.Date()}") }
}
myListener.trigger()
class Listening {
  var listener: Listener = null
  def register(l: Listener): Unit = { listener = l }
  def sendNotification(): Unit = { listener.trigger() }
}
val notification = new Listening()
notification.register(new Listener {
  override def trigger(): Unit = println(s"Trigger at ${new java.util.Date()}")
})
notification.sendNotification()
