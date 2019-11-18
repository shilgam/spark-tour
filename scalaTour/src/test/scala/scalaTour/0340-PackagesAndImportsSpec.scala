/**
  * PACKAGES AND IMPORTS
  * Scala uses packages to create namespaces which allow you to modularize programs
  */
import org.scalatest.FlatSpec

class PackagesAndImportsExampleSpec extends FlatSpec {
  behavior of "`Import` clauses"

  it should "allow to import everything" in {
    import scalatour.users._

    val user = new User
    val userPref = new UserPreferences
  }

  it should "allow to import one class" in {
    import scalatour.users.User

    val user = new User
  }

  it should "allow to import selected members" in {
    import scalatour.users.{User, UserPreferences}

    val user = new User
    val userPref = new UserPreferences
  }

  it should "allow to import and rename for convenience" in {
    import scalatour.users.{UserPreferences => UPrefs}

    val userPref = new UPrefs
  }
}
