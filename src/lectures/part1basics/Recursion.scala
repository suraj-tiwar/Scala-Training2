package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  def fact(n: Int): BigInt = {
    @tailrec
    def asceFact(n: Int, accmulator: BigInt): BigInt = {
      if (n <= 1)
        accmulator
      else
        asceFact(n - 1, n * accmulator)
    }

    asceFact(n, 1)
  }
  println(fact(5))
  //println(fact(100))

  // tail recursion is calling the function at last

  //1. Concatenate a string n times

  def concat(aString:String,n:Int,accumulator:String): String = {
   if(n <= 1)
     accumulator
   else
     concat(aString,n-1,accumulator+aString)
  }
  println(concat("Hello",10,""))


  ///  isPrime function tail recursive

  def isPrime(n:Int): Boolean =
    { @tailrec
      def helperPrime(n:Int,i: Int): Boolean = {
        if(i == 1 )
          true
          else if(n % i == 0)
          false
        else
          helperPrime(n,i-1)
        }
      helperPrime(n,n/2)
      }
      println(isPrime(7))

  // fibonaaci fucntion with tail recursion

  def fibo(n:Int): Int = {
   def fiboTailrec(i:Int,accumulator1:Int,accumulator2:Int): Int = {
     if( i == 1)
       accumulator2
     else
       fiboTailrec(i-1,accumulator2,accumulator1+accumulator2)
   }
    fiboTailrec(n,0,1)
  }
println(fibo(8))
}
