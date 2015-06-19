package command

/**
 * Created by roshansharma on 6/18/15.
 *
 * CommandBus will dispatch the command to its correct [[CommandHandler]]
 */
trait CommandBus {

  //Inject HandlerProvider
  lazy val handlerProvider: HandlersProvider = DefaultHandlersProvider

  def dispatch[C <: Command](command: C) = {

    val handler = handlerProvider.getHandler(command)

    handler.getOrElse(throw new Exception).handleCommand(command)
  }
}
