package event

import akka.actor.Actor

/**
 * Created by roshansharma on 7/3/15.
 */
abstract class AkkaEventHandler extends EventHandler with Actor {

  override def handle(event: Object): Unit = receive

}
