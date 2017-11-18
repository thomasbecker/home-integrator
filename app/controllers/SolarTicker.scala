package controllers

/**
  * Created by Thomas Becker (thomas.becker00@gmail.com) on 16.11.17.
  */
import akka.stream.scaladsl.Source
import interfaces.SolarWebConnector
import spray.json._

import scala.concurrent.duration._

trait SolarTicker extends JsonServerSupport {
  val solarWebConnector = new SolarWebConnector

  def meterRealTimeSource: Source[String, _] = {
    val tickSource = Source.tick(0 millis, 5 seconds, "TICK")
    tickSource.map((tick) => solarWebConnector.getMeterRealtimeData().toJson.toString)
  }

  def powerFlowRealtimeSource: Source[String, _] = {
    val tickSource = Source.tick(0 millis, 5 seconds, "powerFlowTick")
    tickSource.map((tick) => solarWebConnector.getPowerFlowRealtimeData().toJson.toString)
  }
}
