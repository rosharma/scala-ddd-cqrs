import akka.actor.ActorSystem
import contact.ContactCommandHandler.ContactEvent
import contact.ContactEventHandler
import event.DefaultEventBus

/**
 * Created by kbraghubanshi on 6/26/2015.
 */
object CrmEventHandler {

  def eventHandler(system: ActorSystem) = {
      DefaultEventBus.subscribe(ContactEventHandler.instance(system),classOf[ContactEvent])
  }


}
