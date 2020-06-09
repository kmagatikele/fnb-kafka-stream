name := "fnb-kafka-stream"

version := "0.1"

scalaVersion := "2.12.0"

libraryDependencies ++= Seq(
  "org.apache.kafka" % "kafka-clients" % "0.10.2.1",
  "org.apache.kafka" % "kafka-streams" % "0.10.2.1",
  "ch.qos.logback" % "logback-classic" % "1.0.13",
  "ch.qos.logback" % "logback-core" % "1.0.13",
  "com.google.code.gson" % "gson" % "2.8.6"
)