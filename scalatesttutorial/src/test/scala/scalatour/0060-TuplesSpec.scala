import org.scalatest.{FlatSpec, Matchers}

class TuplesExampleSpec extends FlatSpec {
  behavior of "Tuples"

  it should "allow to access elements by position" in {
    val ingredient = ("Sugar", 25)

    assert(ingredient._1 === "Sugar")
    assert(ingredient._2 === 25)
  }

  it should "be usable for pattern mathcing" in {
    val planets =
      List(
        ("Mercury", 57.9),
        ("Venus", 108.2),
        ("Earth", 149.6),
        ("Mars", 227.9)
      )

    assert(planets.map { t =>
      (t._1)
    } === List("Mercury", "Venus", "Earth", "Mars"))
  }
}
