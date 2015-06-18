package core.event

/**
 * Created by roshansharma on 6/18/15.
 */
object DefaultEventPublisher extends EventPublisher {

  val eventHandlers: Seq[EventHandler] = Seq()

  override def publish(event: DomainEvent): Unit = {
    eventHandlers.foreach(handler =>
      if(handler.canHandle(event))
        handler.handle(event)
    )
  }
}
