/**
  *
  *
  */
import org.scalatest.FlatSpec

class UpperTypeBoundsExampleSpec extends FlatSpec {
  behavior of "Upper Type Bounds"

  it should "limit the concrete values of the type variables" in {
    abstract class Animal {
      def name: String
    }

    abstract class Pet extends Animal {}

    class Cat extends Pet {
      override def name: String = "Cat"
    }

    class Dog extends Pet {
      override def name: String = "Dog"
    }

    class Lion extends Animal {
      override def name: String = "Lion"
    }

    class PetContainer[P <: Pet](p: P) {
      def pet: P = p
    }

    val dogContainer = new PetContainer[Dog](new Dog)
    val catContainer = new PetContainer[Cat](new Cat)
    assert(1 === 1)
  }
}
