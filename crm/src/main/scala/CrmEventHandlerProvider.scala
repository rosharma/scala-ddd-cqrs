import akka.actor.ActorSystem
import contact.ContactCommandHandler.ContactEvent
import contact.ContactEventHandler
import event.DefaultEventHandlerProvider

/**
 * Created by kbraghubanshi on 6/26/2015.
 */
object CrmEventHandlerProvider {

  def registerAllProviders(implicit system: ActorSystem) = {
    val defaultEventHandlerProvider = new DefaultEventHandlerProvider()
    defaultEventHandlerProvider.registerProviders(classOf[ContactEventHandler],classOf[ContactEvent])

  }



}
