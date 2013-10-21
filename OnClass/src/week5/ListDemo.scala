package week5
import math.Ordering

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
	
	//merge for merge sort
	def merge[T](xs: List[T], ys: List[T])(implicit order: Ordering[T]): List[T] = (xs, ys) match {
	  case (Nil, n) => ys
	  case (m, Nil) => xs
	  case (m:: ms, n:: ns) => if (order.lt(m,n)) m :: merge(ms, ys) else n :: merge(xs, ns)
	}
	
	def squareList(xs: List[Int]) : List[Int] = xs match {
	  case Nil => Nil
	  case y :: ys => y*y :: squareList(ys)
	}
	
	def squareListWithMap(xs: List[Int]): List[Int] = 
	  xs map (x => x*x)
}