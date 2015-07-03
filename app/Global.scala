import akka.actor.ActorSystem
import com.softwaremill.macwire.Macwire
import play.api.{Logger, GlobalSettings}

/**
 * Created by roshansharma on 6/18/15.
 */
object Global extends GlobalSettings with Macwire {

  override def onStart(app: Application) {
    Logger.info("Application has started")
    CrmEventHandlerProvider.registerProviders()
    CRMCommandProvider.registerProviders()
  }

  override def onStop(app: Application) {
    Logger.info("Application shutdown...")
  }

  //Register Command Handlers
  def registerCommandHandlers() = {

  }

  //Register Security Providers
  def registerSecurityProviders() = {

  }

  //DI using Macwire
  val wired = wiredInModule(new Application)

  override def getControllerInstance[A](controllerClass: Class[A]): A = {
    wired.lookupSingleOrThrow(controllerClass)
  }
}