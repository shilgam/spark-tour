/**
  * Mixins are traits which are used to compose a class.
  *
  * Classes can only have one superclass but many mixins.
  */
import org.scalatest.{FlatSpec, Matchers}

class MixinsExampleSpec extends FlatSpec {
  behavior of "Mixins"

  it should "provide ability to compose a classed using traits" in {

    abstract class A {
      val message: String
    }
    class B extends A {
      val message = "I'm an instance of class B"
    }
    trait C extends A {
      def loudMessage: String = message.toUpperCase()
    }
    class D extends B with C

    val d = new D

    assert(d.message === "I'm an instance of class B")
    assert(d.loudMessage === "I'M AN INSTANCE OF CLASS B")
  }
}
