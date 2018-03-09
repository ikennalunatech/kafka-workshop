package com.lunatech.kafka.workshop.solution

import java.util.Properties

import com.lunatech.kafka.workshop.Configuration
import com.lunatech.kafka.workshop.models.Monarch
import org.apache.kafka.clients.consumer.KafkaConsumer
import spray.json._

import scala.collection.JavaConverters._
import scala.util.Random

object ConsumeMessages {

  val props = new Properties()
  props.put("bootstrap.servers", "kafka-1:19092")
  props.put("group.id", Random.nextString(5))
  props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
  props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")

  def run = ???
}