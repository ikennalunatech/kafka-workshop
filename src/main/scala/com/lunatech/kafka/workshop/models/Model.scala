package com.lunatech.kafka.workshop.models

import spray.json.DefaultJsonProtocol

final case class Car(manu: String, mdl: String, yr: String)

object JsonProtocol extends DefaultJsonProtocol {
  implicit val carFormat = jsonFormat3(Car)
}
