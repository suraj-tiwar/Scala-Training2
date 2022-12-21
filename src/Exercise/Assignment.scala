package Exercise

import scala.io.StdIn.readLine
import scala.io.Source

object Assignment extends App{
 // val bufferSource = io.Source.fromFile("exam_data.docx")
  println("Entere KlM value")
  val ans = readLine().split(",")
  val ans1 = ans.map(x => x.toInt)
  println(passNFail(ans1(0),ans1(1),ans1(2)))
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
        if( n == 0)
          acc
          else
          add(acc+S,n-1)

      }
      add(S,n)
  }
  val b = BigInt(ntime("9785",4))
  println(b)
  println(coredigit(b))

}
