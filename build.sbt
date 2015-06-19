name := "root"

version := "1.0"

scalaVersion := "2.11.2"

lazy val core = project.in(file("core"))

lazy val crm = project.in(file("crm")).dependsOn(core).aggregate(core)

lazy val root = project.in(file(".")).dependsOn(crm).aggregate(crm).enablePlugins(PlayScala)