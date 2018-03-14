package com.lunatech.kafka.workshop.exercise

import com.lunatech.kafka.workshop.Configuration
import com.lunatech.kafka.workshop.models.Car
import org.apache.kafka.clients.consumer.KafkaConsumer
import java.util.Properties

import scala.collection.JavaConverters._
import com.typesafe.scalalogging.LazyLogging

import io.circe.parser.decode
import com.lunatech.kafka.workshop.models.JsonFormatCodec._

object ConsumeMessages extends LazyLogging {

  //TODO Update properties object
  val props = new Properties()
  props.put("bootstrap.servers", "localhost:9092")

  //TODO consume JSON string messages from the test topic
  def consume : Unit = ???
}