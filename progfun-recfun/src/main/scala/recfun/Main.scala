package recfun
import common._

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
    if (c == 0 || c == r) 
      1 
    else 
      pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def count(accu: Int, chars: List[Char]): Int = {
      if (chars.isEmpty || accu < 0) accu
      else {
        if (chars.head == '(') count(accu + 1, chars.tail)
        else if (chars.head == ')') count(accu - 1, chars.tail)
        else count(accu, chars.tail)
      }
    }
    
    count(0, chars) == 0 
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if(money == 0) 1
    else if (coins.isEmpty || money < 0) 0
    else countChange(money - coins.head, coins) + countChange(money, coins.tail)
  }
}
