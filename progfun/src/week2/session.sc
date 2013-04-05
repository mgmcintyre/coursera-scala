package week2

import math.abs

object session {
  
  def product(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 1
    else f(a) * product(f)(a + 1, b)              //> product: (f: Int => Int)(a: Int, b: Int)Int
  product(x => 2 * x)(1, 4)                       //> res0: Int = 384
  
  def factorial(n: Int): Int = product(x => x)(1, n)
                                                  //> factorial: (n: Int)Int
  factorial(5)                                    //> res1: Int = 120
  
  def mapReduce(f: Int => Int, g: (Int, Int) => Int, u: Int)(a: Int, b: Int): Int =
    if (a > b) u
    else g(f(a), mapReduce(f, g, u)(a + 1, b))    //> mapReduce: (f: Int => Int, g: (Int, Int) => Int, u: Int)(a: Int, b: Int)Int
    
  def productMap(f: Int => Int)(a: Int, b: Int): Int =
    mapReduce(f, (x, y) => x * y, 1)(a, b)        //> productMap: (f: Int => Int)(a: Int, b: Int)Int
  productMap(x => 2 * x)(1, 4)                    //> res2: Int = 384
  
  
  // Fixed point
  var tolerance = 0.0001                          //> tolerance  : Double = 1.0E-4
  
  def isCloseEnough(x: Double, y: Double): Boolean =
    abs((x - y) / x) / x < tolerance              //> isCloseEnough: (x: Double, y: Double)Boolean
    
  def fixedPoint(f: Double => Double)(firstGuess: Double): Double = {
    def iterate(guess: Double): Double = {
      val next = f(guess)
      if (isCloseEnough(guess, next)) next
      else iterate(next)
    }
    iterate(firstGuess)
  }                                               //> fixedPoint: (f: Double => Double)(firstGuess: Double)Double
  fixedPoint(x => 1 + x/2)(1)                     //> res3: Double = 1.999755859375
  
  def sqrt(x: Double): Double =
    fixedPoint(y => (y + x / y) / 2)(1)           //> sqrt: (x: Double)Double
  sqrt(2)                                         //> res4: Double = 1.4142135623746899
    
  def averageDamp(f: Double => Double)(x: Double): Double =
    (x + f(x)) / 2                                //> averageDamp: (f: Double => Double)(x: Double)Double
    
  def sqrt2(x: Double): Double =
    fixedPoint(averageDamp(y => x / y))(1)        //> sqrt2: (x: Double)Double
  sqrt(2)                                         //> res5: Double = 1.4142135623746899
  
}