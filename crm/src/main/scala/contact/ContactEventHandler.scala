package contact

import akka.actor.{Props, ActorRef, ActorSystem, Actor}
import contact.ContactCommandHandler.ContactOwnerChanged
import event.{AkkaEventHandler, EventHandler}


/**
 * Created by kbraghubanshi on 6/26/2015.
 */
class ContactEventHandler extends AkkaEventHandler{

  def receive = {
     case c: ContactOwnerChanged =>
       println("event Handler"+c.owner)
     case _ => println("Event does not exist")

  }
}

