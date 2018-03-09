package com.lunatech.kafka.workshop.models

import spray.json.DefaultJsonProtocol

final case class Monarch(nm: String, cty: String, hse : String, yrs: String)

object JsonProtocol extends DefaultJsonProtocol {
  implicit val monarchFormat = jsonFormat4(Monarch)
}
