package lectures.part3fp

object MapFlatmapFilterFor extends App{
  val list = List(1,2,3)
  println(list.head)
  println(list.tail)
  println(list.map((x:Int) => x +1))
  println(list.map(_-1))
  // filter
  println(list.filter((x:Int) => x % 2 == 0))

  // flatMap
  val toPair = (x : Int) => List(x,x+1)
  println(list.flatMap(toPair))

  val number = List(1,2,3,4)
  val chars = List('a','b','c','d')
  val colors = List("Black","White")
  val combinators = number.flatMap(n => chars.flatMap(ch => colors.map(str => n+""+ch+"-"+str)))
  println(combinators)

  list.foreach(println)
  // for comprehensions
  val forCombinators = for {
    n <- number if n % 2 == 0  // this is iterator
    c <- chars // c is iterator of list of chars
    color <- colors // color is iterator of Colors
  } yield n+""+c+"-"+color
  println(forCombinators)


}
