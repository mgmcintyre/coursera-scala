package recfun
import common._
import scala.annotation.tailrec

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    
    def pascalIter(column: Int, row: Int): Int = {
      if (column == 0 || row == column) 1
      else pascalIter(column, row - 1) + pascalIter(column - 1, row - 1)
    }
    
    if (c > r)
      throw new IllegalArgumentException("Column cannot be greater than row!")
    else if (c < 0 || r < 0) 
      throw new IllegalArgumentException("Values for column & row must be positive!")
    else 
      pascalIter(c, r)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    
    def max(x: Int, y: Int) = {
      if (x > y) x
      else y
    }
    
    @tailrec
    def balanceIter(stack: Int, chars: List[Char]): Boolean = {
      if (chars.isEmpty) stack == 0
      else if (chars.head == ')' && stack == 0) false
      else if (chars.head == ')') balanceIter(stack - 1, chars.tail)
      else if (chars.head == '(') balanceIter(stack + 1, chars.tail)
      else balanceIter(stack, chars.tail)
    }
    
    balanceIter(0, chars)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    
    def changeIter(amount: Int, currentCoin: Int, otherCoins: List[Int]): Int = {
      if (amount == 0) 1
      else if (amount < 0) 0
      else {
        if (otherCoins.isEmpty) 
          changeIter(amount - currentCoin, currentCoin, otherCoins)
        else 
          changeIter(amount, otherCoins.head, otherCoins.tail) +
          changeIter(amount - currentCoin, currentCoin, otherCoins)
      }
    }
    
    if(money == 0 || coins.isEmpty) 0
    else changeIter(money, coins.head, coins.tail)
  }
}
