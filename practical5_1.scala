import scala.io.StdIn.readLine

object practical5_1 {
  def main(args: Array[String]): Unit = {
    val productList = getProductList()
    printProductList(productList)
    val totalProducts = getTotalProducts(productList)
    println(s"Total number of products: $totalProducts")
  }

  def getProductList(): List[String] = {
    var products: List[String] = List.empty
    var input = ""
    do {
      println("Enter a product name (type 'done' to finish): ")
      input = readLine().trim
      if (input != "done") {
        products = products :+ input
      }
    } while (input != "done")
    products
  }

  def printProductList(products: List[String]): Unit = {
    println("Product List:")
    products.zipWithIndex.foreach { case (product, index) =>
      println(s"${index + 1}. $product")
    }
  }

  def getTotalProducts(products: List[String]): Int = {
    products.length
  }
}
