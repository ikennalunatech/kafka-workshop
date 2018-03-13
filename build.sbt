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
    	"io.spray" %%  "spray-json" % "1.3.3",
		  "org.apache.kafka" % "kafka-clients" % "1.0.0",
      "com.typesafe" % "config" % "1.3.1",
      "ch.qos.logback" % "logback-classic" % "1.1.2",
      "com.typesafe.scala-logging" %% "scala-logging" % "3.1.0"
    ) 
  )