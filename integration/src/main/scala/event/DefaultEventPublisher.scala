package event

/**
 * Created by roshansharma on 6/18/15.
 *
 * The default publisher lookup handler and call its handle method. In better Publisher will publish into bus.
 * example using Akka: system.eventStream.publish(event)
 */
  object DefaultEventPublisher extends EventPublisher {

  override def publish[T <: DomainEvent](event: T,r:Class[_ <: DomainEvent]): Unit = {
    AkkaEventBus.publish((event,r))

  }
}