package lectures.part4pm

import Exercise.{Cons, Empty, MyList}
import lectures.part2oop.Generics.MyList

import scala.util.matching.Regex.Match

object AllThePattern extends App{
  val x : Any = "Scala"
  val constants = x match {
    case 1 => " a number"
    case "Scala" => "The Scala"
    case true => "The Truth"
    case AllThePattern => " A singleton object"
  }
//
//  // 2 - match anything
//  //2.1 Wildcard
//  val matchAnything = x match {
//    case _ =>
//  }
//
//  // 2.2
//  val matchAVariable = x match{
//    case something => s"I've found $something"
//  }
//
//  // 3 -tuples
//  val aTuple = (1,2)
//
//  val matchATuple = aTuple match {
//    case (1,1) =>
//    case (something,2) =>
//  }
//
//  val nestedTuple = (1,(2,3))
//  val matchANestedTuple = nestedTuple match {
//    case (_,(2, v)) =>
//  }
//
//  // 4 - case classes - constructor pattern
//  val aList : MyList[Int] = Cons(1, Cons(2,Empty))
//
//  val matchAList = aList match {
//    case Empty =>
//    case Cons(head,Cons(subhead,subtail)) =>
//  }
//
//
//  // 5 - list pattern
//
//  val aStandardList = List(1,2,3,42)
//  val matchAList1 = aStandardList match {
//    case List(1,_,_,_) =>  // extractor - advanced
//    case List(1,_*) =>     // list of arbitrary length - advanced
//    case 1 :: List(_) =>   // infix pattern
//    case List(1,2,3) :+ 42 => // infix pattern
//  }
//
//  val unKnown : Any = 2
//  val unKnowMatch = unKnown match {
//    case list : List[Int] => // explicit type specifier
//    case _ =>
//  }
//
//  // name binding
//  val nameBindingMatch = aList match {
//    case nonEmptyList @ Cons(_, _) => // name binding => use the name later(here)
//    case Cons(1, rest @ Cons(2, _)) => // name binding inside nested pattern
//  }
//
//  val multipattern = aList match {
//    case Empty | Cons(_, _) =>
//  }
//
//  val secondElementsSpecial = aList match {
//    case Cons(_, Cons(specialElement, _)) if specialElement  == 0 =>
//  }
//  val number = List(1,2,3)
//  val numbersMatch = number match {
//    case listOfString : List[String] => " A List of String"
//    case listOfNumber : List[Int]  => " A list of Int"
//    case _ =>""
//  }
//  println(numbersMatch)

}
