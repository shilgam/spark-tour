/**
  * IMPLICIT CONVERSIONS
  */
import org.scalatest.FlatSpec

class ImplicitConversionsExampleSpec extends FlatSpec {

  case class Foo(i: Int)

  behavior of "Implicit conversions"

  it should "throw compilation error if `implicit` not defined" in {
    assertTypeError("Foo(3) + 1") // compilation-error (type mismatch)
  }

  it should "it should run automatically when needed otherwise" in {
    implicit def fooToInt(foo: Foo): Int = foo.i

    // now the Foo is converted to Int automatically when needed
    assert(Foo(3) + 1 === 4)
  }
}
