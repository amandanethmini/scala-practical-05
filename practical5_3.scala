object practical5_3 {

  def fibSequenceRecursion(sequenceSize: Int): Seq[Long] = {
    def getNextNum(num: Long): Long = {
      if (num <= 1) {
        num
      } else {
        getNextNum(num - 1) + getNextNum(num - 2)
      }
    }

    (0L until sequenceSize).map(getNextNum)
  }

  def main(args: Array[String]): Unit = {
    val sequenceSize = 10
    val fibonacciSequence = fibSequenceRecursion(sequenceSize)
    println(s"Fibonacci Sequence of size $sequenceSize:")
    println(fibonacciSequence.mkString(", "))
  }
}
