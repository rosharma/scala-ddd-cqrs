import play.PlayScala

name := "root"

version := "1.0"

scalaVersion := "2.11.2"

lazy val core = project.in(file("core"))

lazy val integration = project.in(file("integration")).dependsOn(core)

lazy val crm = project.in(file("crm")).dependsOn(core).aggregate(core, integration)

lazy val root = project.in(file(".")).dependsOn(crm).aggregate(crm).enablePlugins(PlayScala)