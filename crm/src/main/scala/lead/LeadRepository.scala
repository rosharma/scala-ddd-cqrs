package lead

/**
 * Created by roshansharma on 6/19/15.
 */
object LeadRepository {
  def byId(id: String) = new Lead("1", "Hari")

  def save(c: Lead) = Unit
}
