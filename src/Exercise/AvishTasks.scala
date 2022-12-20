package Exercise

object AvishTasks extends App{
  def fibo(n :Int,acc1:Int,acc2:Int):Unit=
  {
    if(n <= 0) println(acc2)
    else {
      print(acc1+acc2+" ")
      fibo(n-1,acc2,acc1+acc2)
    }
  }
  fibo(5,0,1)

  def fact(n:Int):Int= {
    if(n <= 1) 1
    else
      n * fact(n-1)
  }
  println(fact(5))

  def fact1(n:Int , Acc :Int):Int ={
    if(n <= 1) Acc
    else
      fact1(n-1,n * Acc)
  }
  println(fact1(5,1))
}
