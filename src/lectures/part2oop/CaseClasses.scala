package lectures.part2oop

object CaseClasses extends App{
  case class Person(name :String, age : Int)
  val jim = new Person("Jim",45)
  println(jim)
  val jim2 = new Person("Jim",45)
  println(jim == jim2) // Equal ( check fo value rather address of the object)
  val jim3 = jim.copy(age = 34)// Copy Method
  println(jim3)
  println(jim)
  // companion objects
  val thePerson = Person
  val mary = Person("Mary",23)

  case object UnitedKingdon
  {
    def name : String = " The Uk and GB and NI"
  }

}
