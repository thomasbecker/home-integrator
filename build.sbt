name := """home-integrator"""
organization := "de.softwareschmied"

version := "1.0-SNAPSHOT"

PlayKeys.devSettings := Seq("play.server.http.port" -> "9000")

resolvers += Resolver.mavenLocal

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.4"

libraryDependencies += "de.softwareschmied" %% "solarweb-interface" % "0.0.1-SNAPSHOT"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test
libraryDependencies += specs2 % Test
libraryDependencies += "de.softwareschmied" % "myHomeControl-client" % "1.0-SNAPSHOT"
libraryDependencies += "com.google.code.gson" % "gson" % "2.8.2"

val akkaHttpVersion = "10.0.4"
libraryDependencies += "com.typesafe.akka" %% "akka-http" % akkaHttpVersion
libraryDependencies += "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion
libraryDependencies += "io.spray" %% "spray-json" % "1.3.3"

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "de.softwareschmied.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "de.softwareschmied.binders._"
