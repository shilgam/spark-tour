/**
  * Sometimes it is necessary to express that the type of an object is a
  * subtype of several other types. In Scala this can be expressed with the
  * help of compound types, which are intersections of object types.
  */
import org.scalatest.FlatSpec

class CompoundTypesExampleSpec extends FlatSpec {
  "Compound types" should "allow to extract class methods into multiple roles" in {
    trait Callable {
      def call(): String = "Comes to you"
    }

    trait Feedable {
      def feed(): String = "Feeds"
    }
    class Dog extends Callable with Feedable

    val dog1 = new Dog
    assert(dog1.call() === "Comes to you")
    assert(dog1.feed() === "Feeds")

    /** Specify the type of obj to be both Callable and Feedable
      */
    def callAndFeed(dog: Callable with Feedable): String =
      List(dog.call(), dog.feed()).mkString(", ")

    assert(callAndFeed(dog1) === "Comes to you, Feeds")
  }

  "Example without compound types" should "demonstrate the same example" in {
    class Dog {
      def call(): String = "Comes to you"
      def feed(): String = "Feeds"
    }

    val dog1 = new Dog
    assert(dog1.call() === "Comes to you")
    assert(dog1.feed() === "Feeds")
  }
}
