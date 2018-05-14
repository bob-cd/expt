name := "bob_scala_mvp"
version := "1.0"
      
lazy val `bob_scala_mvp` = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.6"

libraryDependencies ++= Seq(
  specs2 % Test,
  guice,
  "com.spotify" % "docker-client" % "8.11.2"
)

      