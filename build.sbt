name := "play-web-simple"

version := "1.0.0"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.8"

// Dependencies
libraryDependencies ++= Seq(
  "com.ejisan" %% "play-pagemeta" % "1.2.1",
  "com.ejisan" %% "play-form" % "2.0.2"
)

// Web Jars Dependencies
libraryDependencies ++= Seq(
  "org.webjars.bower" % "compass-mixins" % "1.0.2",
  "org.webjars" % "webjars-play_2.11" % "2.5.0",
  "org.webjars" % "jquery" % "2.2.2",
  "org.webjars" % "foundation" % "6.2.0"
)
dependencyOverrides += "org.webjars" % "jquery" % "2.2.2"
ivyScala := ivyScala.value map { _.copy(overrideScalaVersion = true) }

// Resolvers
resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"
resolvers += "Ejisan Github" at "https://ejisan.github.io/repo/"

// Twirl importing classes
TwirlKeys.templateImports += "ejisan.play.libs.PageMeta"

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator

// Scala compiler options
scalacOptions ++= Seq(
  "-deprecation",
  "-unchecked",
  "-feature",
  "-optimise",
  "-explaintypes",
  "-encoding",
  "UTF-8",
  "-Xlint"
)
