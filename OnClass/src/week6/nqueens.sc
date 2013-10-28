package week6

object nqueens {
  def queens(n: Int): Set[List[Int]] = {
  	def placeQueens(k: Int): Set[List[Int]] =
  		if(k == 0) Set(List())
  		else
  			for { //amazing!
  				queens <- placeQueens(k - 1)
  				col <- 0 until n
  				if isSafe(col, queens)
  			} yield col :: queens
  	// case must if (x, y) of x_1 x_2
  	def isSafe(col: Int, queens: List[Int]): Boolean = ((queens.length - 1 to 0 by -1) zip queens) forall {case(x, y) => y != col && math.abs(y - col) != (queens.length - x)}
 		
  	placeQueens(n)
  }                                               //> queens: (n: Int)Set[List[Int]]
  queens(4)                                       //> res0: Set[List[Int]] = Set(List(1, 3, 0, 2), List(2, 0, 3, 1))
  def show(queens: List[Int]) = {
  	var lines =
  		for (col <- queens.reverse)
  		yield Vector.fill(queens.length)("* ").updated(col, "X ").mkString
  	"\n" + (lines mkString "\n")
  }                                               //> show: (queens: List[Int])String
  queens(4) map show mkString "\n"                //> res1: String = "
                                                  //| * * X * 
                                                  //| X * * * 
                                                  //| * * * X 
                                                  //| * X * * 
                                                  //| 
                                                  //| * X * * 
                                                  //| * * * X 
                                                  //| X * * * 
                                                  //| * * X * "
}