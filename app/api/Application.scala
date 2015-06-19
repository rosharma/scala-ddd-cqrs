package api

import play.api.mvc.{Action, Controller}

import scala.concurrent.Future

/**
 * Created by roshansharma on 6/19/15.
 */
object Application extends Controller{

  def index = Action.async { request =>
    Future.successful(Ok("working"))
  }
}
