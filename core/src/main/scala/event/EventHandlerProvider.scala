package event

/**
 * Created by kbraghubanshi on 6/30/2015.
 */
trait EventHandlerProvider {
  def registerProviders(t: Class[_ <: EventHandler],r: Class[_ <: DomainEvent]): Unit
}
