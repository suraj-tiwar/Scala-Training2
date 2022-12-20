package lectures.part2oop

import Playground.{PrinceCharming, Cinderella => princess}

import java.sql
import java.util.Date
import java.sql.{Date => SqlDate}

object PackagingAndImports extends App{
  val writer = new writer("Suraj","tiwari",23)
  // package member are accessilbe by their sample name
  val princess = new princess
  val princess1 = new princess
  SayHello // package Object i.e that we are given the told about me
  println(SPEED_OF_LIGHT)
  val val1 = new PrinceCharming

  // use FQ Names
  val d = new Date()
  val excuss = new SqlDate(1999,12,16)

  //Default Import
  // java.lang
  // scala
  // scala.Predef


}
