package dj.kafkaclient

import kafka.producer.KeyedMessage
import kafka.producer.KafkaProducer
import java.util.Properties
import kafka.producer.ProducerConfig
import kafka.producer.Producer

/**
 * Kafka scala-producer simple-example 3
 */
object Main3 {
  
  def main(args: Array[String]): Unit = {
    
    val props = new Properties()
    props.put("metadata.broker.list", "192.168.90.30:9092" )
    props.put("client.id", "KafkaProducer")
    props.put("serializer.class",     "kafka.serializer.StringEncoder")
    props.put("key.serializer.class", "kafka.serializer.StringEncoder" )
    props.put("request.required.acks", "1")
    // props.put("message.send.max.retries", "2");
    // props.put("producer.type","sync")
    
    val config = new ProducerConfig(props)
    
      
    val testTopic = "my-topic-test"
    val producer = new Producer[AnyRef, AnyRef](config)
    try {
      producer.send(new KeyedMessage("my-topic-test", "sss","hello kafka (scala Main3)" ))
    } catch {
        case e: Exception => e.printStackTrace
    }
    
    // val data = new ProducerRecord[String, String]("my-topic-test", "1", s"hello at now")
    // producer.send(data)
    // producer.close()
  }  
  
}