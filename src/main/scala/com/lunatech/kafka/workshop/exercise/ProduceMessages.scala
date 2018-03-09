package com.lunatech.kafka.workshop.exercise

import java.util.Properties

import com.lunatech.kafka.workshop.models.Monarch
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}
import spray.json._

import scala.io.Source


object ProduceMessages {

	val props = new Properties()
	props.put("bootstrap.servers","localhost:9092")
	props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer")
	props.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer")

	def produce = {

	    val producer = new KafkaProducer[String,String](props)
	    val source: String = Source.fromURL("http://mysafeinfo.com/api/data?list=englishmonarchs&format=json").getLines.mkString

	    val jsonAst = source.parseJson
	    val monarchs = jsonAst.convertTo[List[Monarch]]

	    monarchs.foreach{ monarch =>
	      val record = new ProducerRecord[String, String]("monarchs",monarch.toJson.toString())
	      producer.send(record)
	    }
	}
}

