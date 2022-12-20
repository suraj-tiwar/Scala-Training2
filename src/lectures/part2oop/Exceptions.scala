package lectures.part2oop

object Exceptions extends App{
  val x: String = null
  ///println(x.length) this will crash with a NPE
  //val aWeirdValue  = throw new NullPointerException // instance of the classes
  // how to catch exception
  def getInt(WithException : Boolean) : Int = if(WithException) throw new RuntimeException("No int fo you")
  else 42

  val potentialFail = try
    {
      getInt(false)

    }
    catch
      {
        case e : RuntimeException => 43
      }
  finally
    {
      println("finally")
    }

println(potentialFail)

  // 3. how to define your own exceptions

  class MyExpection extends Exception
  val expection = new MyExpection
  //throw expection

  /*
   1. Crash program
*/

  object PocketCalculator {
    def add(x: Int, y: Int): Int =
      {
        val result = x + y
        if( x < 0 && y < 0 && result > 0) throw new UnderFlowException
        else if(x > 0  && y > 0 && result < 0) throw new OverFlowException
        else
          result
      }

    def sub(x:Int, y : Int) = {
      val result = x - y
      if(x > 0 && y < 0 && result < 0)throw new OverFlowException
      else if(x <0 && y > 0 && result > 0) throw new UnderFlowException
      else
        result
    }
    def multiply(x:Int,y:Int) : Int  = {
      val result = x * y
      if(x > 0 && y > 0 && result < 0) throw new OverFlowException
      else if(x < 0 && y < 0 && result < 0) throw new OverFlowException
      else if(x > 0 && y < 0 && result > 0) throw new UnderFlowException
      else if(x < 0 && y > 0 && result > 0) throw new UnderFlowException
      else
        result
    }

    def divide(x :Int, y: Int)= {
      if( y == 0 ) throw new MathCalculationException
      else
        x /y
    }


  }

 class OverFlowException extends  RuntimeException
 class UnderFlowException extends RuntimeException
 class MathCalculationException extends RuntimeException("Division by Zero")
 //  val array = Array.ofDim(Int.MaxValue)

  //println(PocketCalculator.add(Int.MaxValue,10))
  println(PocketCalculator.divide(78,0))


}
