package Assignment

object Rough extends App{

  val x = (1 to 5).toArray
  println(x.toList)
  x.indices.map(i => x(i) =  x(i) * 5)
  println(x.toList)



}
