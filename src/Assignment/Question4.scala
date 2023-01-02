package Assignment

object Question4 extends App{
  val bufferReader = io.Source.fromFile("C:\\Users\\s.tiwari\\IdeaProjects\\untitled\\src\\Assignment\\harvest.csv", "UTF-8")
  val bufferReader2 = io.Source.fromFile("C:\\Users\\s.tiwari\\IdeaProjects\\untitled\\src\\Assignment\\prices.csv", "UTF-8")


  val result = for {
    line <- bufferReader.getLines()
  } yield line.split(",").map(_.trim).toList

  val result2 = for {
    line <- bufferReader2.getLines()
  } yield line.split(",").map(_.trim).toList

  /// Who is your best gatherer in terms of the amounts of fruits gathered every month ?

  val gatherer = List("John", "Nick", "Rick", "Dick", "Jake", "Paul", "Jason", "Peter")
  val fruits = List("apples", "oranges", "strawberries", "plums", "pears", "tomatoes")
  val month = List("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12")
  val data = result.toList
  //val ans1 = data.filter(x => x(0) == "John").filter(x => x(1).matches(s"2020-01-.*")).map(x => x(3).toDouble).foldLeft(0.0)(_+_)
 // println(ans1)
  val res = for {
    gather <- gatherer
  } yield Tuple2(gather,data.filter(x => x(0) == gather).map(x => x(3).toDouble).foldLeft(0.0)(_+_))
  println(res)
  println(" Best gatherer Over all year")
  println(res.maxBy(x => x._2))
  println("Worst gatherer over all year")
  println(res.minBy(x => x._2))

  def bestGathererOfMonth(Month  : String):Tuple2[String,Double] = {

    val res = for {
      gather <- gatherer
    } yield Tuple2(gather, data.filter(x => x(0) == gather).filter(x => x(1).matches(s"2020-$Month-.*")).map(x => x(3).toDouble).foldLeft(0.0)(_ + _))

    res.maxBy((x => x._2))
  }
  val bestGatherer = for {
    m <- month
  } yield bestGathererOfMonth(m)
  println("Best Gatherer based on the month")
  println(bestGatherer)
/// List(Rick, Jake, Dick, Jake, Jason, Dick, Peter, Dick, Jake, Jason, John, Jason)
  //new_data.foreach(println)

  //println(data.groupBy(x => (x(2),x(0)))("pears","Nick").map(x => x(3).toDouble).foldLeft(0.0)(_+_))
  val map = data.groupBy(x => (x(2),x(0)))
  def bestFruits(Map :  Map[(String, String), List[List[String]]],Fruits : String):Tuple2[String,Double] = {
    val res = for {
      gather <- gatherer
    }yield Tuple2(gather,Map(Fruits,gather).map(x => x(3).toDouble).foldLeft(0.0)(_+_))
    //res.foreach(println)
    res.maxBy((x => x._2))
  }
  val second = for {
    f <- fruits
  } yield bestFruits(map,f)
  println("Best Gatherer based for fruits")
  second.foreach(println)


  ///What is your best-earning fruit (overall and by month)? Which is your least profitable fruit (again, overall and by month)?
  val data2 = result2.toList
  val dateKeyset = data2.map(x => x(1)).filter(x => x != "date")
  //dateKeyset.foreach(println)
  val byDateEarning = for {
    d <- dateKeyset
    f <- fruits
  }yield List(d,f,earning(d,f))

//  //byDateEarning.foreach(println)
//  println(data.filter(x => x(1) == "2020-01-02").filter(x => x(2) == "apples").map(x => x(3).toDouble).foldLeft(0.0)(_+_))
//  println(data2.filter(x => x(0) == "apples").filter(x => x(1) == "2020-01-02").map(x => x(2).toDouble).head)

  def earning(Date : String,f : String): String =
     {
        val sum = data.filter(x => x(1) == Date).filter(x => x(2)== f).map(x => x(3).toDouble).foldLeft(0.0)(_+_)
       val price = data2.filter(x => x(1) == Date).filter(x => x(0) == f).map(x => x(2).toDouble).head
       (sum * price).toString
     }

  val fruitsEarningOverall =  for(
    f <- fruits
  ) yield Tuple2(f,byDateEarning.filter(x => x(1) == f).map(x => x(2).toDouble).foldLeft(0.0)(_+_))
  println("Best Earning fruits")
  println(fruitsEarningOverall.maxBy(x => x._2.toDouble))
  println("least Earning fruits")
  println(fruitsEarningOverall.minBy(x => x._2.toDouble))

  val fruitsEarningMonth = for {
    m <- month
  } yield Tuple2(m,EarningFruitsMont(m))
  println( " Month, Fruits max contribution , Fruits min contribution")
  fruitsEarningMonth.foreach(println)
  def EarningFruitsMont(m: String): List[(String,Double)] =
    {
      val res = for {
        f <- fruits
      } yield Tuple2(f,byDateEarning.filter(x => x(1) == f).filter(x => x(0).matches(s"2020-$m-.*")).map(x => x(2).toDouble).foldLeft(0.0)(_+_))
      List(res.maxBy(x => x._2.toDouble),res.minBy(x => x._2.toDouble))
    }
/*
  Which gatherer contributed most to your income (during the whole year and by month)?
 */
  println(" 3 rd part")

  val Data31 = data.groupBy(x =>(x(0),x(1)))
  /// data.groupBy(x =>(x(0),x(1)))("John","2020-01-02").groupBy(x => x(2))("apples").map(x => x(3).toDouble).foldLeft(0.0)(_+_)
  val Data32 = data2.groupBy(x => (x(1)))
  // data2.groupBy(x => (x(1)))("2020-01-02").groupBy(x => x(0))("apples").map(x => x(2).toDouble).head


  val amountGatherByPerson = for {
    g <- gatherer
    d <- dateKeyset
  } yield List(g,d,amountBasedOnPerson(g,d).toString)

    def amountBasedOnPerson(gather : String, d : String): Double = {

          val listOfHarvest = if(Data31.contains(gather,d)) Data31(gather,d) else Data31("John","2020-12-30")
          val listOfPrice = Data32(d)
          val res = for{
            f <- fruits
          } yield listOfHarvest.filter(x => x(2) == f).map(x => x(3).toDouble).foldLeft(0.0)(_+_) * listOfPrice.filter(x => x(0) == f).map(x =>x(2).toDouble).head
        res.foldLeft(0.0)(_+_)
    }

    //println(amountGatherByPerson.filter(x => x.head == "John").map(x => x(2).toDouble).foldLeft(0.0)(_+_))

  val ans = for {
    g <- gatherer
  } yield List(g,amountGatherByPerson.filter(x => x.head == g).map(x => x(2).toDouble).foldLeft(0.0)(_+_).toString)
  println(" max gatherer based on amount")
  println(ans.maxBy(x => x(1).toDouble))
  println(" min gatherer based on amount")
  println(ans.minBy(x => x(1).toDouble))

}
