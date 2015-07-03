import com.google.inject.{Injector, Guice}
import play.api.{Logger, GlobalSettings}

/**
 * Created by roshansharma on 6/18/15.
 */
object Global extends GlobalSettings {

  override def onStart(app: play.api.Application) {
    Logger.info("Application has started")
    val injector = Guice.createInjector(new ApplicationContext)

    CrmEventHandlerProvider.registerProviders()
    CRMCommandProvider.registerProviders(injector)
  }

  override def onStop(app:  play.api.Application) {
    Logger.info("Application shutdown...")
  }

  //Register Command Handlers
  def registerCommandHandlers() = {

  }

  //Register Security Providers
  def registerSecurityProviders() = {

  }
//
//  //DI using Macwire
//  val wired = wiredInModule(new Application)
//
//  override def getControllerInstance[A](controllerClass: Class[A]): A = {
//    wired.lookupSingleOrThrow(controllerClass)
//  }
}