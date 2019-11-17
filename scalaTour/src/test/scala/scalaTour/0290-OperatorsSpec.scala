/**
  * OPERATORS
  */
import org.scalatest.FlatSpec

class OperatorsExampleSpec extends FlatSpec {
  behavior of "Operators"

  it should "allow to use any method with a single parameter as an infix operator" in {
    assert(10 + 1 === 11)
    assert(10.+(1) === 11)
  }

  it should "allow to use any legal identifier as an operator" in {
    case class Vec(x: Double, y: Double) {
      def +(that: Vec): Vec = Vec(this.x + that.x, this.y + that.y)
    }

    val vector1 = Vec(1.0, 1.0)
    val vector2 = Vec(2.0, 2.0)

    assert(vector1 + vector2 === Vec(3.0, 3.0))
  }
}
