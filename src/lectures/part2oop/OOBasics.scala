package lectures.part2oop

object OOBasics extends App {
  val person = new person("jhon")
  val p2 = new person()
  println(person.x)
  person.greeting("Vishal")
  person.greeting()
  p2.greeting()

  val author = new writer("Charles", "Dickens", 1812)
  val imposter = new writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectation", 1861, author)

  println(novel.authorAge())
  println(novel.isWrittenBy(imposter))

  val counter = new counter(1)
  println(counter.count)
  counter.inc(10).print
  counter.dec.print
  println(counter.count)


}
class person(name:String,val age:Int)
{
 val x = age;
  def greeting(name:String):Unit=println(s"${this.name} say:Hi $name")
// over loading
  def greeting () :Unit = print(s"Hi i am $name")

  // multple Constructor

  def this(name:String) = this(name,0)
  def this() = this("Suraj")

}

class writer( first_name:String, surname:String, year:Int)
{ val firstName :String = first_name
  val surName :String= surname
  val age:Int = year;
  def fullName():String = (s"$firstName+$surName")
}

class Novel(val name: String,val YearOfRelase: Int,val author: writer)
{
  def authorAge():Int= YearOfRelase - author.age // return the age based on novel realseYear and Author birth year

  def isWrittenBy(author: writer)= author ==  this.author // check for author validation

  def copy(year: Int):Novel= new Novel(this.name,year,this.author) // return new Novel object with updated Novel release year
}

class counter(val count:Int){

  def inc = {
    println("Incrementing")
    new counter(count+1) // creating a new object with new count value incremented by 1
  }

  def dec = {
    println("Decrementing")
    new counter(count-1)  // creating a new object with new count value with decremented by 1
  }

  def dec(n :Int): counter = {
    if(n <= 0)
      this
      else
      dec.dec(n-1)   // current object to call dec then call recursively to same function
  }
  def inc(n: Int):counter={
    if(n <= 0)
      this
    else
      inc.inc(n-1)  // current object to call dec then call recursively to same function
  }
  def print = println(count)
}

