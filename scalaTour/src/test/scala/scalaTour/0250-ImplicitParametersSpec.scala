/**
  * IMPLICIT PARAMETERS
  * http://daily-scala.blogspot.com/2010/04/implicit-parameters.html
  */
import org.scalatest.FlatSpec

class ImplicitParametersExampleSpec extends FlatSpec {

  def p(implicit i: Int): Int = i

  implicit val v = 2

  behavior of "Implicit parameter"

  it should "be passed automatically if it not passed as usual" in {
    assert(p === 2)
  }

  it should "be overridden by explicit declarations" in {
    assert(p(1) === 1)
  }
}
