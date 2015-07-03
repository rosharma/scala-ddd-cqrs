import akka.actor.ActorSystem
import contact.ContactCommandHandler.ContactEvent
import contact.ContactEventHandler
import event.AkkaEventBus

/**
 * Created by kbraghubanshi on 6/26/2015.
 */
object CrmEventHandlerProvider {

  def registerProviders() = {
    AkkaEventBus.register(classOf[ContactEventHandler],classOf[ContactEvent])
  }
}
