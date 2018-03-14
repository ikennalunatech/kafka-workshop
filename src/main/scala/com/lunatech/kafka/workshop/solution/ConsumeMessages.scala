package com.lunatech.kafka.workshop.solution

import com.lunatech.kafka.workshop.Configuration
import com.lunatech.kafka.workshop.models.Car
import org.apache.kafka.clients.consumer.KafkaConsumer
import java.util.Properties

import scala.collection.JavaConverters._
import com.typesafe.scalalogging.LazyLogging

import io.circe.parser.decode
import com.lunatech.kafka.workshop.models.JsonFormatCodec._

import ch.qos.logback.classic.{Level,Logger}
import org.slf4j.LoggerFactory

object ConsumeMessages extends LazyLogging {
	val props = new Properties()
	props.put( "bootstrap.servers", "localhost:9092" )
	props.put( "group.id", "cars-exercise" )
	props.put( "key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer" )
	props.put( "value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer" )

	def consume = {

		val consumer = new KafkaConsumer[ String, String ]( props )
		consumer.subscribe( Configuration.kafkaTopics )

		while ( true ) {
			val records = consumer.poll( 100 )

			for ( record ← records.asScala ) {
				val decodedJson = decode[ Car ]( record.value() )
				decodedJson match {
					case Right( car ) ⇒ {
						logger.info( s"Car: ${car}" )
					}
					case Left( error ) ⇒ {
						logger.error( s"Error : ${error}", error.getCause )
					}
				}
			}

		}
	}
}