import org.scalatest.{FlatSpec, Matchers}

class HigherOrderFunctionsExampleSpec extends FlatSpec {
  behavior of "Higher order function"

  it should "be able to return a function as a result" in {
    val salaries = Seq(1.0, 2.0, 3.0)
    val doubleSalary = (x: Double) => x * 2
    val newSalaries = salaries.map(doubleSalary)

    assert(newSalaries === List(2.0, 4.0, 6.0))
  }
}
