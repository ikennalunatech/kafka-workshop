package com.lunatech.kafka.workshop.exercise

import java.util.Properties
import com.typesafe.scalalogging.LazyLogging

object ConsumeMessages extends LazyLogging {

  //TODO Update properties object
  val props = new Properties()
  props.put("bootstrap.servers", "localhost:9092")

  //TODO consume JSON string messages from the test topic
  def consume = ???
}