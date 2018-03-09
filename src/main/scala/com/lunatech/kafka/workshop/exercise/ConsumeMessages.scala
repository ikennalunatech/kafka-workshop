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
  props.put("bootstrap.servers", "localhost:9092")

  def run = ???
}