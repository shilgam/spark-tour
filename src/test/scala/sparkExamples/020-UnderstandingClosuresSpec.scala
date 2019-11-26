import com.holdenkarau.spark.testing.SharedSparkContext
import org.scalatest.FunSpec

class UnderstandingClosuresSpec extends FunSpec with SharedSparkContext {

  describe("Understanding Closures in Spark") {
    describe("Printing elements of an RDD") {
      it("should be done properly") {
        val data = Array(1, 2, 3, 4, 5)
        val distributedData = sc.parallelize(data)

        /** wrong!
          */
        // distributedData.foreach(println)

        // Correct, but can cause the driver to run out of memory
        val collectedData = distributedData.collect().toList
        assert(collectedData === data)

        // Safer
        val collectedDataTrunc = distributedData.take(3).toList
        assert(collectedDataTrunc === Array(1, 2, 3))
      }
    }
  }
}
