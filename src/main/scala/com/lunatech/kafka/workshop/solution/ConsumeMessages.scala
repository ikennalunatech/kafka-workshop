package com.lunatech.kafka.workshop.solution

import com.lunatech.kafka.workshop.Configuration
import com.lunatech.kafka.workshop.models.Car

import spray.json._
import com.lunatech.kafka.workshop.models.JsonProtocol._

import org.apache.kafka.clients.consumer.KafkaConsumer

import java.util.Properties
import scala.collection.JavaConverters._

import com.typesafe.scalalogging.LazyLogging

object ConsumeMessages extends LazyLogging {

  def consume = {
    val props = new Properties()
    props.put("bootstrap.servers", "localhost:9092")
    props.put("group.id", "cars-exercise")
    props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
    props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")

    val consumer = new KafkaConsumer[String, String](props)
    consumer.subscribe(Configuration.kafkaTopics)

    while(true){
      val records=consumer.poll(100)
      for (record<-records.asScala){
        val jsonAst = record.value().parseJson
        val car = jsonAst.convertTo[Car]
        logger.info("Car:" + car)
      }
    }
  }
}