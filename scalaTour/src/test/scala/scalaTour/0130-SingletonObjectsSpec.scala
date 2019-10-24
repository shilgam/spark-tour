/**
  *
  */
import org.scalatest.{FlatSpec, Matchers}
import logging.Logger.log

class SingletonObjectsExampleSpec extends FlatSpec {
  behavior of "Singleton Objects"

  it should "have public parameters" in {
    class Project(name: String, daysToComplete: Int)

    val project1 = new Project("Performance optimistions", 1)
    val project2 = new Project("Website redesign", 3)

    assert(log("Created projects") === "INFO: Created projects")
  }
}
