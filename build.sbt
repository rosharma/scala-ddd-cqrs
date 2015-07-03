import play.PlayScala

name := "root"

version := "1.0"

scalaVersion := "2.11.2"

libraryDependencies ++= Seq(cache, ws, filters)

lazy val core = project.in(file("core"))

lazy val integration = project.in(file("integration")).dependsOn(core)

lazy val crm = project.in(file("crm")).dependsOn(core,integration)//.aggregate(core, integration)

lazy val web = project.in(file("web")).dependsOn(crm).enablePlugins(PlayScala)

lazy val root = project.in(file(".")).dependsOn(core,crm,web).aggregate(core,crm,web).enablePlugins(PlayScala)