package command

/**
 * Created by roshan on 3/30/15.
 *
 * This [[CommandHandlerProvider]] will register all the command handlers in to a Scala Map.
 * @see [[CommandHandlerProvider]]
 */
object DefaultCommandHandlerProvider extends CommandHandlerProvider {

  var commandRegistry: Map[Class[_ <: Command], CommandHandler[_ <: Command]] = Map.empty

  override def getHandler[C <: Command](command: C): Option[CommandHandler[C]] = {
    commandRegistry collectFirst {case (c, h) if c isInstance command => h.asInstanceOf[CommandHandler[C]]}
  }

  override def unRegister[C <: Command, H <: CommandHandler[C]](command: Class[C], commandHandler: H): Unit = {
    if(commandRegistry.get(command).isDefined){
      commandRegistry -= command
    }
  }

  override def register[C <: Command, H <: CommandHandler[C]](command: Class[C], commandHandler: H): Unit = {
    commandRegistry += (command -> commandHandler)
  }
}