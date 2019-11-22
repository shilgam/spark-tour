import org.apache.spark.sql.SparkSession

object SimpleApp extends App {

  def cntNumOfOccurrences(pathToFile: String, substring: String): String = {
    val spark = SparkSession.builder
      .appName("Simple Application")
      .master("local[*]")
      .getOrCreate()

    val logData = spark.read.textFile(pathToFile).cache()
    println(logData.show(numRows = 100, truncate = 150))

    val numOfOccurrences =
      logData.filter(line => line.contains(substring)).count()

    val result = s"Lines with $substring: $numOfOccurrences"

    spark.stop()

    result
  }

  val result = cntNumOfOccurrences("./src/log.txt", "a")
  println(result)
}
