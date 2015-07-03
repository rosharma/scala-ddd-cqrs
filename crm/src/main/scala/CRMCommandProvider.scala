import contact.ContactCommandHandler
import command.DefaultCommandHandlerProvider._
import contact.ContactCommandHandler.ContactCommand

/**
 * Created by kbraghubanshi on 6/26/2015.
 */
object CRMCommandProvider {

  def registerProviders(): Unit = {
    register(classOf[ContactCommand], new ContactCommandHandler)
  }
}
