/**
  * TYPE INFERENCE
  */
import org.scalatest.FlatSpec

class TypeInferenceExampleSpec extends FlatSpec {
  behavior of "Type inference"

  it should "allow to skip result type declaration" in {
    val businessName = "Montreux Jazz Café"
  }
  it should "not allow to skip result type declaration if compiler is not able" in {
    assertTypeError(
      "def fac(n: Int) = if (n == 0) 1 else n * fac(n - 1)" // compilation-error
    )

    def fac(n: Int): Int = if (n == 0) 1 else n * fac(n - 1)
  }
}
