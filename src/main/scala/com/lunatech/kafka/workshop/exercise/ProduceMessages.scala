package com.lunatech.kafka.workshop.exercise

import com.lunatech.kafka.workshop.models.Car

import scala.io.Source
import java.util.Properties


import io.circe.parser.decode
import io.circe.Error
import io.circe.syntax._
import com.lunatech.kafka.workshop.models.JsonFormatCodec._

object ProduceMessages {

	val props = new Properties()

	//TODO Update properties object
	props.put( "bootstrap.servers", "localhost:9092" )

	val cars = getData

	//TODO produce JSON string messages on the test topic
	def produce = ???

	def getData : Either[ Error, List[ Car ] ] = {
		val source : String = Source
			.fromURL( "http://mysafeinfo.com/api/data?list=automodels2013&format=json" )
			.getLines
			.mkString

		val decodedCars = decode[ List[ Car ] ]( source )
		decodedCars
	}
}

