package contact

import contact.Contact.{ContactCommand, ChangeContactOwner}
import command.{Command, CommandHandler}
import domain.BaseAggregateRoot

/**
 * Created by roshansharma on 6/18/15.
 */
case class Contact(id: String, name: String, owner: String) extends BaseAggregateRoot with CommandHandler {

  def changeOwner(name: String) = copy(owner = name)

  def handleCommand(command: ContactCommand) = command match {
    case ChangeContactOwner(id, owner) => {
      //val contact =

    }
  }
}

object Contact {
  sealed trait ContactCommand extends Command

  case class ChangeContactOwner(id: String, owner: String)

}
