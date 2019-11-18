/**
  * BY-NAME PARAMETERS are only evaluated when used.
  * To make a parameter called by-name, simply prepend => to its type.
  */
import org.scalatest.FlatSpec

class ByNameParametersExampleSpec extends FlatSpec {

  def whileLoop(condition: => Boolean)(body: => Unit): Unit =
    if (condition) {

      /** If the condition is false, the body is never evaluated
        * because we used by-name parameter
        */
      body
      whileLoop(condition)(body)
    }

  "By-name parameters" should "not evaluated if they aren’t used in the function body" in {

    var i = 3
    var list = List[Int]()

    whileLoop(i > 0) {
      list = list :+ i // append to the list
      i = i - 1
    }

    assert(list === List(3, 2, 1))
  }
}
