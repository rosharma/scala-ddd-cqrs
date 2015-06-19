package query

/**
 * Created by roshansharma on 6/18/15.
 */
case class PaginatedResult[T](items: List[T],
                               pageSize: Int,
                               pageNumber: Int,
                               pagesCount: Int,
                               totalItems: Int){

  def this(items: List[T], pageNum: Int, pageSize: Int, totalItems: Int) {
    this(items, pageSize, pageNum, countPages(pageSize, totalItems), totalItems)
  }

  def countPages(size: Int, itemsCount: Int) = scala.math.ceil(itemsCount/size).toInt
}
