package lectures.part1basics

object DefaultArgs extends App{

  def trFact(n: Int, acc: Int = 1): Int= {
    if(n <= 1) acc
    else
      trFact(n-1,n*acc)
  }
  println(trFact(10))

 def nameperson(name : String = "superman",age : Int = 25): Unit= {
   println("My name is "+name+" and Guess what is my age"+age)
 }
  nameperson(age = 2)


}
