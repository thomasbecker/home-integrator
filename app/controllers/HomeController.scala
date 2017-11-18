package controllers

import javax.inject._

import play.api._
import play.api.http.ContentTypes
import play.api.libs.{Comet, EventSource}
import play.api.mvc._

/**
  * This controller creates an `Action` to handle HTTP requests to the
  * application's home page.
  */
@Singleton
class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) with SolarTicker with MyHomeControlTicker{

  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }

  def charts() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.charts())
  }

  def streamRealtimeData() = Action {
    Ok.chunked(meterRealTimeSource via EventSource.flow).as(ContentTypes.EVENT_STREAM)
  }

  def streamPowerFlowRealtimeData() = Action {
    Ok.chunked(powerFlowRealtimeSource via EventSource.flow).as(ContentTypes.EVENT_STREAM)
  }

  def streamMyHomeControlRealtimeData() = Action {
    Ok.chunked(myHomeControlRealtimeData via EventSource.flow).as(ContentTypes.EVENT_STREAM)
  }
}
