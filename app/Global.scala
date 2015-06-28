import akka.actor.ActorSystem
import play.api.{Logger, Application, GlobalSettings}

/**
 * Created by roshansharma on 6/18/15.
 */
object Global extends GlobalSettings {

  override def onStart(app: Application) {
    Logger.info("Application has started")
    val system = ActorSystem("rew3")
    CrmEventHandler.eventHandler(system)
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
}