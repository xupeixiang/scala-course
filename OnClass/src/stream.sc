object stream {
  (1 to 1000).toStream                            //> res0: scala.collection.immutable.Stream[Int] = Stream(1, ?)
  
  def streamRange(lo:Int, hi:Int): Stream[Int] =
  	if (lo > hi) Stream.empty
  	else Stream.cons(lo, streamRange(lo + 1, hi))
                                                  //> streamRange: (lo: Int, hi: Int)Stream[Int]
  
  var a = 1 #:: Stream.empty                      //> a  : scala.collection.immutable.Stream[Int] = Stream(1, ?)
  
  // call by name, lazy evaluate
  def cons[T](hd: T, tl: => Stream[T]) = new Stream[T] {
  	override def isEmpty = false
  	override def head = hd
  	override def tail = tl
  	def tailDefined = true
  }                                               //> cons: [T](hd: T, tl: => Stream[T])Stream[T]
}