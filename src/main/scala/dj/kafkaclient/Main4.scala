package dj.skafkaclient

import java.util.Properties
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord

object Main4 {
  def main(args: Array[String]): Unit = {
    lazy val kafkaProducerParams = new Properties()
    
    kafkaProducerParams.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.90.30:9092")
    kafkaProducerParams.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer")
    kafkaProducerParams.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer")
    val producer = new KafkaProducer[String, String](kafkaProducerParams)
    val message = new ProducerRecord[String, String]("my-topic-test", "str", "messagedata")
    producer.send(message)
    //producer.close()
  }
}