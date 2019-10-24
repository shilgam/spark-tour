/**
  *            https://docs.scala-lang.org/tour/regular-expression-patterns.html
  */
import org.scalatest.FlatSpec
import scala.util.matching.Regex

class RegularExpessionsExampleSpec extends FlatSpec {
  behavior of "Regular Expessions"

  it should "be converted from String by '.r' expression" in {
    val pattern = "(S|s)cala".r
    val str = "Scala is scalable and cool"

    assert((pattern findAllIn str).mkString(",") === "Scala,scala")
  }
}
