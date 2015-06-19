package command

/**
 * Created by roshansharma on 6/18/15.
 *
 */
trait CommandHandler {

  def handleCommand[C <: Command, R](command: C): R
}
