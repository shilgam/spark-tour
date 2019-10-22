import org.scalatest.{ FlatSpec, Matchers }

class BasicExampleSpec extends FlatSpec {
  "Functions" should "be definable as named and anonymous" in {
    val addOne = (x: Int) => x + 1

    assert(addOne(2) === 3)
    assert(((x: Int) => x + 1)(2) === 3)
  }

  "Methods" should "be definable with 'def' key" in {
    def add(x: Int, y: Int): Int = x + y

    assert(add(1, 2) === 3)
  }

  "Methods" should "be definable with multiple parameter list" in {
    def addThenMultiply(x: Int, y: Int)(multiplier: Int): Int = (x + y) * multiplier

    assert(addThenMultiply(1, 2)(3) === 9)
  }

  "Methods" should "be definable with no parameter list at all" in {
    def name: String = "Adam"

    assert(name === "Adam")
  }

  "Classes" should "be definable" in {
    class Greeter(prefix: String, suffix: String) {
      def greet(name: String): String =
        prefix + name + suffix
    }

    val greeter = new Greeter("Hello, ", "!")
    assert(greeter.greet("Scala developer") === "Hello, Scala developer!")
  }

  "Case Classes" should "be immutable and comparable by value" in {
    case class Point(x: Int, y: Int)

    val point = Point(1, 2)
    val anotherPoint = Point(1, 2)
    val diffPoint = Point(2, 2)

    assert(point == anotherPoint)
    assert(point != diffPoint)
  }

  "Objects" should "be a single istances of their own definitions" in {
    object IdFactory {
      private var counter = 0
      def create(): Int = {
        counter += 1
        counter
      }
    }

    val newId: Int = IdFactory.create()
    val newerId: Int = IdFactory.create()

    assert(newerId == newId + 1)
  }


  "Traits" should "be combinable and can have default implementation" in {
    trait Greeter {
      def greet(name: String): String =
        "Hello, " + name + "!"
    }

    class DefaultGreeter extends Greeter

    class CustomizableGreeter(prefix: String, postfix: String) extends Greeter {
      override def greet(name: String): String =
        prefix + name + postfix
    }

    val greeter = new DefaultGreeter()
    val customGreeter = new CustomizableGreeter("How are you, ", "?")

    assert(greeter.greet("Mike") === "Hello, Mike!")
    assert(customGreeter.greet("Mike") === "How are you, Mike?")
  }
}
