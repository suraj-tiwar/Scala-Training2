package lectures.part1basics

object Expressions extends App{
  val x = 1+2
  println(x);
  println(2+2 *4);
  // + = * / ! & ^ << >> >>>
  println( x ==1);
  // == != > >= < <=
  println(!(1 ==x))
  var aVariable = 2;
   aVariable += 5;
  println(aVariable)

  ///
  val aCondition = true
  val aConditionedValue = if(aCondition) 5 else 3
  println(aConditionedValue)
  println( if(aCondition) 5 else 3)


  // loops
  var i = 0;
  val count = while(i < 10)
    {
      print(i+" ");
      i += 1
    }
  print(count)
  val aWeirdValue = (aVariable = 3) // unit type
  println(aWeirdValue)


  val aCodeBlock =
    {
      // val inside this block remains into to this block.
      val y = 2
      val z = y + 1
      if(z > 2)
        "hello" else "goodbye"

      // code val stores the values of the last expression
    }
println(aCodeBlock)

  val s = "Hello, World";  // it is string
  println("Hello, world") // this is expression side effect print to console.

  val someValue = // boolean Value which is true
  {
    2 < 3
  }

  val someOtherValue =
    {
      if(someValue) 239 else 986
      42
    }
println(someOtherValue)

}
