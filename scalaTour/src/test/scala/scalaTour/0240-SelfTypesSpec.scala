/**
  * Self-types are a way to declare that a trait must be mixed into another trait,
  * even though it doesn’t directly extend it.
  * That makes the members of the dependency available without imports.
  */
import org.scalatest.FlatSpec

class SelfTypesExampleSpec extends FlatSpec {
  "Self-types" should "..." in {
    trait User {
      def username: String
    }

    trait Tweeter {
      this: User => // reassign this
      /** Because we said `this: User =>` in `trait Tweeter`
        * now the var `username` is in scope for the `tweet` method.
        */
      def tweet(tweetText: String): String = s"$username: $tweetText"
    }

    /** This also means that since VerifiedTweeter extends Tweeter,
      * it must also mix-in User (using `with User`).
      */
    class VerifiedTweeter(val username_ : String) extends Tweeter with User { // We mixin User because Tweeter required it
      def username: String = s"real $username_"
    }

    val realBeyoncé = new VerifiedTweeter("Beyoncé")
    assert(
      realBeyoncé
        .tweet("Just spilled my glass of lemonade") === "real Beyoncé: Just spilled my glass of lemonade"
    )
  }
}
