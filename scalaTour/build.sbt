lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.8"
    )),
    name := "scala-tour"
  )

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8" % Test
