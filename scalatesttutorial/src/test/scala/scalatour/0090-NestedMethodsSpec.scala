import org.scalatest.{FlatSpec, Matchers}

class NestedMethodsExampleSpec extends FlatSpec {
  behavior of "Nested Methods"

  it should "be possible to nest method definitions" in {
    def factorial(x: Int): Int = {
      def fact(x: Int, accumulator: Int): Int = {
        if (x <= 1) {
          accumulator
        } else {
          fact(x - 1, x * accumulator)
        }
      }
      fact(x, 1)
    }

    assert(factorial(2) === 2)
    assert(factorial(3) === 6)
  }
}
