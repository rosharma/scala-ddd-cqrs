name := "core"

version := "1.0"

scalaVersion := "2.11.2"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies ++= Seq("com.typesafe.akka" %% "akka-actor" % "2.3.4",
                            "com.typesafe.play" %% "play-json" % "2.3.4",
                            "com.softwaremill.macwire" %% "macros" % "0.7.3"
                           )

