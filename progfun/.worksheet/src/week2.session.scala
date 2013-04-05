package week2

import math.abs

object session {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(157); 
  
  def product(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 1
    else f(a) * product(f)(a + 1, b);System.out.println("""product: (f: Int => Int)(a: Int, b: Int)Int""");$skip(28); val res$0 = 
  product(x => 2 * x)(1, 4);System.out.println("""res0: Int = """ + $show(res$0));$skip(56); 
  
  def factorial(n: Int): Int = product(x => x)(1, n);System.out.println("""factorial: (n: Int)Int""");$skip(15); val res$1 = 
  factorial(5);System.out.println("""res1: Int = """ + $show(res$1));$skip(151); 
  
  def mapReduce(f: Int => Int, g: (Int, Int) => Int, u: Int)(a: Int, b: Int): Int =
    if (a > b) u
    else g(f(a), mapReduce(f, g, u)(a + 1, b));System.out.println("""mapReduce: (f: Int => Int, g: (Int, Int) => Int, u: Int)(a: Int, b: Int)Int""");$skip(103); 
    
  def productMap(f: Int => Int)(a: Int, b: Int): Int =
    mapReduce(f, (x, y) => x * y, 1)(a, b);System.out.println("""productMap: (f: Int => Int)(a: Int, b: Int)Int""");$skip(31); val res$2 = 
  productMap(x => 2 * x)(1, 4);System.out.println("""res2: Int = """ + $show(res$2));$skip(48); 
  
  
  // Fixed point
  var tolerance = 0.0001;System.out.println("""tolerance  : Double = """ + $show(tolerance ));$skip(93); 
  
  def isCloseEnough(x: Double, y: Double): Boolean =
    abs((x - y) / x) / x < tolerance;System.out.println("""isCloseEnough: (x: Double, y: Double)Boolean""");$skip(246); 
    
  def fixedPoint(f: Double => Double)(firstGuess: Double): Double = {
    def iterate(guess: Double): Double = {
      val next = f(guess)
      if (isCloseEnough(guess, next)) next
      else iterate(next)
    }
    iterate(firstGuess)
  };System.out.println("""fixedPoint: (f: Double => Double)(firstGuess: Double)Double""");$skip(30); val res$3 = 
  fixedPoint(x => 1 + x/2)(1);System.out.println("""res3: Double = """ + $show(res$3));$skip(75); 
  
  def sqrt(x: Double): Double =
    fixedPoint(y => (y + x / y) / 2)(1);System.out.println("""sqrt: (x: Double)Double""");$skip(10); val res$4 = 
  sqrt(2);System.out.println("""res4: Double = """ + $show(res$4));$skip(84); 
    
  def averageDamp(f: Double => Double)(x: Double): Double =
    (x + f(x)) / 2;System.out.println("""averageDamp: (f: Double => Double)(x: Double)Double""");$skip(81); 
    
  def sqrt2(x: Double): Double =
    fixedPoint(averageDamp(y => x / y))(1);System.out.println("""sqrt2: (x: Double)Double""");$skip(10); val res$5 = 
  sqrt(2);System.out.println("""res5: Double = """ + $show(res$5))}
  
}
