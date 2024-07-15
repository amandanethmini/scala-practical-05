import scala.io.StdIn.readLine

object practical5_1 {

  def getProductList(): List[String] = {
    var products: List[String] = List.empty
    var input = ""
    while (input != "done") {
      println("Enter a product name (type 'done' to finish): ")
      input = readLine()
      if (input != "done") {
        products = products :+ input
      }
    }
    return products
  }

  def printProductList(products: List[String]): Unit = {
    println("Product List:")
    for (index <- products.indices) {
      println(s"${index + 1}. ${products(index)}")
    }
  }

  def getTotalProducts(products: List[String]): Int = {
    products.length
  }

  def main(args: Array[String]): Unit = {
    val productList = getProductList()
    printProductList(productList)
    val totalProducts = getTotalProducts(productList)
    println(s"Total number of products: $totalProducts")
  }
}
