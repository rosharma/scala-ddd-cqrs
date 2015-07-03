package event

/**
 * Created by kbraghubanshi on 6/30/2015.
 */
trait EventBus {

  def register(t: Class[_ <: EventHandler],r: Class[_ <: DomainEvent]): Unit

  def unRegister(t: Class[_ <: EventHandler],r: Class[_ <: DomainEvent]): Unit
}
