package lectures.part3fp

object AnonymousFunctions extends App{
  val doubler = new Function[Int,Int] {
    override def apply(v1: Int): Int = v1*2
  }
  val doubler1:Int => Int = x => x * 2
  println(doubler)
  println(doubler1)

  // multiple parameters
  val adder:(Int,Int)=>Int = (a : Int,b:Int) => a+b
  //////////return type\\\\\\ ( Aurgument ) \\\\ implementation.
  val justDoSomething = () => 3
  println(justDoSomething) //Function itself
  println(justDoSomething())// call

  val superAdd = (x:Int) => ( y :Int) => x + y
  println(superAdd(3)(4))

}
