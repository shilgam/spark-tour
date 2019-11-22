lazy val root = (project in file("."))
  .settings(
    name := "spark-tour",
    organization := "com.example",
    scalaVersion := "2.11.12"
  )

val sparkVersion = "2.4.4"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-sql" % sparkVersion,
  "org.scalatest" %% "scalatest" % "3.0.8" % Test
)

mainClass in (Compile, run) := Some("SimpleApp")
