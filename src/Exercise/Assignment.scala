package Exercise

import scala.io.StdIn.readLine
import scala.io.Source

object Assignment extends App{
// val bufferSource = io.Source.fromFile("C:\\Users\\s.tiwari\\IdeaProjects\\untitled\\src\\Exercise\\exam_data.txt","UTF-8")
//  for(line <- bufferSource.getLines)
//    {
//      val s = line.split(",").map(_.trim).map(_.toInt)
//      if(s != "")
//        println(passNFail(s(0),s(1),s(2)))
//    }
  def passNFail(k: Int,l: Int ,M : Int):Boolean =
      if(k * l <= M) true
      else
        false

 // second question.
  val string = "1111"
  var count = 0;
  var prev = '1'
  for(ch <- string)
    {
      if(ch != prev)
        count = count+1;
      prev = ch
    }
  println(count)

  // 3rd Question


 def sumOfDigit(n:BigInt,sum:BigInt):BigInt={
   if(n == 0) sum
   else
     sumOfDigit(n/10,sum+n%10)
 }
  def coredigit(n :BigInt):BigInt =
    {
      if(n >=0 && n <= 9)
        n
      else {
        coredigit(sumOfDigit(n, 0))
      }
    }

  def ntime(S:String, n : Int): String ={
    def add(acc : String, n:Int):String =
      {
        if( n == 1)
          acc
          else
          add(acc+S,n-1)
      }
      add(S,n)
  }
  val b = BigInt(ntime("9785",7))
  println(b)
  println(coredigit(b))

}
