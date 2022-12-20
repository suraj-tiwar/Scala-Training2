package lectures.part1basics

object values extends  App {
  val x: Int = 43
  println(x)

  // vals are Immutable (java String)
  // compiler can figure out the type

  val aString: String = " Hello";
  println(aString);
  val aBoolean : Boolean = false;
  val aChar : Char = 'a'
  val anInt : Int = x;
  val ashort :Short = 456;
  val aLong: Long = 4823480242L;
  var  y : Int = 42;
  y = 45;
  println(y);

}
