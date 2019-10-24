import scala.math._
import org.scalatest.{FlatSpec, Matchers}

class CompanionObjectsExampleSpec extends FlatSpec with Matchers {
  behavior of "Companion Objects"

  it should "be able to access the private members of its companion" in {

    object Circle {
      private def calculateArea(radius: Double): Double = Pi * pow(radius, 2.0)
    }

    case class Circle(radius: Double) {
      import Circle._

      def area: Double =
        calculateArea(radius) // access the private method of the object
    }

    val circle1 = Circle(5.0)

    assert(circle1.area === (78.539 +- 0.001))
  }
}
