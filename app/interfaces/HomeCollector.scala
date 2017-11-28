package interfaces;

/**
 * Created by Thomas Becker (thomas.becker00@gmail.com) on 28.11.17.
 */
case class HomeData(powerFlowSite: PowerFlowSite, myHomeControlData: MyHomeControlData)

class HomeCollector {
  val myHomeControlCollector = new MyHomeControlCollector
  val solarWebConnector = new SolarWebConnector

  def collectData: HomeData = {
    val myHomeControlData = myHomeControlCollector.collectMyHomeControlData()
    val powerFlowSite = solarWebConnector.getPowerFlowRealtimeData()
    new HomeData(powerFlowSite, myHomeControlData)
  }
}