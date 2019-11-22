import org.apache.spark.sql.SparkSession
import org.scalatest.FunSuite

class SimpleAppTest extends FunSuite {
  test("SimpleApp.cntNumOfOccurrences") {

    val result = SimpleApp.cntNumOfOccurrences("./src/log.txt", "a")

    assert(result === "Lines with a: 3")
  }
}
