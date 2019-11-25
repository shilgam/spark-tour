/**
  * Compares two RDDs
  */
import com.holdenkarau.spark.testing.{SharedSparkContext, RDDComparisons}
import org.scalatest.FunSuite

class RDDComparisonSpec
    extends FunSuite
    with SharedSparkContext
    with RDDComparisons {

  test("test RDDComparisons") {
    val expectedRDD = sc.parallelize(Seq(1, 2, 3))
    val resultRDD = sc.parallelize(Seq(3, 2, 1))

    assert(None === compareRDD(expectedRDD, resultRDD)) // equal
    assert(None !== compareRDDWithOrder(expectedRDD, resultRDD)) // not equal

    assertRDDEquals(expectedRDD, resultRDD) // equal

    intercept[org.scalatest.exceptions.TestFailedException] {
      assertRDDEqualsWithOrder(expectedRDD, resultRDD) // not equal
    }
  }
}
