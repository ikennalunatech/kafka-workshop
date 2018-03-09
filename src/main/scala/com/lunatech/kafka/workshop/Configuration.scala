package com.lunatech.kafka.workshop

import com.typesafe.config.ConfigFactory
import java.util._

object Configuration {

  private val config = ConfigFactory.load()

  val kafkaBrokers : String = config.getString("kafka.brokers")
  val kafkaTopics: List[String] = config.getStringList("kafka.topics")
}