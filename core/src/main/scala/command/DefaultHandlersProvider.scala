package command

/**
 * Created by roshan on 3/30/15.
 *
 * This [[HandlersProvider]] will register all the command handlers in to a Scala Map.
 * @see [[HandlersProvider]]
 */
object DefaultHandlersProvider extends HandlersProvider {

  var serviceRegistry: Map[Class[_ <: Command], CommandHandler[_ <: Command]] = Map.empty

  override def getHandler[C <: Command](command: C): Option[CommandHandler[C]] = {
    serviceRegistry collectFirst {case (c, h) if c isInstance command => h.asInstanceOf[CommandHandler[C]]}
  }

  override def unRegister[C <: Command, H <: CommandHandler[C]](command: Class[C], commandHandler: H): Unit = {
    if(serviceRegistry.get(command).isDefined){
      serviceRegistry -= command
    }
  }

  override def register[C <: Command, H <: CommandHandler[C]](command: Class[C], commandHandler: H): Unit = {
    serviceRegistry += (command -> commandHandler)
  }
}