package contact

import domain.BaseAggregateRoot
import play.api.libs.json.Json

/**
 * Created by roshansharma on 6/18/15.
 */
case class Contact(id: String, name: String, owner: String) extends BaseAggregateRoot {

  def changeOwner(name: String) = copy(owner = name)

}

object Contact {
  implicit val contactFormat = Json.format[Contact]
}
