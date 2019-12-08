/** Different ways to Create DataFrame in Spark
  * https://sparkbyexamples.com/spark/different-ways-to-create-a-spark-dataframe
  */
import com.holdenkarau.spark.testing.DataFrameSuiteBase
import org.apache.spark.sql.Row
import org.apache.spark.sql.types.{
  IntegerType,
  StringType,
  StructField,
  StructType
}
import org.scalatest.FunSpec

class IntroToDataFramesSpec extends FunSpec with DataFrameSuiteBase {
  import sqlContext.implicits._

  describe("Create Spark DataFrame") {
    val data = Seq(("Java", 1), ("Python", 2), ("Scala", 3))

    describe("(from RDD)") {
      lazy val rdd = sc.parallelize(data)

      it("allows to create using toDF()") {
        val df =
          rdd.toDF("language", "users_count")

        // df.printSchema()
        /** root
          * |-- language: string (nullable = true)
          * |-- users_count: integer (nullable = false)
          */
        // df.show(false)
        /**
          * +--------+-----------+
          * |language|users_count|
          * +--------+-----------+
          * |Java    |1          |
          * |Python  |2          |
          * |Scala   |3          |
          * +--------+-----------+
          */
        val restoredDF = df.map(r => (r.getAs[String](0), r.getAs[Int](1)))

        val restored = restoredDF.collect.toList

        assert(restored === data)
      }

      it("allows to create using createDataFrame() from SparkSession") {
        val columns = Seq("language", "users_count")
        val dfFromRDD2 = spark.createDataFrame(rdd).toDF(columns: _*)

        val restored =
          dfFromRDD2.select("language").map(_.getString(0)).collect.toList
        assert(restored === List("Java", "Python", "Scala"))
      }

      it("allows to create using createDataFrame() with the Row type") {
        // From RDD (USING createDataFrame and Adding schema using StructType)

        val schema = StructType(
          List(
            StructField("language", StringType, nullable = true),
            StructField("users_count", IntegerType, nullable = true)
          )
        )

        // convert RDD[T] to RDD[Row]
        val rowRDD = rdd.map(attributes => Row(attributes._1, attributes._2))
        val dfFromRDD3 = spark.createDataFrame(rowRDD, schema)

        val restored =
          dfFromRDD3.select("language").map(_.getString(0)).collect.toList
        assert(restored === List("Java", "Python", "Scala"))
      }
    }

    describe("(from List or Seq Collection)") {
      it("allows to create using toDF()") {
        val df = data.toDF()

        val restoredDF = df.map(r => (r.getAs[String](0), r.getAs[Int](1)))
        val restored = restoredDF.collect.toList

        assert(restored === data)
      }

      it("allows to create using createDataFrame() from SparkSession") {
        val columns = Seq("language", "users_count")
        val df = spark.createDataFrame(data).toDF(columns: _*)

        val restoredDF = df.map(r => (r.getAs[String](0), r.getAs[Int](1)))
        val restored = restoredDF.collect.toList

        assert(restored === data)
      }

      it("allows to create using createDataFrame() with the Row type") {
        // From Data (USING createDataFrame and Adding schema using StructType)
        import scala.collection.JavaConversions._
        val rowData = data.map(attrs => Row(attrs._1, attrs._2))

        val schema = StructType(
          List(
            StructField("language", StringType, nullable = true),
            StructField("users_count", IntegerType, nullable = true)
          )
        )

        val df = spark.createDataFrame(rowData, schema)

        val restoredDF = df.map(r => (r.getAs[String](0), r.getAs[Int](1)))
        val restored = restoredDF.collect.toList

        assert(restored === data)
      }
    }
  }
}
