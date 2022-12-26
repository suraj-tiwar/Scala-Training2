package Assignment

import Assignment.secondQuestion.bufferSource

object thirdQuestion extends App{

  val bufferSource = io.Source.fromFile("C:\\Users\\s.tiwari\\IdeaProjects\\untitled\\src\\Assignment\\CoreData.txt", "UTF-8")
  for (line <- bufferSource.getLines) {
      val s = line.split(" ").map(_.trim)
      val first = BigInt(s(0))
      val second  = BigInt(s(1))
    println(solution(first,second))
  }

  def sumOfDigit(n: BigInt, sum: BigInt): BigInt = {
    if (n == 0) sum   // sum of Digit code
    else
      sumOfDigit(n / 10, sum + n % 10)
  }

  def coredigit(n: BigInt): BigInt = {
    if (n >= 0 && n <= 9)  // core digit until there is sum of Digit between 0 to 9
      n
    else {
      coredigit(sumOfDigit(n, 0))
    }
  }

  def solution (first : BigInt, Second : BigInt):BigInt =
    {
      val first_core = coredigit(first)
      val second_core = coredigit(Second)
      val result = first_core * second_core
      if(result >= 0 && result <= 9)
        result
      else
        coredigit(result)
    }

}
