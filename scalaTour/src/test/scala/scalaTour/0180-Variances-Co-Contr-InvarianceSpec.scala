/**
  * VARIANCE is the correlation of subtyping relationships of complex types and
  * the subtyping relationships of their component types.
  *
  * The use of variance in the type system allows us to make intuitive connections between complex types:
  *  * class Foo[+A] // A covariant class
  *  * class Bar[-A] // A contravariant class
  *  * class Baz[A]  // An invariant class
  */
abstract class Animal {
  def name: String
}

case class Cat(name: String) extends Animal
case class Dog(name: String) extends Animal

import org.scalatest.FunSuite

class CovarianceExampleSpec extends FunSuite {
  test("Covariance example") {
    def returnAnimalNames(animals: List[Animal]): Unit = {
      animals.foreach { animal =>
        println(animal.name)
      }
    }

    val cats: List[Cat] = List(Cat("Whiskers"), Cat("Tom"))
    val dogs: List[Dog] = List(Dog("Fido"), Dog("Rex"))

    returnAnimalNames(cats)
    // Whiskers
    // Tom

    returnAnimalNames(dogs)
    // Fido
    // Rex
  }
}

class ContravarianceExampleSpec extends FunSuite {
  test("Contravariance example") {
    /**
      * class that knows how to print out some type A
      */
    abstract class Printer[-A] {
      def print(value: A): String
    }

    class AnimalPrinter extends Printer[Animal] {
      def print(animal: Animal): String =
        "The animal's name is: " + animal.name
    }

    class CatPrinter extends Printer[Cat] {
      def print(cat: Cat): String =
        "The cat's name is: " + cat.name
    }

    val myCat: Cat = Cat("Kitty")

    def printMyCat(printer: Printer[Cat]): String = printer.print(myCat)

    val catPrinter: Printer[Cat] = new CatPrinter
    val animalPrinter: Printer[Cat] = new AnimalPrinter

    assert(printMyCat(catPrinter) === "The cat's name is: Kitty")
    assert(printMyCat(animalPrinter) === "The animal's name is: Kitty")
  }
}

class InvarianceExampleSpec extends FunSuite {
  /**
    * Generic classes in Scala are invariant by default.
    * This means that they are neither covariant nor contravariant.
    */
  test("Invariance example") {
    /**
      * Container class is invariant.
      * A Container[Cat] is not a Container[Animal], nor is the reverse true.
      */
    class Container[A](value: A) {
      private var _value: A = value
      def getValue: A = _value
      def setValue(value: A): Unit = {
        _value = value
      }
    }

    val catContainer: Container[Cat] = new Container(Cat("Felix"))
    /**
      * It may seem like a Container[Cat] should naturally also be a Container[Animal],
      * but allowing a mutable generic class to be covariant would not be safe.
      * Fortunately, the compiler stops us long before we could get this far.
      */
    // val animalContainer: Container[Animal] = catContainer
    //
    // animalContainer.setValue(Dog("Rex"))
    // val cat: Cat = catContainer.getValue // Oops, we'd end up with a Dog assigned to a Cat
  }
}
