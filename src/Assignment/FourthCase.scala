package Assignment
import java.time.LocalDate
object FourthCase extends App{
  /*
      Read CSV file
   */
  val bufferSource = io.Source.fromFile("C:\\Users\\s.tiwari\\IdeaProjects\\untitled\\src\\Assignment\\harvest.csv", "UTF-8")
  val bufferSource1 = io.Source.fromFile("C:\\Users\\s.tiwari\\IdeaProjects\\untitled\\src\\Assignment\\prices.csv", "UTF-8")
  val iteratorOfPrice = for {
    line <- bufferSource1.getLines().drop(1)
  } yield line.split(",").map(x => x.trim).toList
  val mapOfPrice = iteratorOfPrice.toList.groupMapReduce(l => (l(0),l(1)))(l => l(2).toDouble)(((acc,curr) => acc + curr)) // creating Map of (Fruits,Date) -> Price from price file
  bufferSource1.close()
  //mapOfPrice.foreach(println)
  case class Harvest(
                      name: String,
                      fruits: String,
                      quantity: Double,
                      date: LocalDate,
                      earning: Double
                    )
  def harvestObjectCreation(line : String) = {
    val spiltValues = line.split(",").map(_.trim)
    val name = spiltValues(0)
    val date = spiltValues(1)
    val fruits = spiltValues(2)
    val quantity = spiltValues(3).toDouble
    val earning = if(mapOfPrice.contains((fruits,date))) mapOfPrice(fruits,date) * quantity else 0.0
    val new_date = date.split("-")
    Harvest(name,fruits,quantity,LocalDate.of(new_date(0).toInt,new_date(1).toInt,new_date(2).toInt),earning)
  } // Function for Harvest class object creation
  val iteratorOfHarvest = for {  //
    line <- bufferSource.getLines().drop(1)
  } yield harvestObjectCreation(line) // Creating Iterator of harvest object
  val listOfHarvest = iteratorOfHarvest.toList // converting Iterator to List

  /*
  Who is your best gatherer in terms of the amounts of fruits gathered every month? Are there employees that are better at gathering some specific fruit?
   */

  val res = listOfHarvest.groupBy(h => h.date.getMonth) // Creating Map with Month value.
  val monthKeySet = res.keySet
  val value = for {
    key <- monthKeySet
  } yield Tuple2(key,fun(res(key)).maxBy(f => f._2)) // Getting max Gatherer based on month in keyset.
  def fun(list : List[Harvest]) = {
     val tempMap = list.groupMapReduce(h => h.name)(h => h.quantity)((acc,curr) => acc + curr)
    tempMap
  } // Give's the HashMap with key as Name and value equals to sum of quantity.
  println(value)
  val groupByFruits = listOfHarvest.groupBy(h => h.fruits)
  val fruitsKeySet = groupByFruits.keySet
  val part2 =
    for {
      key <- fruitsKeySet
    } yield Tuple2(key,fun(groupByFruits(key)).maxBy(f => f._2))
    println(part2) // Give Tuple of Month , ( Gatherer,Amount)

  println(listOfHarvest.groupMapReduce(f => f.fruits)(f => f.earning)(_+_).maxBy(x => x._2))   // best Earning Fruits overall
  println(listOfHarvest.groupMapReduce(f => f.fruits)(f => f.earning)(_+_).minBy(x => x._2)) //least Earning Fruits overall

  // per month basis
 def func2( list : List[Harvest]) =
    {
      val tempMap = list.groupMapReduce(h => h.fruits)(h => h.earning)((acc, curr) => acc + curr)
      tempMap
    } // Give's the HashMap with key as fruits and value equals to sum of Earning.

  val BestEarningFruitsMonthly = for {
    key <- monthKeySet
  } yield Tuple2(key, func2(res(key)).maxBy(f => f._2))
  println(BestEarningFruitsMonthly) // This Generate best Fruits Monthly
  println(listOfHarvest.groupMapReduce(f => f.name)(f => f.earning)(_+_).maxBy(x => x._2))// best Gatherer
  println(listOfHarvest.groupMapReduce(f => f.name)(f => f.earning)(_+_).minBy(x => x._2))// worst Gatherer
  val lastAnswer = for
    {
      key <- monthKeySet
    } yield Tuple2(key,fun2(res(key)).maxBy(f => f._2))
  println(lastAnswer)

  def fun2(list: List[Harvest]) = {
    val tempMap = list.groupMapReduce(h => h.name)(h => h.earning)((acc, curr) => acc + curr)
    tempMap
  }

}

