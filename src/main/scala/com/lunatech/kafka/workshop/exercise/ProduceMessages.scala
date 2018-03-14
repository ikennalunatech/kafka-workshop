package com.lunatech.kafka.workshop.exercise

import com.lunatech.kafka.workshop.models.Car
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}

import scala.io.Source
import java.util.Properties

import io.circe.parser.decode
import io.circe.Error
import io.circe.syntax._
import com.lunatech.kafka.workshop.models.JsonFormatCodec._

import com.typesafe.scalalogging.LazyLogging

object ProduceMessages extends LazyLogging {

	val props = new Properties()

	//TODO Update properties object
	props.put( "bootstrap.servers", "localhost:9092" )

	val decodedCars : Either[ Error, List[ Car ] ] = getData()

	//TODO produce JSON string messages on the test topic
	def produce() : Unit = ???

	def getData() : Either[ Error, List[ Car ] ] = {
		val source : String = Source
			.fromURL( "http://mysafeinfo.com/api/data?list=automodels2013&format=json" )
			.getLines
			.mkString
		decode[ List[ Car ] ]( source )
	}
}

