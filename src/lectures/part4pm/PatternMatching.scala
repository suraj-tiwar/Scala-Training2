package lectures.part4pm

import scala.util.Random

object PatternMatching extends App{
  val random = new Random
  val x = random.nextInt(10)

  val description = x match {  // look's like a switch
    case 1 => "The One"
    case 2 => " Double or nothing"
    case 3 => "Something else"
    case _ => 42 // _= WILDCARD
  }
  println(x)
  println(description)

  // 1. Decompose values
  // 2. What if no cases match ? Throws Error MatchError
  // 3. type of the PM expression? unified type of all the types in all the cases
  // 4. PM works really well with case classes.

  case class Person(name : String, age :Int)
  val bob = Person("Bob",20)

  val greeting = bob match //  if bob is person
    {
    case Person(n,a) if a <21 => s"Hi, my name is $n and  I am $a years old and I can't drink in US" // it's extract the values from bob
    case Person(n,a) => s"Hi, my name is $n and  I am $a years old" // it's extract the values from bob
    case _ => "I don't Know who I am"
  }
  println(greeting)


  sealed class Animal
  case class Dog(Breed : String) extends Animal
  case class Parrot(greeting : String) extends Animal

  val animal : Animal = Dog("Terra Nova")
  animal match {
    case Dog(someBreed) => println(s"Matched a dog of the $someBreed breed")
  }

  val isEven = x match {
    case n if n % 2 == 0 => true
    case _ => false
  }

  val isEvenCond =  if( x % 2 == 0) true else false
  val isEvenNormal = x %2  == 0


  trait Expr
  case class Number(n : Int) extends  Expr
  case class Sum(e1: Expr , e2 : Expr) extends  Expr
  case class Prod(e1: Expr, e2: Expr) extends Expr


  def show(e: Expr) :String = e match {
    case Number(n) => s"$n"  // check for the expression is number if yes print
    case Sum(e1 : Expr,e2 : Expr) => show(e1)+"+"+show(e2) // recursive call to generate the Number expression.
    case Prod(e1,e2) => {
      def maybeShowParentheses(exp : Expr) =  exp match {
        case Prod(_,_) => show(exp)
        case Number(_) => show(exp)
        case _ => "("+ show(exp) +")"
      }
      maybeShowParentheses(e1)+" * "+ maybeShowParentheses(e2)  // to add the parentheses to the product
    }
  }

  println(show(Sum(Number(2),Number(3))))  // 2+3

  println(show(Sum(Sum(Number(2),Number(3)),Number(4)))) // 2+3+4

  println(show(Prod(Sum(Number(2),Number(3)),Number(4)))) // (2+3) * 4


}
