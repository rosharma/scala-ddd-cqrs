package event

import akka.actor.{Props, ActorRef, ActorSystem}

/**
 * Created by kbraghubanshi on 6/30/2015.
 */
class DefaultEventHandlerProvider(implicit system: ActorSystem) extends EventHandlerProvider{


  def registerProviders(t: Class[_ <: EventHandler],r: Class[_ <: DomainEvent]): Unit = {
    val eventHandlerActorRef =  system.actorOf(Props(t), t.getClass.getName)
    AkkaEventBus.subscribe(eventHandlerActorRef,r)

  }

}
