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
	  case y :: ys => reverse(ys) ::: List(y)
	}
}