import sbt._
import Keys._
 
object NunciusBuild extends Build {
 
    //val appName         = "quizzingbricks-nuncius-scala"
    //val appVersion      = "0.1-beta"
    //val scalaVersion    = "2.10.2"

    lazy val standardSettings = Defaults.defaultSettings ++ Seq(
        version         := "0.1-beta",
        scalaVersion    := "2.10.2",
        organization    := "com.quizzingbricks.nuncius"
    )

    //val appDependencies = Nil
 
    lazy val nuncius = Project(
        id          = "nuncius-core",
        base        = file("nuncius-core"),
        settings    = standardSettings ++ Seq(
            libraryDependencies ++= Seq(
                "com.typesafe.akka" %% "akka-actor" % "2.2.1", 
                "com.typesafe.akka" %% "akka-zeromq" % "2.2.1"),
            resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
        )
    )
}

/*object Dependencies {

}*/