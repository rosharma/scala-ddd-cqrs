package lead

import domain.BaseAggregateRoot

/**
 * Created by roshansharma on 6/18/15.
 */
case class Lead(id: String,
                name: String,
                isConverted: Boolean = false,
                convertedTo: Option[String] = None) extends BaseAggregateRoot {

  def convert(to: String) = this.copy(isConverted = true, convertedTo = Some(to))
}
