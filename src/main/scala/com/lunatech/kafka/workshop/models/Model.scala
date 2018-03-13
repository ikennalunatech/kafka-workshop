package com.lunatech.kafka.workshop.models

import spray.json.DefaultJsonProtocol

final case class Cars(manu: String, mdl: String, yr: String)

object JsonProtocol extends DefaultJsonProtocol {
  implicit val carsFormat = jsonFormat3(Cars)
}
