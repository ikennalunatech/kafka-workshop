package com.lunatech.kafka.workshop.exercise

import com.lunatech.kafka.workshop.Configuration
import com.lunatech.kafka.workshop.models.Monarch

import org.apache.kafka.clients.consumer.KafkaConsumer

import spray.json._
import com.lunatech.kafka.workshop.models.JsonProtocol._

import java.util.Properties
import scala.collection.JavaConverters._
import scala.util.Random

object ConsumeMessages {

  def run = {
    val props = new Properties()
    props.put("bootstrap.servers", "kafka-1:19092")
    props.put("group.id", Random.nextString(5))
    props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
    props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")

    val consumer = new KafkaConsumer[String, String](props)
    consumer.subscribe(Configuration.kafkaTopics)

    while(true){
      val records=consumer.poll(100)
      for (record<-records.asScala){
        val jsonAst = record.value().parseJson
        val monarch = jsonAst.convertTo[Monarch]
      }
    }
  }
}