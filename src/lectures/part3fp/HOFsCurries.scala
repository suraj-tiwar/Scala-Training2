package lectures.part3fp

object HOFsCurries extends App{
//  val superFuct :(Int,(String,(Int => Boolean))=> Int) => Int=>Int = ???


  def nTimes(f:Int => Int , n : Int,x:Int):Int =
    if(n <= 0) x
    else
      nTimes(f,n-1,f(x))

  val PlusOne :Int =>Int =x => x+1
  println(nTimes(PlusOne,4,1))

  def NTimes(f: Int => Int, n : Int):Int => Int =
    if(n <= 0) (x:Int) => x
    else (x:Int) => NTimes(f,n-1)(f(x))
  val plus10 = NTimes(PlusOne,10)
  println(plus10(1))
  val superAdder :Int => Int => Int = (x:Int) => (y:Int) => x+y
  def curriedFormatter (c:String)(x:Double) : String = c.format(x)
  val standardFunction :(Double => String) = curriedFormatter("%5.5f")
  println(standardFunction(Math.PI))
  println(curriedFormatter("%4.2f")(Math.PI))
  println(curriedFormatter("%4.10f")(Math.PI))


  def toCurry(f : (Int,Int) => Int) : (Int => Int => Int) =
    {
      x => y => f(x,y)
    }
  def fromCurry(f : (Int =>  Int => Int)): (Int,Int) => Int =
  {
    (x,y) => f(x)(y)
  }

  def compose[A,B,T](f: A => B, g : T => A ):T => B ={
    x => f(g(x))
  }

  def andThen[A,B,C](f: A => B,g : B => C): A => C =
    x => g(f(x))

  val superAdder2 : Int => Int => Int = toCurry((x,y) => x+y)
  def add4 = superAdder2(4)
  println(add4(10))
  val simpleAdder = fromCurry(superAdder)
  println(simpleAdder(4,10))

  def add2 = ( x: Int ) => x +2
  def times3 = (x: Int) => x * 3
  val composed = compose(add2,times3)
  val ordered = andThen(add2,times3)
  println(composed(4))
  println(ordered(4))

}
