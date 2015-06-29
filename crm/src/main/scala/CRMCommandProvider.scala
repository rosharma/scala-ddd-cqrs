import contact.ContactCommandHandler
import command.DefaultHandlersProvider._
import contact.ContactCommandHandler.{ContactCommand, ChangeContactOwner}

/**
 * Created by kbraghubanshi on 6/26/2015.
 */
object CRMCommandProvider {

  def registerProviders(): Unit = {
    register(classOf[ContactCommand], new ContactCommandHandler)
  }
}
