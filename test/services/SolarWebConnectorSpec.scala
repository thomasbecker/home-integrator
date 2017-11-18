package services

import org.specs2.mutable.Specification
import play.api.Logger

/**
  * Created by Thomas Becker (thomas.becker00@gmail.com) on 13.11.17.
  */
class SolarWebConnectorSpec extends Specification {
  def solarWebConnector = new SolarWebConnector

  "SolarWebConnector" should {
    "return some real time inverter data when getInverterRealtimeData is called" in {
      val energy = solarWebConnector.getInverterRealtimeData().dayEnergy
      energy.unit must beEqualTo("Wh")
      energy.values.value must beGreaterThan(0)
    }

    "return some real time meter data when " in {
      val meterData = solarWebConnector.getMeterRealtimeData()
      Logger.info(s"$meterData")
      meterData.powerRealSum must not be(BigDecimal(0))
      meterData.powerRealPhase1 must not be(BigDecimal(0))
      meterData.powerRealPhase2 must not be(BigDecimal(0))
      meterData.powerRealPhase3 must not be(BigDecimal(0))
    }

    "return some power flow real time data when" in {
      val powerFlowSite = solarWebConnector.getPowerFlowRealtimeData()
      Logger.info(s"$powerFlowSite")
      powerFlowSite.powerPv must not be(BigDecimal(0))
      powerFlowSite.powerGrid must not be(BigDecimal(0))
      powerFlowSite.powerLoad must not be(BigDecimal(0))
      powerFlowSite.selfConsumption must not be(BigDecimal(0))
      powerFlowSite.autonomy must not be(BigDecimal(0))
    }

  }
}
