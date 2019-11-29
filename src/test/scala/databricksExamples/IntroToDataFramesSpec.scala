/** Different ways to Create DataFrame in Spark
  * https://sparkbyexamples.com/spark/different-ways-to-create-a-spark-dataframe
  */
import com.holdenkarau.spark.testing.DataFrameSuiteBase
import org.apache.spark.sql.Row
import org.apache.spark.sql.types.{StringType, StructField, StructType}
import org.scalatest.FunSpec

class IntroToDataFramesSpec extends FunSpec with DataFrameSuiteBase {
  import sqlContext.implicits._

  describe("Create Spark DataFrame") {
    val columns = Seq("language", "users_count")
    val data = Seq(("Java", "1"), ("Python", "2"), ("Scala", "3"))

    describe("(from RDD)") {
      lazy val rdd = sc.parallelize(data)

      it("allows to create using toDF()") {
        val dfFromRDD1 = rdd.toDF("language", "users_count")
        // dfFromRDD1.printSchema()
        /** root
          * |-- language: string (nullable = true)
          * |-- users: string (nullable = true)
          */
        val languages =
          dfFromRDD1.select("language").map(_.getString(0)).collect.toList
        assert(languages === List("Java", "Python", "Scala"))
      }

      it("allows to create using createDataFrame() from SparkSession") {
        val dfFromRDD2 = spark.createDataFrame(rdd).toDF(columns: _*)

        val languages =
          dfFromRDD2.select("language").map(_.getString(0)).collect.toList
        assert(languages === List("Java", "Python", "Scala"))
      }

      it("allows to create using createDataFrame() with the Row type") {
        // From RDD (USING createDataFrame and Adding schema using StructType)
        val schema = StructType(
          columns
            .map(fieldName =>
              StructField(fieldName, StringType, nullable = true)))

        // convert RDD[T] to RDD[Row]
        val rowRDD = rdd.map(attributes => Row(attributes._1, attributes._2))
        val dfFromRDD3 = spark.createDataFrame(rowRDD, schema)

        val languages =
          dfFromRDD3.select("language").map(_.getString(0)).collect.toList
        assert(languages === List("Java", "Python", "Scala"))
      }
    }

    describe("(from List and Seq Collection)") {
      it("allows to create using toDF()") {
        val dfFromData1 = data.toDF()

        val languages =
          dfFromData1.select("_1").map(_.getString(0)).collect.toList
        assert(languages === List("Java", "Python", "Scala"))
      }

      it("allows to create using createDataFrame() from SparkSession") {
        val dfFromRDD2 = spark.createDataFrame(data).toDF(columns: _*)

        val languages =
          dfFromRDD2.select("language").map(_.getString(0)).collect.toList
        assert(languages === List("Java", "Python", "Scala"))
      }

      it("allows to create using createDataFrame() with the Row type") {
        // From Data (USING createDataFrame and Adding schema using StructType)
        import scala.collection.JavaConversions._
        val rowData = data.map(attrs => Row(attrs._1, attrs._2))

        val schema = StructType(
          columns
            .map(fieldName =>
              StructField(fieldName, StringType, nullable = true)))

        val dfFromData3 = spark.createDataFrame(rowData, schema)

        val languages =
          dfFromData3.select("language").map(_.getString(0)).collect.toList
        assert(languages === List("Java", "Python", "Scala"))
      }
    }
  }
}
