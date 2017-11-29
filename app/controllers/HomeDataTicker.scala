package controllers

/**
  * Created by Thomas Becker (thomas.becker00@gmail.com) on 16.11.17.
  */

import akka.stream.scaladsl.{RestartSource, Source}
import interfaces.HomeCollector
import spray.json._

import scala.concurrent.duration._

trait HomeDataTicker extends JsonServerSupport {
  val homeCollector = new HomeCollector

  def homeDataSource: Source[String, _] = {
    val tickSource = RestartSource.withBackoff(
      minBackoff = 3.seconds,
      maxBackoff = 30.seconds,
      randomFactor = 0.2 // adds 20% "noise" to vary the intervals slightly
    ) { () =>
      Source.tick(0 millis, 20 seconds, "TICK").map((tick) => homeCollector.collectData.toJson.toString)
    }
    tickSource
  }
}