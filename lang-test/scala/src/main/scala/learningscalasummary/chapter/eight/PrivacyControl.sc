class User {
  // private level only allow to access to itself
  private val mysecret = "super secret"
  // protected level only allow to access to itself and its child
  protected val passwd = scala.util.Random.nextString(10)
}
class ValidUser extends User {
//  def wantSecret: String = mysecret
  def isValid: Boolean = !passwd.isEmpty
}
val isValid = new ValidUser().isValid
//val passwd = new User().passwd