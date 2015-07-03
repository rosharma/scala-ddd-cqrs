package event

import akka.actor.{ActorSystem, Props}
import akka.event.{ActorEventBus, SubchannelClassification}
import akka.util.Subclassification


/**
 * Created by kbraghubanshi on 6/26/2015.
 */
object AkkaEventBus extends ActorEventBus with SubchannelClassification with EventBus {

  val system = ActorSystem("rew3")

  type Classifier = Class[_ <: DomainEvent]
  type Event = (_, Class[_ <: DomainEvent])

  /**
   * The logic to form sub-class hierarchy
   */
  protected implicit val subclassification = new Subclassification[Classifier] {
    def isEqual(x: Classifier, y: Classifier): Boolean = x == y
    def isSubclass(x: Classifier, y: Classifier): Boolean = y.isAssignableFrom(x)
  }

  /**
   * Publishes the given Event to the given Subscriber.
   *
   * @param event The Event to publish.
   * @param subscriber The Subscriber to which the Event should be published.
   */
  override protected def publish(event: Event, subscriber: Subscriber): Unit = subscriber ! event._1

  /**
   * Returns the Classifier associated with the given Event.
   *
   * @param event The event for which the Classifier should be returned.
   * @return The Classifier for the given Event..
   */
  protected def classify(event: Event): Classifier = event._2

  override def register(t: Class[_ <: EventHandler], r: Class[_ <: DomainEvent]): Unit = {
    val eventHandlerActorRef =  system.actorOf(Props(t), t.getClass.getName)
    subscribe(eventHandlerActorRef,r)
  }

  override def unRegister(t: Class[_ <: EventHandler], r: Class[_ <: DomainEvent]): Unit = {
    val eventHandlerActorRef =  system.actorOf(Props(t), t.getClass.getName)
    unsubscribe(eventHandlerActorRef)
  }
}
