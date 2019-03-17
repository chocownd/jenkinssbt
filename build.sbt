import Dependencies._

/**
  * If you want to affect to Whole Project level, use `ThisBuild` like below
  */
//ThisBuild / version := "0.0.1"
ThisBuild / scalaVersion := "2.12.8" // project level scalaVersion setting
//ThisBuild / organization := "chocownd"

/**
  * Can define sub project with [[sbt.Project]]
  * Actually project in file("xxx") => project(in(file("xxx))): sbt.Project
  * So in sbt, sbt.Project object's role is define project
  */
lazy val langTest = (project in file("lang-test/scala"))
  .settings(
    libraryDependencies ++= Seq(
      "org.projectlombok" % "lombok" % lombokVersion,
      "ch.qos.logback" % "logback-classic" % logbackVersion))