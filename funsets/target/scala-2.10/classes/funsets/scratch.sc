package funsets

import funsets._

object scratch {
  
  type Set = Int => Boolean
  
  val x = Set(1, 2, 3, 4)                         //> x  : scala.collection.immutable.Set[Int] = Set(1, 2, 3, 4)
  val y = Set(1, 7)                               //> y  : scala.collection.immutable.Set[Int] = Set(1, 7)
  
  x | y                                           //> res0: scala.collection.immutable.Set[Int] = Set(1, 2, 7, 3, 4)
  
}