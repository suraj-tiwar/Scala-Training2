package Playground

object ScalaPlayground  {
  def main(args: Array[String]): Unit = {
    println("Hello, Scalla")
    object person {
      val N_EYES = 2

      def canFly: Boolean = false
    }
    println(person.N_EYES)
    println(person.canFly)


  }

}
