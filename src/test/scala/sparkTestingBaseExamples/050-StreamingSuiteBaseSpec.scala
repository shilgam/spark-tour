import com.holdenkarau.spark.testing.StreamingSuiteBase
import org.apache.spark.streaming.dstream.DStream
import org.scalatest.FunSpec

class StreamingSuiteBaseSpec extends FunSpec with StreamingSuiteBase {

  describe("StreamingSuiteBase") {

    it("enables to check if ...") {
      val input = List(List("hi"), List("hi holden"), List("bye"))
      val expected = List(List("hi"), List("hi", "holden"), List("bye"))
      testOperation[String, String](
        input,
        tokenize _,
        expected,
        ordered = false)
    }

    // This is the sample operation we are testing
    def tokenize(f: DStream[String]): DStream[String] = {
      f.flatMap(_.split(" "))
    }
    /**
    * More examples:
    * https://github.com/holdenk/spark-testing-base/wiki/StreamingSuiteBase
    */
  }
}
