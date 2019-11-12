/**
  *
  *
  */
case class User(name: String, age: Int)

import org.scalatest.FlatSpec

class ForComprehensionsExampleSpec extends FlatSpec {
  behavior of "for-comprehensions"

  it should "allow to create a new collection from an existing one by applying an algorith" in {
    val userBase =
      List(User("Travis", 28), User("Kelly", 23), User("Dennis", 33))

    val twentySomethings =
      for (user <- userBase if (user.age >= 20 && user.age < 30))
        yield user.name // i.e. add this to a list

    twentySomethings.foreach(name => println(name)) // prints Travis Dennis
  }
}
