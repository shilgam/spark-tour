/**
  * NAMED ARGUMENTS
  * When calling methods, you can label the arguments with their parameter names
  */
import org.scalatest.FlatSpec

class NamedArgumentsExampleSpec extends FlatSpec {
  behavior of "Named Arguments"

  def printName(first: String, last: String): String = first + " " + last

  it should "allow to change the order of named arguments" in {
    assert(printName("John", "Smith") === "John Smith")
    assert(printName(first = "John", last = "Smith") === "John Smith")
    assert(printName(last = "Smith", first = "John") === "John Smith")
  }
}
