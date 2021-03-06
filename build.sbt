import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.lunatech",
      scalaVersion := "2.11.8",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "kafka-workshop",
    libraryDependencies ++= Seq(
		  "org.apache.kafka" % "kafka-clients" % "1.0.0",
      "com.typesafe" % "config" % "1.3.1",
      "ch.qos.logback" % "logback-classic" % "1.1.2",
      "com.typesafe.scala-logging" %% "scala-logging" % "3.1.0",
      "io.circe" %% "circe-core" % "0.9.1",
      "io.circe" %% "circe-generic" % "0.9.1",
      "io.circe" %% "circe-parser" % "0.9.1"
    )
  )