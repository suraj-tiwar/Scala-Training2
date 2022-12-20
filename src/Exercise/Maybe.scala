package Exercise

abstract  class Maybe[+T] {
  def map[B](f: T => B):Maybe[B]
  def flatMap[B](f : T => Maybe[B]):Maybe[B]
  def filter[B](f : T => Boolean): Maybe[T]

}
case object MaybeNot extends Maybe[Nothing]
{
  def map[B](f: Nothing => B):Maybe[B] = MaybeNot
  def filter[B](f : Nothing => Boolean) :Maybe[Nothing] = MaybeNot
  def flatMap[B](f: Nothing => Maybe[B]):Maybe[Nothing] = MaybeNot
}
case class Just[+T](value : T) extends Maybe[T]
{
  def map[B](f: T => B): Maybe[B] = Just(f(value))

  def flatMap[B](f: T => Maybe[B]): Maybe[B] = f(value)

  def filter[B](f: T => Boolean): Maybe[T] = if(f(value)) this
  else
    MaybeNot
}
object MyTest extends App{
  val just3 =  Just(3)
  println(just3)
  println(just3.map(_*2))
  println(just3.flatMap(x => Just(x % 2 == 0)))
  println(just3.filter(x => x % 2 ==0))
}
