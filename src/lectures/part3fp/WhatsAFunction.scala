package lectures.part3fp

object WhatsAFunction extends App{

val doubler =  new MyFunction[Int,Int] {
  override def apply(element: Int): Int = element * 2
}
  println(doubler(2)) // doubler act's like function
val stringtoIntCoverter = new Function[String,Int] {
  override def apply(v1: String): Int = v1.toInt
}
  println(stringtoIntCoverter("43")+42)

  val adder : ((Int,Int) => Int) = new Function2[Int,Int,Int] { // scala has the traits of Functions of 22 parameters
    override def apply(v1:Int,v2 : Int):Int = v1+v2
  }
  println(adder(43,42))


  val StringConcat: (String,String) => String = new Function2[String,String,String] {
    override def apply(v1: String, v2: String): String = v1+v2
  }
  println(StringConcat("Suraj ","Tiwari"))

  val superAdder: Int => Int => Int = new Function1[Int,Function1[Int,Int]] {
    override def apply(v1: Int): Function1[Int,Int] = new Function1[Int,Int] {
      override def apply(v2: Int): Int = v1+v2
    }
  }
  // superAdder method apply method is returning the function.

  val newFuction = superAdder(43)
  println(newFuction(42))
  println(superAdder(35)(36))

}
trait MyFunction[A,B]
{
  def apply(element: A):B
}
