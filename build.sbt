import Dependencies.{akka, cats, circe, http4s, jackson, scalaParallel, slf4j, streams, tests}

ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.12"

lazy val root = (project in file("."))
  .settings(
    name := "calawithcats"
  )

libraryDependencies ++= Seq(cats, http4s, jackson, circe, tests, slf4j, akka, streams, scalaParallel).flatten

scalacOptions ++= Seq(
  "-Xfatal-warnings"
)