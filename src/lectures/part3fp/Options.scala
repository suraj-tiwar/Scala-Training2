package lectures.part3fp

import scala.util.Random

object Options extends App{
  val myFirstOption : Option[Int] = Some(4)
  val noOption : Option[Int] = None
  println(myFirstOption)

  // unsafe APIs
  def unsafeMethod() : String = null
  val result = Some(unsafeMethod()) // no need to check for null

  def backUpMethod()  : String =  "A valid result"
  val chainResult = Option(unsafeMethod()).orElse(Option(backUpMethod()))
  println(chainResult)

  def betterUnsafeMethod() : Option[String] = None
  def betterBackupMethod() : Option[String] = Some("A Valid result")

  val betterChainResult = betterUnsafeMethod() orElse(betterBackupMethod())
  // map ,flatMap, filer
  println(myFirstOption.map(_*2))
  println(myFirstOption.filter(x =>  x > 10))
  println(myFirstOption.flatMap(x => Option(x * 10)))
// given api
  val config: Map[String,String] = Map (
    "host" -> "176.854.36.1",
    "port" -> "80"
    )
  class Connection
  {
    def connect = "Connected"
  }
  object Connection
  {
    val random = new Random(System.nanoTime())
    def apply(host:String ,port : String) : Option[Connection] =
      {
        if(random.nextBoolean()) Some(new Connection)
        else
          None
      }
  }
  val host = config.get("host")
  val port = config.get("port")
  /*
  if( h != null)
    if( p != null)
        return Connection(h ,p)
  return null
   */
  println(host.toString+" "+port.toString)
  val connect = host.flatMap(h => port.flatMap(p => Connection(h,p)))
  /*
  if(c != null)
      return c.null
  else
      return null
   */
  val connectionsStatus = connect.map(c => c.connect)

  /*
  if( connectionsStatus == null) println(None) else println(Some(connectionStatus.get)
   */
  connectionsStatus.foreach(println)
  println(connectionsStatus)


  config.get("host")
    .flatMap(h => config.get("port")
      .flatMap(port => Connection(h,port))
      .map(connection => connection.connect))
    .foreach(println)

  val forConnectionStatus = for{
    h <- host
    p <- port
    connection <- Connection(h,p)
  }yield connection.connect
  forConnectionStatus.foreach(println)




}
