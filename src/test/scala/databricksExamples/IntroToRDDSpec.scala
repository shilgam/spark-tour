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
      val namesRdd = rdd.map(tuple => tuple._1)
      val namesList = namesRdd.collect.toList

      assert(namesList === List("Andy", "Vlad"))
    }
  }
}
