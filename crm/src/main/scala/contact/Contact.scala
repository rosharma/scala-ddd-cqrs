package contact

import domain.BaseAggregateRoot

/**
 * Created by roshansharma on 6/18/15.
 */
case class Contact(id: String, name: String, owner: String) extends BaseAggregateRoot {

  def changeOwner(name: String) = copy(owner = name)

}
