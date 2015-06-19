package domain

import java.util.UUID

import event.{DefaultEventPublisher, EventPublisher}

/**
 * Created by roshansharma on 6/18/15.
 */
trait BaseAggregateRoot extends BaseEntity {

  val id: String //= UUID.randomUUID().toString
  /**
   * Sample of Domain Event usage
   * Event Publisher is injected by Factory/Repo
   */
  val eventPublisher: EventPublisher = DefaultEventPublisher
}