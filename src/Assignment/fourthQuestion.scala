package Assignment
import scala.collection.mutable.Map

object fourthQuestion extends App{
  val bufferReader = io.Source.fromFile("C:\\Users\\s.tiwari\\IdeaProjects\\untitled\\src\\Assignment\\harvest.csv","UTF-8")


  val result = for {
    line <- bufferReader.getLines()
  }yield  line.split(",").map(_.trim).toList

  val data = result.toList

  /*
  Who is your best gatherer in terms of the amounts of fruits gathered every month?
   */
  // Read Data
  val gatherer = Seq("John","Nick","Rick","Dick","Jake","Paul","Jason","Peter")
  val fruits = Seq("apples","oranges","strawberries","plums","pears","tomatoes")
  val month = Seq("01","02","03","04","05","06","07","08","09","10","11","12")

  def sum(data : List[List[String]],Name : String,Month : String):Double =
    {
      val filter = data.filter(x => x(0) == Name).filter(x => x(1).matches(s"2020-$Month-.*"))
      filter.map(x => x(3).toDouble).sum
    }

  def max1(Gatherer : Seq[String], max: Double,res : String): String = {
    if(Gatherer.isEmpty)
      res
    else
      {
        val curr = sum(data,Gatherer.head,"02")
        if(curr > max)
        max1(Gatherer.tail,curr,Gatherer.head)
        else
          max1(Gatherer.tail,max,res)
      }
  }

  println(max1(gatherer,0.00,"01"))

  /*
   Are there employees that are better at gathering some specific fruit?
   */

  def filter_based(data : List[List[String]] ,Name: String,Fruits: String):List[String] =
    {
      val filter = data.filter(x => x(0) == Name).filter(x => x(2).equals(Fruits))
      val res = filter.map(x => x(3).toDouble).sum
      List(Name,Fruits,res.toString)
    }

  //filter_based(data,"John","apples","01")

  val bestGathereSpecificFruits = for{
    g_name <- gatherer
    f <- fruits
  } yield  filter_based(data,g_name,f)   // this give's me sum of specific fruits for particular person.
  println(bestGathereSpecificFruits)
 // bestGathereSpecificFruits.foreach(println)
  def Question1Part2(f : String):Seq[List[String]] = {
    val curr_DB = bestGathereSpecificFruits.filter(x => x(1) == f)
    curr_DB.filter(x => x(2).toDouble == curr_DB.map(x => x(2).toDouble).max)
  }
  val res = for {
    f <- fruits
  } yield Question1Part2(f)
  res.foreach(println)

}
