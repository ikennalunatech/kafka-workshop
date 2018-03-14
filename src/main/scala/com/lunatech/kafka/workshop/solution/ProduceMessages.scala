package com.lunatech.kafka.workshop.solution

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
	props.put( "bootstrap.servers", "localhost:9092" )
	props.put(
		"key.serializer",
		"org.apache.kafka.common.serialization.StringSerializer"
	)
	props.put(
		"value.serializer",
		"org.apache.kafka.common.serialization.StringSerializer"
	)

	val producer = new KafkaProducer[ String, String ]( props )

	def getData : Either[ Error, List[ Car ] ] = {
		val source : String = Source
			.fromURL( "http://mysafeinfo.com/api/data?list=automodels2013&format=json" )
			.getLines
			.mkString

		val decodedCars = decode[ List[ Car ] ]( source )
		decodedCars
	}

	def produce = {
		val decodedCars = getData

		decodedCars match {
			case Right( cars ) ⇒ {
				cars.foreach { car ⇒
					val record =
						new ProducerRecord[ String, String ]( "auto", car.asJson.toString() )
					producer.send( record )
				}
			}
			case Left( error ) ⇒ {
				logger.error( s"Error : ${error}", error.getCause )
			}
		}
	}

}
