name := "akka-url-to-s3"
version := "0.1"

lazy val akkaVersion = "2.5.26"
lazy val akkaHttpVersion = "10.1.11"
lazy val scalaTestV = "3.0.1"
lazy val slickV = "3.3.0"


organization := "com.github.alikemalocalan"
scalaVersion := "2.13.1"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-stream" % akkaVersion,
  "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
  //"com.lightbend.akka" %% "akka-stream-alpakka-s3" % "1.1.2",
  "com.amazonaws" % "aws-java-sdk-s3" % "1.11.714",
  "commons-io" % "commons-io" % "2.6",
  "com.squareup.okhttp3" % "okhttp" % "4.3.1",

  "org.apache.logging.log4j" % "log4j-api" % "2.13.0",
  "org.apache.logging.log4j" % "log4j-slf4j-impl" % "2.13.0",
  "org.apache.logging.log4j" % "log4j-core" % "2.13.0",

  "org.scalatest" %% "scalatest" % "3.1.0" % Test
)


//enablePlugins(JavaAppPackaging)
//enablePlugins(DockerPlugin)
//enablePlugins(AshScriptPlugin)

mainClass in Compile := Some("com.github.alikemalocalan.urldownloader.App")

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

//dockerBaseImage := "openjdk:jre-alpine"
//dockerExposedPorts ++= Seq(8080, 9000)

//dockerUsername := Some("alikemalocalan")

//Revolver.settings

fork := true