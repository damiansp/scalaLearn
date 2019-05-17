name := "irisPipeline"

version := "0.1"

scalaVersion := "2.12.8"

libraryDependencies ++= Seq(
  "joda-time" % "joda-time" % "2.9.9",
  "org.apache.spark" %% "spark-core" % "2.4.3",
  "org.apache.spark" %% "spark-mllib" % "2.4.3",
  "org.apache.spark" %% "spark-sql" % "2.4.3",
  "org.scalanlp" %% "breeze" % "0.13.2",
  "org.scalanlp" %% "breeze-viz" % "0.13.2",
  "org.scalatest" %% "scalatest" % "3.0.1" % "test",
  "org.slf4j" % "slf4j-api" % "1.7.22",
  "org.slf4j" % "slf4j-simple" % "1.7.22"
)