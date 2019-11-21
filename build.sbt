lazy val root = (project in file("."))
  .settings(
    name := "spark-tour",
    organization := "com.example",
    scalaVersion := "2.12.8"
  )

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8" % Test

mainClass in (Compile, run) := Some("CubeCalculator")
