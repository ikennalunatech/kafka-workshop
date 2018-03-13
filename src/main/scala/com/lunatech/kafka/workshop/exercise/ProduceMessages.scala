package com.lunatech.kafka.workshop.exercise

import com.lunatech.kafka.workshop.models.Car
import spray.json._
import com.lunatech.kafka.workshop.models.JsonProtocol._

import scala.io.Source
import java.util.Properties


object ProduceMessages {

	val props = new Properties()

	//TODO Update properties object
	props.put("bootstrap.servers","localhost:9092")

	val cars = getData()

	//TODO produce JSON string messages on the test topic
	def produce = ???

	def getData() : List[Car] = {
		val source: String = Source.fromURL("http://mysafeinfo.com/api/data?list=automodels2013&format=json").getLines.mkString
		val jsonAst = source.parseJson
		val cars = jsonAst.convertTo[List[Car]]
		cars
	}
}

