package com.lunatech.kafka.workshop.models

final case class Car( manu : String, mdl : String, yr : Int )

object JsonFormatCodec {
	import io.circe.{Decoder, Encoder, HCursor, Json}
	import cats.syntax.either._

	implicit val encoder : Encoder[ Car ] = new Encoder[ Car ] {
		final def apply( a : Car ) : Json = Json.obj(
			( "manu", Json.fromString( a.manu ) ),
			( "mdl", Json.fromString( a.mdl ) ),
			( "yr", Json.fromInt( a.yr ) )
		)
	}

	implicit val decoder : Decoder[ Car ] = new Decoder[ Car ] {
		final def apply( c : HCursor ) : Decoder.Result[ Car ] =
			for {
				manu ← c.downField( "manu" ).as[ String ]
				mdl ← c.downField( "mdl" ).as[ String ]
				yr ← c.downField( "yr" ).as[ Int ]
			} yield {
				new Car( manu, mdl, yr )
			}
	}
}
