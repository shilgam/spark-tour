/**
  * 'DataframeGenerator' provides an easy way to generate arbitrary DataFrames
  * Just provide the schema you want and all DataFrames will be generated with this schema.
  */
import com.holdenkarau.spark.testing.{DataframeGenerator, SharedSparkContext}
import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.types.{
  IntegerType,
  StringType,
  StructField,
  StructType
}
import org.scalatest.FunSpec
import org.scalatestplus.scalacheck.Checkers
import org.scalacheck.Prop.forAll

class DataFrameCheck extends FunSpec with SharedSparkContext with Checkers {

  describe("DataframeGenerator") {
    it("assert dataframes generated correctly") {
      val schema = StructType(
        List(StructField("name", StringType), StructField("age", IntegerType)))
      val sqlContext = new SQLContext(sc)

      val dataframeGen =
        DataframeGenerator.arbitraryDataFrame(sqlContext, schema)

      val property =
        forAll(dataframeGen.arbitrary) { dataframe =>
          dataframe.schema === schema && dataframe.count >= 0
        }

      check(property)
    }
    /**
    * More examples:
    * https://github.com/holdenk/spark-testing-base/wiki/DataFrameGenerator
    */
  }
}
