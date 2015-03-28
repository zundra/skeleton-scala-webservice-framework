name := "snitch-scala"

version := "1.0"

scalaVersion := "2.11.6"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

resolvers += "sprest snapshots" at "http://sprest.io/releases"

libraryDependencies ++= {
  val akkaV = "2.3.9"
  val sprayV = "1.3.2"
  Seq(
    "io.spray" %% "spray-can" % sprayV withSources() withJavadoc(),
    "io.spray" %% "spray-routing" % sprayV withSources() withJavadoc(),
    "io.spray" %% "spray-json" % "1.3.1",
    "io.spray" %% "spray-testkit" % sprayV % "test",
    "com.typesafe.akka" %% "akka-actor" % akkaV,
    "com.typesafe.akka" %% "akka-testkit" % akkaV % "test",
    "com.typesafe" % "config" % "1.2.1",
    "org.specs2" %% "specs2-core" % "2.3.11" % "test",
    "org.specs2" %% "specs2-junit" % "2.3.11" % "test",
    "org.specs2" %% "specs2-mock" % "2.3.11" % "test",
    "com.amazonaws" % "aws-java-sdk" % "1.9.23",
    "commons-io" % "commons-io" % "2.4",
    "commons-configuration" % "commons-configuration" % "1.10",
    "com.googlecode.plist" % "dd-plist" % "1.16",
    "net.liftweb" %% "lift-json" % "2.6",
    "net.dongliu" % "apk-parser" % "2.0.6",
    "org.reactivemongo" % "reactivemongo_2.11" % "0.10.5.0.akka23",
    "sprest" %% "sprest-core" % "0.3.7",
    "sprest" %% "sprest-reactivemongo" % "0.3.7",
    "com.typesafe.scala-logging" %% "scala-logging" % "3.1.0",
    "com.typesafe.slick" %% "slick" % "2.1.0",
    "org.slf4j" % "slf4j-nop" % "1.6.4",
    "org.postgresql" % "postgresql" % "9.4-1201-jdbc41",
    "joda-time" % "joda-time" % "2.4",
    "org.joda" % "joda-convert" % "1.6",
    "com.github.tototoshi" %% "slick-joda-mapper" % "1.2.0"
  )
}




Revolver.settings

