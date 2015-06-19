package command

/**
 * Created by roshansharma on 6/18/15.
 */
trait CommandBus {

  //Inject HandlerProvider
  lazy val handlerProvider: HandlersProvider = DefaultHandlersProvider

  //TODO Result R
  def dispatch[C <: Command, R](command: C): R = {

    val handler = handlerProvider.getHandler(command)

    handler.handleCommand(command)
  }
}
