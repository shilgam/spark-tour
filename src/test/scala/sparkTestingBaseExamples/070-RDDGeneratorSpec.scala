/**
  * Read about Scalacheck first
  * https://github.com/typelevel/scalacheck/blob/master/doc/UserGuide.md
  * to understand the concepts of properties and generators.
  */
import com.holdenkarau.spark.testing.{RDDGenerator, SharedSparkContext}
import org.scalacheck.Arbitrary
import org.scalacheck.Prop.forAll
import org.scalatest.FunSpec
import org.scalatestplus.scalacheck.Checkers

class RDDsCheck extends FunSpec with SharedSparkContext with Checkers {

  describe("(Use supported generator)") {
    it("map should not change number of elements") {
      val property =
        forAll(RDDGenerator.genRDD[String](sc)(Arbitrary.arbitrary[String])) {
          rdd =>
            rdd.map(_.length).count() == rdd.count()
        }

      check(property)
    }
    /**
    * More examples:
    * https://github.com/holdenk/spark-testing-base/wiki/RDDGenerator
    */
  }
}
