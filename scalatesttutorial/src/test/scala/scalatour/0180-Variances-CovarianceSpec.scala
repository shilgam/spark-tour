// Both Cat and Dog are subtypes of Animal

abstract class Animal {
  def name: String
}

case class Cat(name: String) extends Animal
case class Dog(name: String) extends Animal

class CovarianceTest extends org.scalatest.FunSuite {
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
