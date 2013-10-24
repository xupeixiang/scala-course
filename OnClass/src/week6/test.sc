package week6

object demo {
  var as = Array(1, 2, 3, 44)                     //> as  : Array[Int] = Array(1, 2, 3, 44)
  as map (x => x * 2)                             //> res0: Array[Int] = Array(2, 4, 6, 88)
  
  var s = "Hello World"                           //> s  : String = Hello World
  s filter (c => c.isUpper)                       //> res1: String = HW
  
  s exists (_ isUpper)                            //> res2: Boolean = true
  s forall (_ isUpper)                            //> res3: Boolean = false
  
  var pairs = List(1, 2, 3) zip s                 //> pairs  : List[(Int, Char)] = List((1,H), (2,e), (3,l))
  pairs.unzip                                     //> res4: (List[Int], List[Char]) = (List(1, 2, 3),List(H, e, l))
  
  s map (c => List('.', c))                       //> res5: scala.collection.immutable.IndexedSeq[List[Char]] = Vector(List(., H),
                                                  //|  List(., e), List(., l), List(., l), List(., o), List(.,  ), List(., W), Lis
                                                  //| t(., o), List(., r), List(., l), List(., d))
  s flatMap (c => List('.', c))                   //> res6: String = .H.e.l.l.o. .W.o.r.l.d
  
  as.sum                                          //> res7: Int = 50
  
  var M = 3                                       //> M  : Int = 3
  var N = 4                                       //> N  : Int = 4
  (1 to M) flatMap (x => (1 to N) map (y => (x, y)))
                                                  //> res8: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((1,1), (1,2
                                                  //| ), (1,3), (1,4), (2,1), (2,2), (2,3), (2,4), (3,1), (3,2), (3,3), (3,4))
  // map not flat map bc result is seq of Int not seq of seq
	def scalarProduct(xs: Array[Int], ys: Array[Int]): Int =
		(xs zip ys).map(xy => xy._1 * xy._2).sum
                                                  //> scalarProduct: (xs: Array[Int], ys: Array[Int])Int
  scalarProduct(as, as)                           //> res9: Int = 1950
  def isPrime(n: Int): Boolean = (2 to n-1) forall (n % _ != 0)
                                                  //> isPrime: (n: Int)Boolean
  isPrime(13)                                     //> res10: Boolean = true
}