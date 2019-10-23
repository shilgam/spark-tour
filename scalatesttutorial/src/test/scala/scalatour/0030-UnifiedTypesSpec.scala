import org.scalatest.{FlatSpec, Matchers}

class ClassesExampleSpec extends FlatSpec {
  "'private' key" should "hide members from outside of the class" in {

    class Person {
      private val _age = 2

      def showAge: Int = _age
    }

    val person = new Person

    assert(person.showAge === 2)

    // person._age // Error: value _age in class Person cannot be accessed in Person
  }
}
