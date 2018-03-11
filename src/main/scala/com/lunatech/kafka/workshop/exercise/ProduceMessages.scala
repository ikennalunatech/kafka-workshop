package com.lunatech.kafka.workshop.exercise

import com.lunatech.kafka.workshop.models.Monarch


import spray.json._
import com.lunatech.kafka.workshop.models.JsonProtocol._

import scala.io.Source
import java.util.Properties


object ProduceMessages {

	val props = new Properties()
	props.put("bootstrap.servers","localhost:9092")

	val monarchs = getData()

	//TODO produce JSON string messages on the test topic
	def produce = ???

	def getData() : List[Monarch] = {
		val source: String = Source.fromURL("http://mysafeinfo.com/api/data?list=englishmonarchs&format=json").getLines.mkString
		val jsonAst = source.parseJson
		val monarchs = jsonAst.convertTo[List[Monarch]]
		monarchs
	}
}

