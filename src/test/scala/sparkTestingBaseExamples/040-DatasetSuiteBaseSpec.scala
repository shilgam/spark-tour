import com.holdenkarau.spark.testing.{DatasetSuiteBase}
import org.scalatest.FunSpec

class DatasetSuiteBaseSpec extends FunSpec with DatasetSuiteBase {

  describe("DatasetSuiteBase") {

    it("enables to check if two Datasets are equal") {
      val sqlCtx = sqlContext
      import sqlCtx.implicits._

      val input1 = sc.parallelize(List(1, 2, 3)).toDS
      assertDatasetEquals(input1, input1) // equal

      val input2 = sc.parallelize(List(4, 5, 6)).toDS
      intercept[org.scalatest.exceptions.TestFailedException] {
        assertDatasetEquals(input1, input2) // not equal
      }
    }

    it("enables to compare with acceptable tolerance for ex. (5 == 4.999)") {
      val sqlCtx = sqlContext
      import sqlCtx.implicits._

      val input1 =
        sc.parallelize(List[(Int, Double)]((1, 1.1), (2, 2.2), (3, 3.3))).toDS
      val input2 =
        sc.parallelize(List[(Int, Double)]((1, 1.2), (2, 2.3), (3, 3.4))).toDS

      assertDatasetApproximateEquals(input1, input2, 0.11)

      intercept[org.scalatest.exceptions.TestFailedException] {
        assertDatasetApproximateEquals(input1, input2, 0.09)
      }
    }
  }
}
