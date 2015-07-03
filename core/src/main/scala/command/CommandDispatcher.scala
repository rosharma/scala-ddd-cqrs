package command

import play.api.libs.json.{JsError, Json}


import scala.concurrent.Future

/**
 * Created by roshansharma on 6/18/15.
 *
 * CommandBus will dispatch the command to its correct [[CommandHandler]]
 */
object CommandDispatcher {

  //Inject HandlerProvider
  lazy val handlerProvider: CommandHandlerProvider = DefaultCommandHandlerProvider

  def dispatch[C <: Command](command: C)(implicit requestContext: String)= {

    val handler = handlerProvider.getHandler(command)

    handler match{
      case Some(commandHandler) =>
        commandHandler.handleCommand(command)
      case None => //TODO add log message)
    }

  }
}
