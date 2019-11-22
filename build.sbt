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
