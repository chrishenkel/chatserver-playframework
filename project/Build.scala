import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

    val appName         = "Chatserver"
    val appVersion      = "1.0"

    val appDependencies = Seq(      
    	javaCore,
      "com.h2database" % "h2" % "1.3.168",
      "org.springframework" % "spring-context" % "4.0.1.RELEASE",
      "org.springframework" % "spring-orm" % "4.0.1.RELEASE",
      "org.springframework" % "spring-jdbc" % "4.0.1.RELEASE",
      "org.springframework" % "spring-tx" % "4.0.1.RELEASE",
      "org.springframework" % "spring-test" % "4.0.1.RELEASE" % "test",
      "org.hibernate" % "hibernate-entitymanager" % "4.1.9.Final",
      "cglib" % "cglib" % "2.2.2"
    )

    val main = play.Project(appName, appVersion, appDependencies).settings(defaultScalaSettings:_*).settings(
      
      resolvers += "JBoss repository" at "https://repository.jboss.org/nexus/content/repositories/",
      resolvers += "Scala-Tools Maven2 Snapshots Repository" at "http://scala-tools.org/repo-snapshots"
            
    )

}