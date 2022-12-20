package lectures.part1basics

object StringOps extends App {
  val str: String = "Hello, I am learning Scala"

  println(str.charAt(3))

  val new_str: String = str.substring(6)
  println(new_str)
  print(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ", "-"))

  println(str.toLowerCase())
  println(str.toUpperCase())
  println(str.length())

  val aNumberString = "2"
  val name: String = "Suraj";
  val percent : Float = 2.6f
  val age : Int = 45;
  println( s"my name is $name and i am $age years old")
  println(f"score is $percent%2.5f after doing this operation")
  println(raw"the new \n is not escaped")
  val esp = "the new \n is escaped"
  println(esp);

}
