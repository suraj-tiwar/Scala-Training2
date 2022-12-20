package Exercise

import lectures.part2oop.Generics.MyList

import scala.runtime.Nothing$

/// Generic type Implementaion of the Queue.
abstract class MyList[+A] {
  def head : A             // Abstract class defining structure of the object with or without default implementation
  def tail: MyList[A]
  def isEmpty():Boolean
  def add [B >: A] (element : B):MyList[B]  // solution for when adding the Super Class elements in the Subclass then return just object of the super class.
  def printElement():String
  override def toString: String = "["+printElement()+"]"  //toString Equal hashCode present in AnyRef Class.

  def map[B](transformer : A => B):MyList[B]
  //def flatMap[B](transformer:A =>  MyList[B]) : MyList[B]
  def filter(predicate: A => Boolean):MyList[A]
  def foreach(print : A => Unit):Unit
  def sort(compare: (A,A) => Int): MyList[A]

  def zipWith[B,C](anotherList:MyList[B],func : (A,B) => C):MyList[C]
  def fold[B](start:B)(operator : (B,A) => B): B

}

case object Empty extends MyList[Nothing]  // Last Empty Node signature
{
  def head: Nothing= throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException()
  def isEmpty(): Boolean = true
  def add[B >: Nothing](element: B): MyList[B] = new Cons(element,Empty)
  override def printElement(): String = ""

  def map[B](transformer: Nothing =>  B): MyList[B] = Empty

 // def flatMap[B](transformer:Nothing =>  MyList[B]): MyList[B] = Empty

  def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty

  override def foreach(print: Nothing => Unit): Unit = ()
  def sort(compare : (Nothing,Nothing)  => Int) = Empty


  def zipWith[B,C](anotherList:MyList[B],func : (Nothing,B) => C):MyList[C] =
    {
      if (!anotherList.isEmpty) throw new RuntimeException("Lists do not have same length")
      else
        Empty
    }

  def fold[B] (Start : B)(operator: (B,Nothing) => B):B = Start


}

case class Cons[+A] (i : A, t : MyList[A]) extends MyList[A]  // object class
{
  def head : A = i

  def tail: MyList[A]  = t

  def isEmpty() : Boolean = false

  def add[B >: A] (element: B): MyList[B] = { // recursive solution for adding element to the end of the list.
    if( tail == Empty)
      new Cons(element,Empty)
    else
      this.tail.add(element)
  }
  def printElement(): String= { // recursive solution for Printing element
  if(tail == Empty) ""+i
  else
    i+" "+tail.printElement()
  }
  def filter(predicate: A => Boolean):MyList[A] =
  {
      if(predicate.apply(i)) new Cons(i,t.filter(predicate))
      else
        t.filter(predicate)
  }

  def map[B](transformer :  A => B):MyList[B] =
    {
      new Cons(transformer(i),t.map(transformer))
    }

  override def foreach(print: A => Unit): Unit = {
    print(i)
    tail.foreach(print)
  }
  def sort(compare : (A,A) => Int):MyList[A] =
    {
      def insert(x : A,sortedList: MyList[A]):MyList[A]=
        {
          if(sortedList.isEmpty())new Cons(x,Empty)
          else if(compare(x,sortedList.head) <= 0) new Cons(x,sortedList)
          else
            new Cons(sortedList.head,insert(x,sortedList.tail))
        }
      val sortedtail = tail.sort(compare)
      insert(i,sortedtail)
    }
  def zipWith[B,C](anotherList:MyList[B],func : (A,B) => C):MyList[C] =
    {
      if(anotherList.isEmpty()) throw new RuntimeException("another List shorter")
      else
        new Cons(func(this.head,anotherList.head),tail.zipWith(anotherList.tail,func))
    }

  def fold[B](Start : B)(operator : (B,A) => B): B =
    {
      val newStart = operator(Start,this.head)
      t.fold(newStart)(operator)
    }


}


object ListTest extends App{
  val ListofInteger = new Cons(1,new Cons(2,new Cons(3,Empty)))
  val CloneListofInteger = new Cons(1,new Cons(2,new Cons(3,Empty)))
  val ListOfString = new Cons("Suraj",new Cons("Tiwari",new Cons("Sarveshwar",Empty)))
  val ListOfBoolean  = new Cons(true,new Cons(false, new Cons(true,Empty)))
  println(ListofInteger.map(elem => elem * 2).toString)

val predicate : Int => Boolean = x => x % 2 == 0
  println(ListofInteger.filter(elem => elem % 2 == 0).toString)

  println()
  println(List(1,2,3).map(x => x*2+1))
  println(List("ABc","BCD").map(x => x.length))
/// HOF
  println(ListofInteger == CloneListofInteger)
  ListofInteger.foreach(x => println(x))
  println(ListofInteger.sort((x:Int,y:Int) => y-x).toString)
  println((ListofInteger.zipWith(ListOfString,(x:Int,y:String) => x+" "+y)).toString)

  println(ListofInteger.fold(0)((x,y) => x+y))

}





