======================================================
 SCAFFOLD-BASICO (SCALA-ACTIVATOR)
======================================================
-> instalar typesafe-activator (1.3.7) 
-> adicionarlo al path
	
-> activator new
	tipo: minimal-scala
	nombre: evnt_producer_scala

-> probar que corre
	sbt run
	
-> despues incluir plugin de eclipse

======================================================
 SCAFFOLD-BASICO (SCALA-SBT)
======================================================

-> instalar scala
-> instalar sbt

crear build.sbt
crear project/plugins.sbt (con el plugin de eclipse)
ir a una consola y ejecutar
sbt eclipse

importar el proyecto en scala ide

sbt update # apra descargar las dependencias
sbt eclise # apra referscar el proyecto


======================================================
 EJECUCION
======================================================
 activator update
 activator run
 
	(seleccionar dj.kafkaclient.Main1)
	(seleccionar dj.kafkaclient.Main3)
 	[otros tienen versiones experimentales y pudieron haber cambiado las librerias]
	
======================================================
 AKKA HTTP 2 / SCAFFOLD-ACTIVATOR - PRODUCER DE EJEMPLO (SCALA)
======================================================
 el proyecto inicialmente contemplaba
 la invocacion de este cliente mediante la exposicion de 
 un servicio; sin embargo se ha dejado unicamente para correr por linea
 de comandos, dado que akka-http-2 ha evolucionado mas rapido que algunas 
 librerias de conectividad con akka lo cual haria el proeycto incompatible.
 

========================
OTRAS ANOTACIONES
===========================

bootzoka: bolierplate
	(scala+angular+akka-http)

	npm install-g bower
	npm install-g grunt-cli
	npm install-g yo
	descaargar de git: 
	git clone	http://softwaremill.github.io/bootzooka/
	cd bootzoka
	npm install
	bower install
	
	luego
	subir ui: 
	cd ui
	grunt server
	
	luego subor backend
	backend-start
	
prc05: 
	aplicacion generada con angular
	adicion de captura de proceso
	

ideas:
	backend: 
		controlar lo que pasa en la agencia
		los usuarios? tal vez no: no se necesita; la idea seria tener algo rapido de entidades de parametrizacion
		pero lo mas importante es tener la data alrededor de los cambios en los procesos
		los eventos modelarian los hechos
			la aplicacion de angular envia peticiones que se vuelven comandos
			con esos comandos la app genera eventos que se serializan		
		se mantiene la linea de vida del proceso
		CQRS+ES
	frontend: 
		notificar de servidor a cliente los hechos que suceden en otras aplicaciones
		notificar de srvidor a cliente los hechos que estan programados por suceder: alertas

	

===========================
REFERENCIAS 
===========================
- api-rest: http://chariotsolutions.com/blog/post/akka-http-getting-started/
- api-rest: http://chariotsolutions.com/blog/post/akka-http-getting-started/
- rabbitmq: http://blog.michaelhamrah.com/2015/01/adding-http-server-side-events-to-akka-streams/
- kafka: http://blog.jaceklaskowski.pl/2015/07/20/real-time-data-processing-using-apache-kafka-and-spark-streaming.html
- evnt sourced app: http://blog.scalac.io/2015/03/20/event-sourced-dice-game-part1.html
- evnt sourced teoria: http://cqrs.nu/
- evnt sourced teoria: https://www.kenneth-truyers.net/2013/12/05/introduction-to-domain-driven-design-cqrs-and-event-sourcing/
- evnt sourcing teoriaa: event sourcing ddd con scala
- evnt sourced - microservices teoria: https://www.tigerteam.dk/tag/event-driven-architecture-2/
- choreographed process (intercambio de mensajes con broker - modelado con domain events):http://www.slideshare.net/jeppec/soa-and-event-driven-architecture-soa-20
	tipos de aplicacion 
		(entity-data services)
		(task services)
		(process services
- evnt sourced - microservices / ejemplo uml: https://www.tigerteam.dk/2014/microservices-its-not-only-the-size-that-matters-its-also-how-you-use-them-part-4/
- ui websockets + akkahttp - http://blog.scalac.io/2015/07/30/websockets-server-with-akka-http.html
- ui eventsource: http://presentations2015.s3.amazonaws.com/61_presentation.pdf
- ui info: http://chariotsolutions.com/blog/			
	
	app ejemplo: basado en : http://chariotsolutions.com/blog/post/akka-http-getting-started/
	la app de la rama: http://www.conductor.com/nightlight/build-real-time-data-stream-miley-cyrus/
	una app con play de server side y angular de clientside: http://www.toptal.com/java/building-modern-web-applications-with-angularjs-and-play-framework (en java)
	explicacion de generalidades de play http://blog.shinetech.com/2015/04/21/playing-with-play-framework-2-3-x-rest-pipelines-and-scala/
	(activator new play-scala); un poco largo; parece que trabaja es solo con play-java
	un gaming application con eventos 
		http://blog.scalac.io/2015/03/20/event-sourced-dice-game-part1.html
	
referencias
	la app de la rama: http://www.conductor.com/nightlight/build-real-time-data-stream-miley-cyrus/
	una app con play de server side y angular de clientside: http://www.toptal.com/java/building-modern-web-applications-with-angularjs-and-play-framework (en java)
	explicacion de generalidades de play http://blog.shinetech.com/2015/04/21/playing-with-play-framework-2-3-x-rest-pipelines-and-scala/
	(activator new play-scala); un poco largo; parece que trabaja es solo con play-java
	un gaming application con eventos 
		http://blog.scalac.io/2015/03/20/event-sourced-dice-game-part1.html


	
https://abdullin.com/post/dddd-cqrs-and-other-enterprise-development-buzz-words/
- streams: akka http://blog.michaelhamrah.com/2015/01/adding-http-server-side-events-to-akka-streams/	
- java to scala spring: http://chariotsolutions.com/blog/post/converting-java-spring-to-scala/
-spark: https://spark-summit.org/eu-2015/spark-training/




otros clientes de kafka: 
-kafkacat https://github.com/edenhill/kafkacat
-kafkatool
- https://github.com/yahoo/kafka-manager

REFERENCIAS
- http://blog.jaceklaskowski.pl/2015/07/20/real-time-data-processing-using-apache-kafka-and-spark-streaming.html
- http://blog.jaceklaskowski.pl/2015/07/19/publishing-events-using-custom-producer-for-apache-kafka.html (envio simple de mensajes con el api raw - sin reactive)
- http://www.slideshare.net/miguno/apache-kafka-08-basic-training-verisign
- https://www.47deg.com/blog/spark-on-lets-code-part-2
- https://www.digitalocean.com/community/tutorials/how-to-install-apache-kafka-on-ubuntu-14-04 (instalacion)
- https://spring.io/blog/2015/04/15/using-apache-kafka-for-integration-and-data-processing-pipelines-with-spring (uso con spring)
 

===========================
REFERENCIAS / ESQUELETO BASE APP CON AKKA-HTTP
===========================

	Main extends HttpServiceActor
	  
	  IO(http)(context.system) ! Http.bind(self, "localhost", 8080)
	  
	  val bag = context.actorOf(Props[Bag],"bag")
	  
	  def receive  = runRoute {
		pathPrefix("bag") {
		  pathEnd {
			get {
			  complete("empty")
			}
		  }
		}
	 }
	 
	===================================
	object Bag {
	  case object GetAll
	  case class GetAllResponse(bag:Set[Sstring])
	}
	class Bag extends

	bag = Set.empty[String]
	 Actor {
	  def receive = {
		case GetAll =
	  }
	}}	
		