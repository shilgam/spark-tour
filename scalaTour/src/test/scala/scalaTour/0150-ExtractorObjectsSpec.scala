/**
  * An EXTRACTOR OBJECT is an object with an `unapply` method.
  * `unapply` method takes an object and tries to give back the arguments.
  * This is most often used in pattern matching and partial functions.
  */
import org.scalatest.FlatSpec
import scala.util.Random

object CustomerID {

  def apply(name: String): String = s"$name--${Random.nextLong}"

  def unapply(customerID: String): Option[String] = {
    val stringArray: Array[String] = customerID.split("--")
    if (stringArray.tail.nonEmpty) Some(stringArray.head) else None
  }
}

class ExtractorObjectsExampleSpec extends FlatSpec {
  behavior of "Extractor Objects"

  it should "allow to call `unapply` method implicitly" in {
    val customerID = CustomerID("Nico")

    val CustomerID(name) = customerID
    assert(name === "Nico")
  }

  it should "allow to call `unapply` method explicitly" in {
    val customerID = CustomerID("Nico")

    val name = CustomerID.unapply(customerID).get
    assert(name === "Nico")
  }

  it should "throw `scala.MatchError` there is no match" in {
    val CustomerID(name) = "--asdfasdfasdf"
    assert(name === "")

    assertThrows[scala.MatchError] {
      val CustomerID(name3) = "-asdfasdfasdf"
    }
  }
}
