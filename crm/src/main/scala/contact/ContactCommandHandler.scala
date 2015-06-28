package contact

import command.{CommandHandler, Command}
import contact.ContactCommandHandler.{ContactOwnerChanged, ChangeContactOwner, ContactCommand}
import event.{DefaultEventBus, DomainEvent}
import scala.concurrent.ExecutionContext.Implicits.global
/**
 * Created by roshansharma on 6/19/15.
 */
class ContactCommandHandler extends CommandHandler[ContactCommand]{

  def handleCommand(command: ContactCommand)(implicit context: String)  : Unit = command match {
    case e: ChangeContactOwner => {
      //find correct entity for that command
      val contact = ContactRepository.byId(e.id)
      //apply command to that entity
      contact.changeOwner(e.owner)
      ContactRepository.save(contact).map(t => //Other modules might be listening to this change
        DefaultEventBus.publish((ContactOwnerChanged(contact.id, contact.owner),classOf[ContactOwnerChanged])))
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


}