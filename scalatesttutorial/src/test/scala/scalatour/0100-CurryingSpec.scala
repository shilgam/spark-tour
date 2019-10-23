/**
  * Methods may have multiple parameter lists.
  */
import org.scalatest.{FlatSpec, Matchers}

class CurryingExampleSpec extends FlatSpec {
  behavior of "Methods"

  it should "be able to accept multiple parameter lists" in {

    def add(x: Int, y: Int): Int = x + y

    assert(add(2, 3) === 5)

    def addByCurrying(a: Int) = (b: Int) => a + b

    assert(addByCurrying(2)(3) === 5)
  }
}
