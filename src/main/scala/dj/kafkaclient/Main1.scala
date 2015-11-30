package dj.kafkaclient

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.{Sink, Source}
import kafka.serializer.{StringDecoder, StringEncoder}
import org.reactivestreams.{Publisher, Subscriber}
import com.softwaremill.react.kafka.{ReactiveKafka, ProducerProperties, ConsumerProperties}
import com.softwaremill.react.kafka.KafkaMessages.StringKafkaMessage

object Main1 extends App {
  
  implicit val actorSystem = ActorSystem("ReactiveKafka")
  implicit val materializer = ActorMaterializer()
  
  val kafka = new ReactiveKafka()
  val publisher: Publisher[StringKafkaMessage] = kafka.consume(ConsumerProperties(
    brokerList = "192.168.90.30:9092",
    zooKeeperHost = "192.168.90.30:2181",
    topic = "my-topic-test",
    groupId = "groupName",
    decoder = new StringDecoder()
  ))
  val subscriber: Subscriber[String] = kafka.publish(ProducerProperties(
    brokerList = "192.168.90.30:9092",
    topic = "my-topic-test",
    encoder = new StringEncoder()
  ))
  
  Source(publisher).map(_.message().toUpperCase).to(Sink(subscriber)).run()  
}