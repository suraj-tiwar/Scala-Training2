package lectures.part1basics

object Function extends App{
  def aFunction(a:String, b: Int)=
    {
      a+" "+b;
    }
    println(aFunction("Suraj",43))

  def aParameterlessFunctions(): Int = 42;
  println(aParameterlessFunctions());
  println(aParameterlessFunctions)

  def aReapatedFunction(aString : String, n : Int) : String =  {
  if(n == 1) aString
  else aString+aReapatedFunction(aString,n-1);
  }
  println(aReapatedFunction("hello ",4))
    def aFunctionWithsideEffects(aString : String): Unit = println(aString)

  def aBigFunction(n:Int): Int = {
    def aSmallerFunction(a :Int,b : Int): Int=  a + b

    def fibonaci(a :Int,b:Int,n:Int):Int = {
      if(n == 0) 10000
      else
      a+fibonaci(b,aSmallerFunction(a, b),n-1)
    }
    fibonaci(0,1,n)

  }

  println(aBigFunction(10))

  def greeting(name :String,age: Int): String ={
    "Hi, my name is "+name+" and I am "+age+" years old"
  }

  println(greeting("Suraj",22))

  def fact(n : Int) :Int =
    if(n == 1)
      1
    else
      n*fact(n-1)
  println(fact(5))

  def fibo(n :Int): Int =
    if( n == 1 || n == 2)
      1
    else
      fibo(n-1)+fibo(n-2)
println(fibo(4))

  def prime(n : Int): Boolean = {
    def check(n: Int,i :Int)={
    if(n % i == 0)
    true
    else
    false
    }
   var i: Int = 2
    def iteration(): Boolean = {
      if( n  == i)
        true
      else if( check(n ,i))
        false
      else {
        i += 1
        iteration()
       }

    }
    iteration()
  }

  println(prime(6))


  def isPrime(n: Int): Boolean = {
    def isPrimetime(t:Int) : Boolean =
      if(t <= 1) true
      else  n % t != 0 && isPrimetime(t-1)
      isPrimetime(n/2)
  }
  println(isPrime(7))

}