/** Examples from
  * https://github.com/apache/spark/blob/v2.4.3/examples/src/main/scala/org/apache/spark/examples/sql/SparkSQLExample.scala
  */
import com.holdenkarau.spark.testing.DataFrameSuiteBase
import org.scalatest.FunSpec

case class Person(name: String, age: Long)

class IntroToDataSetsSpec extends FunSpec with DataFrameSuiteBase {

  import sqlContext.implicits._

  describe("Create DataSet") {
    it("allows to create using toDS()") {
      val data = Seq(Person("Andy", 1), Person("Vlad", 2))
      val caseClassDS = data.toDS()

      // caseClassDS.printSchema()
      /** root
        * |-- name: string (nullable = true)
        * |-- age: long (nullable = false)
        */
      // caseClassDS.show()
      /** +----+---+
        * |name|age|
        * +----+---+
        * |Andy|  1|
        * |Vlad|  2|
        * +----+---+
        */
      //
    }
  }

  describe("Convert DataFrame to a DataSet") {
    it("allows to convert") {
      val data = Seq(("Andy", 1), ("Vlad", 2))
      val rdd = sc.parallelize(data)
      val df = rdd.toDF("name", "age")

      val peopleDS = df.as[Person]

      val people = peopleDS.collect.toList
      assert(people === List(Person("Andy", 1), Person("Vlad", 2)))
    }
  }
}
