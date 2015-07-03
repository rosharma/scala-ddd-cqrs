package contact

import com.google.inject.Inject
import command.{Command, CommandHandler}
import contact.ContactCommandHandler.{ChangeContactOwner, ContactCommand, ContactOwnerChanged}
import event.{DomainEvent, EventPublisher}
import play.api.libs.json.Json

import scala.concurrent.ExecutionContext.Implicits.global
/**
 * Created by roshansharma on 6/19/15.
 */
class  ContactCommandHandler @Inject()( eventPublishers: EventPublisher) extends CommandHandler[ContactCommand]{

  override def eventPublisher = eventPublishers

  def handleCommand(command: ContactCommand)(implicit context: String)  : Unit = command match {
    case e: ChangeContactOwner => {
      //find correct entity for that command
      val contact = ContactRepository.byId(e.id)
      //apply command to that entity
      contact.changeOwner(e.owner)
      ContactRepository.save(contact).map(t =>
      //Other modules might be listening to this change
        eventPublisher.publish(ContactOwnerChanged(contact.id, contact.owner),classOf[ContactOwnerChanged]))
    }
  }
}

object ContactCommandHandler {
  //Commands
  sealed trait ContactCommand extends Command
  case class ChangeContactOwner(id: String, owner: String) extends ContactCommand

  //Events
  sealed trait ContactEvent extends DomainEvent
  case class ContactOwnerChanged(id: String, owner: String) extends ContactEvent

  implicit val changeOwnerFormatter = Json.format[ChangeContactOwner]
}