package lectures.part1basics

object CBNvsCBV extends App{
  def callByval(x:Long):Unit ={
  println(x)
  println(x)
  }
  def callByName(x: => Long):Unit = {  /// => this is symbol is used to called by name (Reference)  it's give base address of the val then whenever used it fetch it
    println(x)
    println(x)
  }
  callByval(System.nanoTime())
  callByName(System.nanoTime())


  def infinite():Int = 1+infinite()
  def isExample(i:Int,k: => Int):Unit = println(i)

  isExample(infinite(),10)
}
