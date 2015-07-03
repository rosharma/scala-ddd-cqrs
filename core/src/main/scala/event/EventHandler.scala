package event

/**
 * Created by roshansharma on 6/18/15.
 *
 * These are classes that subscribes [[DomainEvent]] from the EventBus and responsible for handling that event
 *
 * Example: Akka Actor subscribing Event into EventBus
 */
trait EventHandler {

    def handle(event: Object): Unit
}
