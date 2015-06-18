package core.domain

import core.event.{DefaultEventPublisher, EventPublisher}

/**
 * Created by roshansharma on 6/18/15.
 */
trait BaseAggregateRoot extends BaseEntity{

  val id: String
  /**
   * Sample of Domain Event usage
   * Event Publisher is injected by Factory/Repo
   */
  val eventPublisher: EventPublisher = DefaultEventPublisher
}