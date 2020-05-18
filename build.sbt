import Dependencies._

ThisBuild / scalaVersion     := "2.13.2"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "edu.trinity"
ThisBuild / organizationName := "Trinity University"

lazy val root = (project in file("."))
  .settings(
    name := "aparapi-test",
    libraryDependencies += scalaTest % Test,
		libraryDependencies += "com.aparapi" % "aparapi" % "2.0.0"

  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
