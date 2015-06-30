package contact

import akka.actor.{Props, ActorRef, ActorSystem, Actor}
import contact.ContactCommandHandler.ContactOwnerChanged


/**
 * Created by kbraghubanshi on 6/26/2015.
 */
class ContactEventHandler extends Actor{

def receive = {
   case c: ContactOwnerChanged =>
     println("event Handler"+c.owner)
   case _ => println("Event does not exist")

}

}

object ContactEventHandler {
  def instance(system: ActorSystem): ActorRef = system.actorOf(Props[ContactEventHandler], "ContactEventHandler")
}
