package week5

object ListDemo {
	def init[T](xs: List[T]) : List[T] = xs match {
	  case List() => throw new Error("init of empty list")
	  case List(x) => List(x)
	  case y :: ys => List(y) ::: this.drop(1).init[T](ys)
	}
}