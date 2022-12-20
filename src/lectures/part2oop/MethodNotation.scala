package lectures.part2oop

import scala.language.postfixOps

object MethodNotation extends App {

  class Person(val name:String , favoriteMovie:String,val age :Int = 0) {
    def likes(Movies:String): Boolean = Movies == favoriteMovie

    def +(person:Person): String = s"${this.name} is hanging out with ${person.name}"

    def +(title:String):Person = new Person(s"$name($title)",favoriteMovie)

    def hangout(person:Person): String = s"${this.name} is hanging out with ${person.name}"

    def unary_! : String = "What the heck!"

    def isAlive: String ="How are you"

    def apply() : String = s"Hi name is $name i like $favoriteMovie"

    def Name: String = s"$name"

    def unary_+ : Person = new Person(this.name,this.favoriteMovie,this.age+1)

    def apply(num : Int):String = s"$name watched Inception $num times"

    def learns(aString :String):String = s"$name learns $aString"

    def learnsScala:String = learns("Scala")

  }
  val mary = new Person("mary","Inception")

  println(mary.likes("Inception"))

  println(mary likes "Inception")

  // infix notation = operator notation(syntactic sugar)
  val tom = new Person("tom","Fight Club")

  println(mary + tom)

  println(mary.+(tom))

  println(mary hangout tom)

  println(1+1)

  println(1.+(1))

  // All operators are Methods
  // Akka actors have ! ?
  // operators are methods in  scale

  // prefix works with - + ~ !
  val x = -2 // Equivalent with 1.unary_-
  val y = 1.unary_-
  // unary prefix
  println(!mary)
  println(mary.unary_!)


  // postfix Expression is Used when we don't need to
  println(mary.isAlive)
  println(mary isAlive)

  //apply
  println(mary.apply())
  println(mary())
  // whenever the apply object is called as method is look for the apply method in the object class
/*
  1.overLoad the +operator with string as parameter
  return new object as name = Mary( the Rockstar") favoriteMovie = same as previous

  2. Add the age attribute into the method
  then Add unary+ to the object to get new person with new age incremented by 1
  "+mary = mary with age incremented.

 */
  println((mary+"The Rockstar").Name)
  println(mary.name)

  println(mary.age)
  println((+(+mary)).age)

  println(mary learnsScala)
  println(mary(4))

  println( -1)




}
