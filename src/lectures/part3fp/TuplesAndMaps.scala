package lectures.part3fp

import scala.annotation.tailrec

object TuplesAndMaps extends App{

  val aTuple =  Tuple2(2,"hello ,Scala") // Tuple2(Int,String)
  val aTuple1 =  (2,"hello ,Scala")
  println(aTuple._1)
  println(aTuple1.copy(_2 = " goodbye Java"))
  println(aTuple1.swap)

  // Maps - keys -> values
  val aMap : Map[Int,String] = Map()
  val phoneBook = Map(("Jim" -> 555), (" Daniel" ->  789),("JIM", 9000)).withDefaultValue(-1) // defaultValue = -1
  // a -> b is sugar for (a,b)
  println(phoneBook)
  println(phoneBook.contains("Jim")) // Boolean
  println(phoneBook("Mary")) // no such element exception
  println(phoneBook("Jim"))
  // add  a pair
  val newPair = "Marry" -> 678
  val otherType = 765 -> 654
  val newPhoneBook= phoneBook + newPair
  println(newPhoneBook)

  // functionals on Maps
  // map, flatmap,filter

 println(phoneBook.map(pair => pair._1.toLowerCase -> pair._2) + " this you are looking at") // overlapped the previous value.
 println(phoneBook.filterKeys(x => x.startsWith("J")))
  println(phoneBook.mapValues(number => "0245-"+number))

  // conversion to other collections
  println(phoneBook.toList)
  println(List(("Daniel",555)).toMap)

  /*
  1. what would happen if I had two original entries "Jim" -> %% and "JIM" -> 900?
  2 overly simplified social network based on maps.
    Person = String
     -add a person to the network
     -remove
     - friend
     - unfriend

     -number of friends of a person
     -person with most friends
     - how many people have friends
     - if there is a social connection between two people (direct or not)
   */

  def add(network : Map[String,Set[String]],person : String): Map[String,Set[String]] =
    {
      network + (person -> Set())  // Adding person to the Network
    }

  def friend(network : Map[String,Set[String]], A : String , B:String): Map[String,Set[String]] = {
      val friendA = network(A) // take current list of friends from A person
      val friendB = network(B) // take current list of frined from B person
    network + (A -> (friendA + B))+ (B -> (friendB+A))  // updateing the network and adding Person B to networkA and adding Person A to networkB
  }
  def unfriend(network: Map[String,Set[String]],A : String,B : String):Map[String,Set[String]] = {
    val friendA = network(A)
    val friendB = network(B)
    val new_friendA  = friendA - B // remove give person from the set
    val new_friendB = friendB - A // remove given person from the set
    network+(A -> new_friendA) + (B -> new_friendB) // these replace the old pair with new pairing from the map
  }
  def remove(network : Map[String, Set[String]],person : String): Map[String,Set[String]] = {
    def removeAux(friends : Set[String], networkAcc: Map[String,Set[String]]): Map[String,Set[String]] =
      if(friends.isEmpty) networkAcc
      else
        removeAux(friends.tail,unfriend(networkAcc,friends.head,person))
    val unfriended = removeAux(network(person),network)
    unfriended - person
  }

  val empty : Map[String,Set[String]] = Map()
  val network = add(add(empty,"Mary"),"Bob")
  println(network)
  println(friend(network,"Bob","Mary"))
  println(unfriend(friend(network,"Bob","Mary"),"Bob","Mary"))
  println(remove(friend(network,"Bob","Mary"),"Bob"))

  def nFriends(network: Map[String,Set[String]],Person: String): Int = {
    if(!network.contains(Person)) 0
  network(Person).size
  }

  def mostFriends(network : Map[String,Set[String]]):String =
    {
      network.maxBy(pair => pair._2.size)._1
    }

  def nPeopleWithNoFriends(network : Map[String,Set[String]]):Int =
    {
      network.count(pair => pair._2.isEmpty)
    }
  def socialConnection(network : Map[String,Set[String]], a : String, b : String): Boolean =
    { @tailrec
      def bfs(target:String,visited : Set[String] ,Queue : Set[String]) : Boolean =
      {
      if(Queue.isEmpty)false  // if queue is empty no node present so we return false.
      else
        {
          val person = Queue.head    // current top of the Queue
        if(person == target) true  // if this target  return true
        else if(visited.contains(person)) bfs(target,visited,Queue.tail) // if it's already visited then just skip it to next node in queue
        else
          bfs(target,visited + person,Queue.tail ++ network(person)) // if then add all neighbour's to the Queue to check
        }
      }
  bfs(b, Set(),network(a))
    }

 }
