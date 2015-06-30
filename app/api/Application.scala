package api

import contact.ContactCommandHandler
import contact.ContactCommandHandler.ChangeContactOwner
import play.api.mvc.{Action, Controller}

import scala.concurrent.Future

/**
 * Created by roshansharma on 6/19/15.
 */
object Application extends Controller{

  val contactCommandHandler = new ContactCommandHandler()
  // TODO ... modify requestContext Context to get detail info of user
  implicit val  requestContext: String = ""

  def index = Action.async { request =>
    Future.successful(Ok("working"))
  }

  def changeOwner = Action.async{ request =>

    val changeOwner = ChangeContactOwner("id","owner")
    contactCommandHandler.handleCommand(changeOwner)
    Future.successful(Ok(""))
  }
}
