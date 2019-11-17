/**
  * POLYMORPHIC METHODS
  */
import org.scalatest.FlatSpec

class PolymorphicMethodsExampleSpec extends FlatSpec {

  behavior of "Polymorphic Methods"

  def listOfDuplicates[A](x: A, length: Int): List[A] = {
    if (length < 1) {
      List.empty[A]
    } else {
      x :: listOfDuplicates(x, length - 1)
    }
  }

  it should "be allowed if both type parameter and value parameters provided explicitly" in {
    assert(listOfDuplicates[Int](2, 3) === List(2, 2, 2))
    assert(listOfDuplicates[String]("La", 3) === List("La", "La", "La"))
  }

  it should "be allowed even if type parameter is not provided explicitly (could be done by compiler)" in {
    assert(listOfDuplicates("La", 3) === List("La", "La", "La"))
  }
}
