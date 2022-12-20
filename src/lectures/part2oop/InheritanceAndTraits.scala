package lectures.part2oop

object InheritanceAndTraits extends App {

   sealed class Animal{
    val Creaturetype: String = "Wild"
     def eat = println("nummm")
  }
  class Cat extends Animal{
    def crunch(): Unit = {
      eat
      println("Cruch again")
    }
  }
  val cat = new Cat()
  cat.crunch()

  class Person(val name:String , val age:Int = 0)
  {
    def this()= this("Suraj",0)
  }
  class Adult(name:String,age:Int,IdCard: String) extends Person(name,age)// this calls for the super class constructor.
  {
  }

  val suraj = new Adult("Akash",65,"SID 45")
  println(suraj.age)

  class Dog( override val Creaturetype : String)extends Animal
  {

  override def eat() =
    { super.eat
      println("Bruch,Bruch")
    }
  }

  val Dog = new Dog("Domestic")
  Dog.eat
  println(Dog.Creaturetype)

  trait A{
    val x = 1
  }
  trait B extends A{
    override val x: Int = 2
  }
  trait C extends  A{
    override val x: Int = 3
  }
  trait E extends A{
    override val x: Int =  4
  }
  class D extends C with B with E{
    println(x)
  }
  new D()





}
