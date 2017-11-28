package controllers

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import interfaces._
import spray.json.DefaultJsonProtocol

/**
  * Created by Thomas Becker (thomas.becker00@gmail.com) on 15.11.17.
  */
trait JsonServerSupport extends SprayJsonSupport with DefaultJsonProtocol {
  implicit val meterDataFormat = jsonFormat5(MeterData)
  implicit val myHomeControlDataFormat = jsonFormat4(MyHomeControlData)
  implicit val powerFlowSiteFormat = jsonFormat6(PowerFlowSite)
  implicit val homeData = jsonFormat3(HomeData)
}
