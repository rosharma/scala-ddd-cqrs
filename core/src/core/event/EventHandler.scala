package core.event

/**
 * Created by roshansharma on 6/18/15.
 */
trait EventHandler {

  def canHandle(event: Object): Boolean

  def handle(event: Object): Unit
}
