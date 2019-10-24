/**
  * Pattern matching is a mechanism for checking a value against a pattern.
  *
  * It is a more powerful version of the switch statement in Java
  * It can also be used in place of a series of if/else statements
  */
import org.scalatest.{FlatSpec, Matchers}
import scala.util.Random

class PatternMatchingExampleSpec extends FlatSpec {
  behavior of "Pattern Matching"

  it should "be easy to do using 'match...case' clause" in {

    def matchNubmer(number: Int): String = number match {
      case 0 => "zero"
      case 1 => "one"
      case _ => "other"
    }

    assert(matchNubmer(0) === "zero")
    assert(matchNubmer(1) === "one")
    assert(matchNubmer(3) === "other")
  }

  it should "be easy to do using case classes" in {
    abstract class Notification

    case class Email(sender: String, title: String, body: String)
        extends Notification

    case class SMS(caller: String, message: String) extends Notification

    case class VoiceRecording(contactName: String, link: String)
        extends Notification

    def showNotification(notification: Notification): String = {
      notification match {
        case Email(sender, title, _) =>
          s"You got an email from $sender with title: $title"
        case SMS(number, message) =>
          s"You got an SMS from $number! Message: $message"
        case VoiceRecording(name, link) =>
          s"You received a Voice Recording from $name! Click the link to hear it: $link"
      }
    }

    val someSms = SMS("+7(927)222-2222", "Are you there?")
    val someVoiceRecording = VoiceRecording("Tom", "voicerecording.org/id/123")

    assert(
      showNotification(someSms) === "You got an SMS from +7(927)222-2222! Message: Are you there?"
    )
    assert(
      showNotification(someVoiceRecording) === "You received a Voice Recording from Tom! Click the link to hear it: voicerecording.org/id/123"
    )
  }
}
