package lectures.part3fp

import scala.util.Random

object Sequences extends App{

val aSeq = Seq(2,3,1)
  println(aSeq)
  println(aSeq.reverse)
  println(aSeq.apply(2))
  println(aSeq++Seq(4,5,6))
  println(aSeq.sorted)
  val aRange : Seq[Int] = 1 to 10
  aRange.foreach(println)
  (1 to 10).foreach(x => print("Hello"+" "))
  // lists
  val aList = List(1,2,3)
  val prepended = 42 +: aList :+ 89
  val apples5 = List.fill(5)("apple") // it's an curried function which take first parameter which as limit and add the second parameter that many to list.
  println(prepended)
  println(apples5)
  println(apples5.mkString(" ")) // it convert string by adding the given parameter in between the values.

  val numbers = Array(1,2,3,4)
  val threeElements = Array.ofDim[Int](3) // allocated memory for this variable with size of 3 * Int
  threeElements.foreach(println)

  println(numbers)
  numbers(2) = 0 // syntax sugar for number.update(2,0)
  println(numbers.mkString)
  val numberSeq: Seq[Int] = numbers
  println(numberSeq) // ArraySeq
  println(numberSeq.sum +" this is result")

  // vector
  val vector : Vector[Int] = Vector(1,2,3)
  println(vector)

  val maxRuns = 1000
  val maxCapacity = 1000000
  def getWriteTime(collection : Seq[Int]) :Double = {
    val r = new Random
    val time= for{ // time return the IndexedSequence
      it <- 1 to maxRuns
    }yield
      {
        val currentTime = System.nanoTime()
        collection.updated(r.nextInt(maxCapacity),r.nextInt())
        System.nanoTime() - currentTime
      }
      time.sum * 1.0 / maxRuns // times is IndexedSequence and contains method sum init.
  }

  val numbersLists = (1 to maxCapacity).toList
  val numbersVector = (1 to  maxCapacity).toVector

  // advantage :  Keeps reference to tail
  //disadvantage : updating an element in the middle takes long time
  println(getWriteTime(numbersLists))

  // advantage : depth of the tree is small
  // needs to replace an entire 32 - elements chunk.
  println(getWriteTime(numbersVector))

}
