===========================
APLICACION AKKA HTTP 2
===========================

-> activator new
 (tipo minimal-scala)
 
  prc06-back-akkahttp2

-> despues incluir plugin de eclipse

crear build.sbt
crear project/plugins.sbt (con el plugin de eclipse)
ir a una consola y ejecutar
sbt eclipse

importar el proyecto en scala ide

sbt update # apra descargar las dependencias
sbt eclise # apra referscar el proyecto


===========================
PUBLICAR MENSAJES A KAFKA
===========================
instalar kafka en linux
- (kafka_2.11-0.9.0.0.tgz)
- tar -xvf kafka_2.11-0.9.0.0.tgz
cd /.work/kafka_2.11-0.9.0.0
nohup bin/zookeeper-server-start.sh config/zookeeper.properties &
nohup bin/kafka-server-start.sh config/server.properties &

#crear topic
bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test

# ver topic creado
bin/kafka-topics.sh --list --zookeeper localhost:2181

# consumer
bin/kafka-console-consumer.sh --zookeeper localhost:2181 --topic test --from-beginning

# producer
bin/kafka-console-producer.sh --broker-list localhost:9092 --topic test

# abrir puertos / configurar iptables
 sudo dnf install -y iptables-services
 sudo systemctl enable iptables
 sudo systemctl start iptables

 firewall-cmd --zone=public --add-port=2181/tcp --permanent
 firewall-cmd --zone=public --add-port=9092/tcp --permanent
 REGLAS EQUIVALENTES:
 -A INPUT -p tcp --dport 2181 -j ACCEPT
 -A INPUT -p tcp --dport 9092 -j ACCEPT
 
 # actualziar reglas
 firewall-cmd --reload

 # confgurar puertos en virtualbox (requiere apagar la maquina y configurar http://www.howtogeek.com/122641/how-to-forward-ports-to-a-virtual-machine-and-use-it-as-a-server/)
 

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
	
https://abdullin.com/post/dddd-cqrs-and-other-enterprise-development-buzz-words/
- streams: akka http://blog.michaelhamrah.com/2015/01/adding-http-server-side-events-to-akka-streams/	
- java to scala spring: http://chariotsolutions.com/blog/post/converting-java-spring-to-scala/
-spark: https://spark-summit.org/eu-2015/spark-training/


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
		se mantiene la linea de vida del proceso
		CQRS+ES
	frontend: 
		notificar de servidor a cliente los hechos que suceden en otras aplicaciones
		notificar de srvidor a cliente los hechos que estan programados por suceder: alertas

referencias
	la app de la rama: http://www.conductor.com/nightlight/build-real-time-data-stream-miley-cyrus/
	una app con play de server side y angular de clientside: http://www.toptal.com/java/building-modern-web-applications-with-angularjs-and-play-framework (en java)
	explicacion de generalidades de play http://blog.shinetech.com/2015/04/21/playing-with-play-framework-2-3-x-rest-pipelines-and-scala/
	(activator new play-scala); un poco largo; parece que trabaja es solo con play-java
	un gaming application con eventos 
		http://blog.scalac.io/2015/03/20/event-sourced-dice-game-part1.html



