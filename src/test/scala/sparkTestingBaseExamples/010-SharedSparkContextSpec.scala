/**
  * Provides SparkContext to be used in testing
  */
import com.holdenkarau.spark.testing.SharedSparkContext
import org.scalatest.FunSuite

class SharedSparkContextSpec extends FunSuite with SharedSparkContext {

  test("Test initializing spark context") {
    val list = List(1, 2, 3, 4)
    val rdd = sc.parallelize(list)

    assert(rdd.count === list.length)
  }
}
