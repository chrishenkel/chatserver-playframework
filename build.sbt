name := "chatserver"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache
)     

libraryDependencies += "postgresql" % "postgresql" % "9.1-901-1.jdbc4"

play.Project.playJavaSettings
