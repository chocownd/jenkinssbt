// 1
// a
class Console(val make: String,
              val model: String,
              val debutDate: java.util.Date,
              val physicalMediaFormat: List[String],
              val maxVideoResolution: Int,
              val wifiType: String = null) {
  override def toString: String = s"make=$make,model=$model".take(120)
}

// b
class ConsoleLoader() {
  def init(): List[Console] = {
    List(
      new Console("Sony",
                  "PS2",
                  new java.util.Date(),
                  List("DVD", "CD"),
                  1920,
                  "b/g"),
      new Console("MS",
                  "XBOX",
                  new java.util.Date(),
                  List("DVD", "CD"),
                  1280),
      new Console("Sony",
                  "PS4",
                  new java.util.Date(),
                  List("BLUERAY", "DVD"),
                  4096,
                  "b/g/n"),
      new Console("MS",
                  "XBOX2",
                  new java.util.Date(),
                  List("BLUERAY", "DVD"),
                  4096,
                  "b/g/n"))
  }
}
new ConsoleLoader().init()

// c
class Game(val name: String,
           val maker: String,
           val supportedConsoleList: List[Console]) {
  def isSupported(console: Console): Boolean =
    supportedConsoleList.contains(console)
}

// remains, skip all

