/**
  * DEFAULT PARAMETER VALUES
  * Scala provides the ability to give parameters default values that
  * can be used to allow a caller to omit those parameters.
  */
import org.scalatest.FlatSpec

class DefaultParameterValuesxampleSpec extends FlatSpec {
  behavior of "Default Parameter Values"

  it should "allow a caller to omit those parameters" in {
    def log(message: String, level: String = "INFO"): String =
      (s"$level: $message")

    assert(log("User not found", "WARNING") === "WARNING: User not found")

    assert(log("System starting") === "INFO: System starting")
  }
}
