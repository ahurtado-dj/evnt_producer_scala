name := """evnt_producer_scala"""

version := "1.0"

scalaVersion := "2.11.7"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

// Change this to another test framework if you prefer
// libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % "test"


// to use xml expressions
libraryDependencies += "org.scala-lang.modules" %% "scala-xml" % "1.0.5"

//libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.3.11"

// Akka-basic + http dependencies
libraryDependencies ++= {
  val akkaV       = "2.3.12"
  val akkaStreamV = "2.0-M1"
  val scalaTestV  = "2.2.5"
  Seq(
    "com.typesafe.akka" %% "akka-actor"                           % akkaV,
    "com.typesafe.akka" %% "akka-stream-experimental"	          % akkaStreamV,
    "com.typesafe.akka" %% "akka-http-core-experimental"	      % akkaStreamV,
    "com.typesafe.akka" %% "akka-http-experimental"         	  % akkaStreamV,
    "com.typesafe.akka" %% "akka-http-xml-experimental"           % akkaStreamV,
    "com.typesafe.akka" %% "akka-http-spray-json-experimental"    % akkaStreamV,
    "com.typesafe.akka" %% "akka-http-testkit-experimental"       % akkaStreamV,
    "org.scalatest"     %% "scalatest"                            % scalaTestV % "test"
  )
}

// kafka client libraries
libraryDependencies ++= {
	val kafkaVersion       = "0.8.2.2"

	Seq(
		"org.apache.kafka" % "kafka-clients" % kafkaVersion, 
		"com.softwaremill.reactivekafka" %% "reactive-kafka-core" % "0.8.2"
	)
}

libraryDependencies ++= {
  Seq(
  	"org.slf4j" % "slf4j-api" % "1.7.12",
  	"org.slf4j" % "slf4j-simple" % "1.7.12"
  	
  )

}
