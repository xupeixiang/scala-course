package week5

object ListDemo {
	def init[T](xs: List[T]): List[T] = xs match {
	  case List() => throw new Error("init of empty list")
	  case List(x) => List(x)
	  case y :: ys => y :: init(ys)
	}
	
	def concat[T](xs: List[T], ys: List[T]): List[T] = xs match {
	  case List() => ys
	  case z :: zs => z :: concat(zs, ys)
	}
	
	def reverse[T](xs: List[T]): List[T] = xs match {
	  case List() => List()
	  case y :: ys => reverse(ys) ++ List(y)
	}
	
	def removeAt[T](xs: List[T], n: Int): List[T] = xs match {
	  case List() => xs
	  case y :: ys => if(n < 0) xs 
	  				  else if(n == 0) ys
	  				  else y :: removeAt(ys, n-1)
	}
	
	def removeAtWithUtils[T](xs: List[T], n: Int) = (xs take n) ::: (xs drop n + 1)
}