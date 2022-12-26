package lectures.part4pm

object PatternEveryWhere extends App{
// big data
  try
    {

    } catch {
    case e: RuntimeException => "Runtime"
    case npe: NullPointerException => "npe"
    case _ => "Something else"
  }
  // catches are actually MATCHES

  val list =List(1,2,3,4)
  val evenOnes = for{
    x <- list if x % 2 == 0
  } yield 10 * x
  // generators are also based on PATTERN MATCHING
  val tuples = List((1,2),(3,4))
  val filterTuples = for {
    (first,second) <- tuples
  }yield first * second

  val tuple = (1,2,3)
  val (a, b,c) = tuple

  val head :: tail = list
  println(head)
  println(tail)

  // partial function

  val mappedList = list.map{
    case v if v % 2 == 0 => v + " is even"
    case 1 => "the one"
    case _ => "Something else"
  }




  println(mappedList)

}
