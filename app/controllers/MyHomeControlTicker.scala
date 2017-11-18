package controllers

/**
  * Created by Thomas Becker (thomas.becker00@gmail.com) on 16.11.17.
  */

import akka.stream.scaladsl.Source
import interfaces.{MyHomeControlCollector, MyHomeControlData}
import spray.json._

import scala.concurrent.duration._

trait MyHomeControlTicker extends JsonServerSupport {
  implicit val someFormat = jsonFormat4(MyHomeControlData)
  val myHomeControlCollector = new MyHomeControlCollector
  def myHomeControlRealtimeData: Source[String, _] = {
    val tickSource = Source.tick(0 millis, 5 seconds, "TICK")
    tickSource.map((tick) => {
      val myHomeControlData = myHomeControlCollector.collectMyHomeControlData()
      myHomeControlData.toJson.toString
    })
  }
}
