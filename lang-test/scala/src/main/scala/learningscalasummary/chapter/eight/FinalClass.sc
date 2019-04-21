final class NotExtendable {
  def pleaseOverrideThis(): Unit = {
    println("but you can't override this because class is final")
  }
}

class PartialExtendable {
  final def pleaseOverrideThis(): Unit = {
    println("but you can't override this because this is final")
  }
}

//class TryExtend extends NotExtendable
class TryExtend extends PartialExtendable {
//  override def pleaseOverrideThis(): Unit = {}
}