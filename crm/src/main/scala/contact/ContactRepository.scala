package contact

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
/**
 * Created by roshansharma on 6/19/15.
 */
object ContactRepository {

  def byId(id: String) = new Contact("1", "Hari", "Roshan")

  def save(c: Contact):Future[String] = Future("1")
}
