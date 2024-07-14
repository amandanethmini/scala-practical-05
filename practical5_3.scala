object practical5_3 {
  def fibonacci(n: Int): List[Int] = {

    def fibHelper(k: Int): Int = {
      if (k <= 1) k
      else fibHelper(k - 1) + fibHelper(k - 2)
    }

    def fibonacciList(n: Int, acc: List[Int] = Nil): List[Int] = {
      if (n <= 0) acc.reverse
      else fibonacciList(n - 1, fibHelper(n - 1) :: acc)
    }

    fibonacciList(n)
  }

  def main(args: Array[String]): Unit = {
    val n =
      10
    val fibonacciNumbers = fibonacci(n)
    println(s"First $n Fibonacci numbers: ${fibonacciNumbers.mkString(", ")}")
  }
}
