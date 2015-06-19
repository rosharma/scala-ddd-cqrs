package command

/**
 * Created by roshan on 3/30/15.
 *
 * This [[HandlersProvider]] will register all the command handlers in to a Scala Map.
 * @see [[HandlersProvider]]
 */
object DefaultHandlersProvider extends HandlersProvider {

  var serviceRegistry: scala.collection.mutable.Map[Class[_ <: Command], CommandHandler] = scala.collection.mutable.Map.empty

  override def getHandler[C](command: C): CommandHandler = {
    val x = serviceRegistry collectFirst {case (c, h) if c isInstance command => h}
    x.getOrElse(throw new Exception)
  }

  override def unRegister[C <: Command, H <: CommandHandler](command: Class[C], commandHandler: H): Unit = {
    if(serviceRegistry.get(command).isDefined){
      serviceRegistry -= command
    }
  }

  override def register[C <: Command, H <: CommandHandler](command: Class[C], commandHandler: H): Unit = {
    serviceRegistry += (command -> commandHandler)
  }
}