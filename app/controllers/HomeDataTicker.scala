package controllers

/**
  * Created by Thomas Becker (thomas.becker00@gmail.com) on 16.11.17.
  */
import akka.stream.scaladsl.Source
import interfaces.HomeCollector
import spray.json._

import scala.concurrent.duration._

trait HomeDataTicker extends JsonServerSupport {
  val homeCollector = new HomeCollector

  def homeDataSource: Source[String, _] = {
    val tickSource = Source.tick(0 millis, 10 seconds, "TICK")
    tickSource.map((tick) => homeCollector.collectData.toJson.toString)
  }
}
