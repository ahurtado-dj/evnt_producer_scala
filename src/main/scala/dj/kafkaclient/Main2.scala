package dj.kafkaclient

import akka.actor.ActorSystem
import com.softwaremill.react.kafka.ReactiveKafka
import com.softwaremill.react.kafka.ProducerProperties

import java.util.concurrent.Future
import org.apache.kafka.clients.producer.RecordMetadata

object Main2 {
  
  def main(args: Array[String]): Unit = {
    
    val topic = util.Try(args(0)).getOrElse("my-topic-test")
    println(s"Connecting to $topic")
  
    import org.apache.kafka.clients.producer.KafkaProducer
  
    val props = new java.util.Properties()
    //props.put("bootstrap.servers", "192.168.90.30:9092")
    props.put("metadata.broker.list", "192.168.90.30:9092" )
    props.put("client.id", "KafkaProducer")
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  
    val producer = new KafkaProducer[String, String](props)
  
    import org.apache.kafka.clients.producer.ProducerRecord
  
    val polish = java.time.format.DateTimeFormatter.ofPattern("dd.MM.yyyy H:mm:ss")
    val now = java.time.LocalDateTime.now().format(polish)
    val record = new ProducerRecord[String, String](topic, "1", s"hello at $now")
    val metaF: Future[RecordMetadata] = producer.send(record)
    val meta = metaF.get() // blocking!
    val msgLog =
      s"""
         |offset    = ${meta.offset()}
         |partition = ${meta.partition()}
         |topic     = ${meta.topic()}
       """.stripMargin
    println(msgLog)
  
    producer.close()
    
  }  
  
}