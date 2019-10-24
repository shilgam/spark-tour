/**
  * Case classes are like regular classes with a few key differences.
  * Case classes are good for modeling immutable data.
  */
import org.scalatest.{FlatSpec, Matchers}

class CaseClassesExampleSpec extends FlatSpec {
  behavior of "Case Classes"

  case class Book(isbn: String)

  it should "have public parameters" in {
    val frankenstein = Book("978-0486282114") // Notice: 'new' keyword not used

    assert(frankenstein.isbn === "978-0486282114")
  }

  it should "be comparible by structure and not by reference" in {
    val frankenstein1 = Book("978-0486282114")
    val frankenstein2 = Book("978-0486282114")

    assert(frankenstein1 === frankenstein2)
  }

  it should "be able to copy of an instance of a case class by using 'copy' method" in {
    val frankenstein = Book("978-0486282114")
    val harryPotter = frankenstein.copy(isbn = "222-2222222222")

    assert(harryPotter.isbn === "222-2222222222")
  }
}
