package command

import event.EventPublisher

/**
 * Created by roshansharma on 6/18/15.
 *
 */
trait CommandHandler[C <: Command] {

  def handleCommand(command: C)(implicit requestContext: String)

  import com.softwaremill.macwire.MacwireMacros._
  /**
   * Sample of Domain Event usage
   * Event Publisher is injected by Factory/Repo
   */
  val eventPublisher = wire[EventPublisher]
}