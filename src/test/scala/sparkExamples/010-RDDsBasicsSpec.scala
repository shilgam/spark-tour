import com.holdenkarau.spark.testing.SharedSparkContext
import java.io.{File, PrintWriter}
import org.scalatest.FunSpec

class RDDsSpec extends FunSpec with SharedSparkContext {

  describe("RDDs") {
    describe("Parallelized collections") {
      it("could be created and operated on in parallel") {
        val data = Array(1, 2, 3, 4, 5)
        val distData = sc.parallelize(data)

        val sum = distData.reduce((a, b) => a + b)

        assert(sum === 15)
      }
    }

    describe("Distributed datasets") {
      it("could be created from any storage source and operated on in parallel") {

        val filePath = "./tmp/data.txt"
        new File(filePath).getParentFile().mkdirs()
        new PrintWriter(filePath) {
          write(s"""a b
               |c d
               |e f
               |""".stripMargin);
          close
        }

        val distFile = sc.textFile(filePath)

        val lineLengths = distFile.map(line => line.length)
        val totalLength = lineLengths.reduce((a, b) => a + b)
        assert(totalLength === 9)
      }
    }
  }
}
