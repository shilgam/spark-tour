lazy val root = (project in file("."))
  .settings(
    name := "spark-tour",
    organization := "com.example",
    scalaVersion := "2.11.12"
  )

val sparkVersion = "2.4.3"

libraryDependencies ++= Seq(
  "com.holdenkarau" %% "spark-testing-base" % "2.4.3_0.12.0" % Test,
  "org.apache.spark" %% "spark-sql" % sparkVersion,
  "org.scalatest" %% "scalatest" % "3.0.8" % Test
)

mainClass in (Compile, run) := Some("SimpleApp")
parallelExecution in ThisBuild := false

// Use sbt console as spark-shell
initialCommands in console := s"""
val conf = new org.apache.spark.SparkConf()
  .setMaster("local[*]")
  .setAppName("SparkExample")
  .set("spark.driver.host", "localhost")
val sc = new org.apache.spark.SparkContext(conf)
val sqlContext = new org.apache.spark.sql.SQLContext(sc)
"""
