import com.holdenkarau.spark.testing.DataFrameSuiteBase
import org.scalatest.FunSpec

class IntroToRDDSpec extends FunSpec with DataFrameSuiteBase {
  describe("Create RDD") {
    it("allows to create rdd") {
      val data = Seq(("Andy", 1), ("Vlad", 2))
      val rdd = sc.parallelize(data)

      // rdd.take(10).foreach(println)
      /** (Andy,1)
        * (Vlad,2)
        */

      val restoredRdd = rdd.map(r => (r._1, r._2))
      val restored = restoredRdd.collect.toList

      assert(restored === data)
    }
  }
}
