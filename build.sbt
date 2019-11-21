val sparkVersion = "2.4.4"

organization := "com.example"
scalaVersion := "2.11.11"
name := "spark-tour"


libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion,
  // "org.apache.spark" %% "spark-streaming" % sparkVersion,
  // "org.apache.spark" %% "spark-streaming-twitter" % sparkVersion,
  "org.apache.spark" %% "spark-sql" % sparkVersion,
  "org.scalatest" %% "scalatest" % "3.0.8" % Test
)

//mainClass := Some("CubeCalculator")
//mainClass in (Compile, run) := Some("com.alvinalexander.Foo")
mainClass in (Compile, run) := Some("CubeCalculator")
