package resources

import command.{CommandDispatcher, DefaultCommandHandlerProvider, CommandHandler}
import contact.ContactCommandHandler._
import contact.ContactQuery
import play.api.libs.json.{JsError, JsSuccess, Json}
import play.api.mvc._

import scala.concurrent.Future

/**
 * Created by kbraghubanshi on 6/29/2015.
 */
class ContactResource extends Controller{

  lazy val contactQuery = new ContactQuery

  def changeOwner =  Action.async(parse.json){ request =>
    val changeOwnerCommand = request.body.validate[ChangeContactOwner]
    implicit val requestContext: String = ""
    changeOwnerCommand.map{ command =>
      CommandDispatcher.dispatch(command)
      Future.successful(Ok(Json.toJson("contact owner changed successfully")))
    }.recoverTotal{err : JsError =>  Future.successful(BadRequest)}
  }

  def contacts = Action.async{ request =>
   val contacts =  contactQuery.getContacts
   Future.successful(Ok(Json.toJson(contacts)))
  }

}
