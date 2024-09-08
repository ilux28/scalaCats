import Dependencies.{cats, zio}

ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.3"


lazy val root = (project in file("."))
  .settings(
    name := "calawithcats"
  )

libraryDependencies ++= Seq(zio, cats).flatten

testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework")

scalacOptions ++= Seq(
  "-Xfatal-warnings"
)