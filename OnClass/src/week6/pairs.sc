package week6

object pairs {
	def isPrime(n: Int): Boolean = (2 to n-1) forall (n % _ != 0)
                                                  //> isPrime: (n: Int)Boolean
	
	var n = 5                                 //> n  : Int = 5
	
	(1 until n) flatMap (i =>
	(1 until i) map (j => (i, j))) filter (pair => isPrime(pair._1 + pair._2))
                                                  //> res0: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3,2
                                                  //| ), (4,1), (4,3))
	(1 until n) map (i =>
	(1 until i) map (j => (i, j)))            //> res1: scala.collection.immutable.IndexedSeq[scala.collection.immutable.Index
                                                  //| edSeq[(Int, Int)]] = Vector(Vector(), Vector((2,1)), Vector((3,1), (3,2)), V
                                                  //| ector((4,1), (4,2), (4,3)))
  
  for {
  	i <- 1 until n
  	j <- 1 until i
  	if isPrime(i + j)
  } yield (i, j)                                  //> res2: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3,2
                                                  //| ), (4,1), (4,3))
  
  def scalarProduct(xs: Array[Int], ys: Array[Int]): Int =
  	(for ((x, y) <- xs zip ys ) yield x * y).sum
                                                  //> scalarProduct: (xs: Array[Int], ys: Array[Int])Int
}