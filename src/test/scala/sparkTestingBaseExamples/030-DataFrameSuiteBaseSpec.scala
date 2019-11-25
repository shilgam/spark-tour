import com.holdenkarau.spark.testing.{DataFrameSuiteBase}
import org.scalatest.FunSpec

class DataFrameSuiteBaseSpec extends FunSpec with DataFrameSuiteBase {

  describe("DataFrameSuiteBase") {

    it("enables to check if two DataFrames are equal") {
      val sqlCtx = sqlContext
      import sqlCtx.implicits._

      val input1 = sc.parallelize(List(1, 2, 3)).toDF
      assertDataFrameEquals(input1, input1) // equal

      val input2 = sc.parallelize(List(4, 5, 6)).toDF
      intercept[org.scalatest.exceptions.TestFailedException] {
        assertDataFrameEquals(input1, input2) // not equal
      }
    }

    it("enables to compare with acceptable tolerance for ex. (5 == 4.999)") {
      val sqlCtx = sqlContext
      import sqlCtx.implicits._

      val input1 =
        sc.parallelize(List[(Int, Double)]((1, 1.1), (2, 2.2), (3, 3.3))).toDF
      val input2 =
        sc.parallelize(List[(Int, Double)]((1, 1.2), (2, 2.3), (3, 3.4))).toDF

      assertDataFrameApproximateEquals(input1, input2, 0.11)

      intercept[org.scalatest.exceptions.TestFailedException] {
        assertDataFrameApproximateEquals(input1, input2, 0.09)
      }
    }
  }
}
