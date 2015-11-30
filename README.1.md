========================================
PRODUCER DE EJEMPLO (SCALA)
========================================
 
proyecto 01_producer
-> crera proyecto minimal-scala
-> usaar scala ide
-> adicionar plugin de eclipse 
-> sbt update
-> sbt eclipse

========================================
BROKER DE EVENTOS
========================================

-  tener una vm linux
-  descargar kafka
iniciar zoopeper
  cd /.work/kafka_2.11-0.8.2.2
  nohup bin/zookeeper-server-start.sh config/zookeeper.properties &

iniciar kafka
  cd /.work/kafka_2.11-0.8.2.2
  nohup ./bin/kafka-server-start.sh config/server.properties &

  
crear un topico
  cd /.work/kafka_2.11-0.8.2.2
  ./bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic my-topic-test
  
 ver los topicos
  ./bin/kafka-topics.sh --list --zookeeper localhost:2181
 

iniciar un consumer 
 ./bin/kafka-console-consumer.sh --zookeeper localhost:2181 --topic my-topic-test
 
iniciar un producer [escribe por comandos]
 ./bin/kafka-console-producer.sh --broker-list localhost:9092 --topic my-topic-test 
  
 kafka escuha en el puerto 9092.
 zookeeper escucha en el puerto 2181 
 zookeper almacena por defecto los datos en /tmp/zookeeper. 
 (verificar que estan escuchando  netstat -anp | grep 9092)
 
 maquina de instalacion: 
 -> 192.168.90.30
 
 configurar la maquina con iptables
 sudo vi /etc/sysconfig/iptables
 
# zookeper & kafka ports
-A INPUT -p tcp -m state --state NEW -m tcp --dport 2181 -j ACCEPT
-A INPUT -p tcp -m state --state NEW -m tcp --dport 9092 -j ACCEPT

sudo service iptables restart 

crear un producer
 con typesafe-activator (1.3.6) 
 




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
 