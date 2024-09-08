import sbt._

object Dependencies {

  private val zioVersion = "2.0.0"
  private val catsVersion = "2.10.0"

  val zio = Seq(
    "dev.zio" %% "zio" % zioVersion,
    "dev.zio" %% "zio-test" % zioVersion,
    "dev.zio" %% "zio-test-sbt" % zioVersion,
    "dev.zio" %% "zio-streams" % zioVersion,
    "dev.zio" %% "zio-test-junit" % zioVersion
  )

  val cats = Seq(
    "org.typelevel" %% "cats-core" % catsVersion
  )

  addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full)
}
