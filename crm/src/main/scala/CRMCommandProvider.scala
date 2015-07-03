import com.google.inject.Injector
import contact.ContactCommandHandler
import command.DefaultCommandHandlerProvider._
import contact.ContactCommandHandler.ContactCommand
import event.AkkaEventPublisher

/**
 * Created by kbraghubanshi on 6/26/2015.
 */
object CRMCommandProvider {


  def registerProviders(injector: Injector): Unit = {
    val contactCommandHandler = injector.getInstance(classOf[ContactCommandHandler])

    register(classOf[ContactCommand], contactCommandHandler)
  }
}
