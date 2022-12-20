package lectures.part2oop

object AnonymousClasses extends App{
    abstract class Animal
  {
    def eat: Unit
  }
  val funnyAnimal : Animal = new Animal {
    override def eat: Unit = println("ahahahahahaha")}
  println(funnyAnimal.getClass)
/*
Equivalent
  class AnonymousClasses$$anon$1 extends Animal
  {
    override def eat: Unit = println("ahahahahah")
  }
  */

  class person(name :String)
  {
    def sayHi(name : String): String = {
      s"Hi  $name"
    }
  }
  val jim =  new person("jim")
  {
    override def sayHi(name: String): String = " Hii this is jim"
  }
}
