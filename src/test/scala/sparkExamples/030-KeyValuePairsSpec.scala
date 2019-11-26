/**
  * A few special operations are only available on RDDs of key-value pairs.
  * The most common ones are distributed "shuffle" operations,
  * such as grouping or aggregating the elements by a key.
  */
import com.holdenkarau.spark.testing.SharedSparkContext
import org.scalatest.FunSpec

class KeyValuePairsSpec extends FunSpec with SharedSparkContext {

  describe("Special RDD operations on RDDs of key-value pairs") {
    lazy val words = List("good", "morning", "guys!")
    lazy val rdd = sc.parallelize(words)
    lazy val pairRdd = rdd.map(a => (a, a.length))

    describe("`reduceByKey` operation") {
      it("allows to count how many chars words have") {
        val pairs = pairRdd.collect().toList
        assert(pairs === List(("good", 4), ("morning", 7), ("guys!", 5)))
      }
    }

    describe("`sortByKey` operation") {
      it("allows to sort the pairs alphabetically") {
        val sortedPairRdd = pairRdd.sortByKey()
        val sortedPairs = sortedPairRdd.collect().toList
        assert(sortedPairs === List(("good", 4), ("guys!", 5), ("morning", 7)))
      }
    }
  }
}
