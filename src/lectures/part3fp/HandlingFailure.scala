package lectures.part3fp

import lectures.part3fp.Options.Connection

import scala.util._

object HandlingFailure extends App {

  // create success and faillure
  val aSuccess = Success(3)
  val aFailure = Failure(new RuntimeException("SUPER FAILURE"))
  println(aSuccess)
  println(aFailure)

  def unSafeMethod() : String  = throw new RuntimeException("No STRING FOR YOU BUSTER")

  val potentialFailure = Try(unSafeMethod())
  println(potentialFailure)
  val anotherPotentailFailure = Try {
    // code that might throw
  }
   println(potentialFailure.isSuccess)

  def backUpMethod() : String = " A Valid  result"
  val fallbacktry = Try(unSafeMethod()).orElse(Try(backUpMethod()))
  println(fallbacktry)

  //  If you design API
  def betterUnSafeMethod(): Try[String] = Failure(new RuntimeException)
  def betterBackUpMethod(): Try[String] = Success("A Valid Result")
  println(betterBackUpMethod() orElse betterBackUpMethod())

  println(aSuccess.map(_*2))
  println(aSuccess.flatMap(x =>  Success(x * 10)))
  println(aSuccess.filter(_ > 10)) // predicate does not hold for 3

  /* Exercise

   */
  val hostname = "localhost"
  val port = "8080"
  def renderHTML(page : String) = println(page)

  class Connection
  {
    def get(url: String) : String =
      {
        val random = new Random(System.nanoTime())
        if(random.nextBoolean()) "<html> .... </html>"
        else
           throw new RuntimeException("Connection Interrupted")
      }
      def renderHTML(page : String)  = println(page)

    def getSafe(url : String) : Try[String] = Try(get(url))
  }

  object HttpService
  {
    val random = new Random(System.nanoTime())
    def getConnection(host:String,port:String): Connection ={
      if(random.nextBoolean()) new Connection
      else
        throw new RuntimeException("Someone else took the port")
    }
    def safeGetConnection(host : String,port : String) : Try[Connection] = Try(getConnection(host,port))
  }
  // if you get the html page from the connection, print it to the console i.e call renderTHML
  val possibleConnection = HttpService.safeGetConnection(hostname,port)
  val possibleHTMl = possibleConnection.flatMap(connection => connection.getSafe("/home"))
  println(possibleHTMl)
  possibleHTMl.foreach(renderHTML)

  // chained connection
  HttpService.safeGetConnection(hostname,port)
    .flatMap(connection => connection.getSafe("/home"))
    .foreach(renderHTML)

  // for comprehension version
  for {
    connection <- HttpService.safeGetConnection(hostname,port)
    html <- connection.getSafe("/home")

  }renderHTML(html)


  /*
  try {
  connection = HttpService.getConnection(host,port)
  try
  {
  page = connection.get("home")
  renderHtml(page)
  }catch (exception)
  {
  }
  }
   */


}
