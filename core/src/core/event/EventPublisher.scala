package core.event

/**
 * Created by roshansharma on 6/18/15.
 */
trait EventPublisher {

  def publish(event: DomainEvent): Unit
}
