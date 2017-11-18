package services

import org.specs2.mutable.Specification
import play.api.Logger
/**
  * Created by Thomas Becker (thomas.becker00@gmail.com) on 17.11.17.
  */
class MyHomeControlCollectorTest extends Specification {
  def myHomeControlCollector = new MyHomeControlCollector
  "MyHomeControlCollectorTest" should {
    "collect should return a filled MyHomeControlData case class" in {
      val data = myHomeControlCollector.collectMyHomeControlData
      Logger.info(s"$data")
      data.heatpumpPowerConsumption must not be(BigDecimal(0))
      data.sleepingRoomCo2 must not be(BigDecimal(0))
      data.livingRoomTemp must not be(BigDecimal(0))
    }

  }
}
