package  com.lunatech.kafka.workshop.solution

import com.lunatech.kafka.workshop.models.Car
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}
import spray.json._
import com.lunatech.kafka.workshop.models.JsonProtocol._

import scala.io.Source
import java.util.Properties


object ProduceMessages {

	val props = new Properties()
	props.put("bootstrap.servers","localhost:9092")
	props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer")
	props.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer")

	val producer = new KafkaProducer[String,String](props)

	def produce = {
	    val cars = getData()

	    cars.foreach{ car =>
	      val record = new ProducerRecord[String, String]("auto",car.toJson.toString())
	      producer.send(record)
	    }
	}

	def getData() : List[Car] = {
		val source: String = Source.fromURL("http://mysafeinfo.com/api/data?list=automodels2013&format=json").getLines.mkString
		val jsonAst = source.parseJson
		val cars = jsonAst.convertTo[List[Car]]
		cars
	}
}

