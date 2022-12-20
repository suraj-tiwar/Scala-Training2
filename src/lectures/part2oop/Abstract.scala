package lectures.part2oop

object Abstract extends App{

  abstract class Animal
  {
    val CreatureType : String = "simple"
    def eat : Unit
  }
  class Dog extends Animal
  {
    override val CreatureType : String = " Canine"
    override def eat: Unit = println("crunch, crunch")
  }

  trait carnivore
  {
    def eat(animal : Animal) : Unit = println(" hello")

  }

  class crocodile extends Animal with carnivore
  {
    override val CreatureType : String = "Croc"
    def eat: Unit = println("crack_ crak")
    override def eat(animal: Animal) : Unit = println(s"i'm Croc and i'm eating ${animal.CreatureType}")
  }

  val dog = new Dog
  val croc = new crocodile
  croc.eat
  croc.eat(dog)
  println(croc.getClass)
// Traits vs abstract classes
  // 1. traits do not have constructor parameter
  // 2. multiple traits may be inherited by class
  // 3. traits are behaviour abstract class ="thing"




}
