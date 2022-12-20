package lectures.part2oop

import sun.plugin.ClassLoaderInfo

import scala.runtime.Nothing$

object Generics extends App{
class MyList[+A]
  {
    // use the type A
    def add[B >: A] (elements: B) : MyList[B] = ???
    /*

     */
  }
  val ListOfInteger = new MyList[Int]
  val ListOfString = new MyList[String]

  class MyMap[key,Value] // we can use the multiple generic type parameter.
  // generic method.

  object MyList // can not be type parameterize
  {
    def empty[A] : MyList[A] = ???
  }
  val emptyListOfInteger = MyList.empty[Int]

  // variance Problem
  class Animal
  class Cats extends  Animal
  class Dogs extends  Animal
  // yes Does List[Cat] Extends List[Animal] = COVARIANCE
  class CovariantList[+A]
  val animal : Animal = new Cats
  val animalList : CovariantList[Animal] = new CovariantList[Cats]
  // animalList.add(Dogs)

  // no  = Invariance
  class InvariantList[A]
  val invariantList : InvariantList[Animal] = new InvariantList[Animal]

  // Hell,No Contravariance
  class ContravariantList[-A]
  val contravariantList : ContravariantList[Cats] = new ContravariantList[Animal]

  class Cage[A <: Animal](animal : A)
    val cage = new Cage(new Dogs)
  class car


println("hee")


}
