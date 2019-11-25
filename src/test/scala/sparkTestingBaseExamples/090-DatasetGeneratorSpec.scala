/**
  * 'DatasetGenerator' provides an easy way to generate arbitrary Datasets,
  * to be able to check any property.
  */
import com.holdenkarau.spark.testing.{DatasetGenerator, SharedSparkContext}
import org.apache.spark.sql.SQLContext
import org.scalacheck.Arbitrary
import org.scalatest.FunSpec
import org.scalatestplus.scalacheck.Checkers
import org.scalacheck.Prop.forAll

class DatasetGeneratorSpec
    extends FunSpec
    with SharedSparkContext
    with Checkers {

  describe("DatasetGenerator") {
    describe("(Supported Generator)") {
      it("enables to use generators that are supported by default") {
        // generating Datasets[String]
        val sqlContext = new SQLContext(sc)
        import sqlContext.implicits._

        val property =
          forAll(
            DatasetGenerator.genDataset[String](sqlContext)(
              Arbitrary.arbitrary[String])) { dataset =>
            dataset.map(_.length).count() == dataset.count()
          }

        check(property)
      }
    }
    /**
    * More examples:
    * https://github.com/holdenk/spark-testing-base/wiki/Dataset-Generator
    */
  }
}
