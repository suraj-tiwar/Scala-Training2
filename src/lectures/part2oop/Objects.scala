package lectures.part2oop

object Objects {
  object person {
    // class level Functinality
    val N_EYES = 2

    def canFly: Boolean = false
    def apply(Mother : person, Father : person):person = new person("Bobbie")
  }
  class person(val name:String)
  {
// instance level Functionality
  }
def main(args:Array[String]):Unit =
{
  println (person.N_EYES)
  println (person.canFly)
  val mary = new person ("Mary")
  val tom = new person ("tom")

  println (mary == tom)
  val bobbie = person (mary, tom)
  println (bobbie.name)
}


  // Scala object is SINGLETON INSTANCE

}
