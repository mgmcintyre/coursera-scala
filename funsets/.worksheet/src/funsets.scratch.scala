package funsets

import funsets._

object scratch {
  
  type Set = Int => Boolean;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(111); 
  
  val x = Set(1, 2, 3, 4);System.out.println("""x  : scala.collection.immutable.Set[Int] = """ + $show(x ));$skip(20); 
  val y = Set(1, 7);System.out.println("""y  : scala.collection.immutable.Set[Int] = """ + $show(y ));$skip(11); val res$0 = 
  
  x | y;System.out.println("""res0: scala.collection.immutable.Set[Int] = """ + $show(res$0))}
  
}
