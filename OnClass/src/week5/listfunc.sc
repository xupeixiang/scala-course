package week5

object listfunc {
  var nums = List(2, -4, 5, 7, 1)                 //> nums  : List[Int] = List(2, -4, 5, 7, 1)
  var fruits = List("apple", "orange", "pineapple", "banana")
                                                  //> fruits  : List[String] = List(apple, orange, pineapple, banana)
  var packNums = List(1, 1, 1, 2, 4, 4)           //> packNums  : List[Int] = List(1, 1, 1, 2, 4, 4)
  
  nums filter (x => x > 0)                        //> res0: List[Int] = List(2, 5, 7, 1)
  nums filterNot (x => x < 0)                     //> res1: List[Int] = List(2, 5, 7, 1)
  nums partition (x => x > 0)                     //> res2: (List[Int], List[Int]) = (List(2, 5, 7, 1),List(-4))
  
  nums takeWhile (x => x > 0)                     //> res3: List[Int] = List(2)
  nums dropWhile (x => x > 0)                     //> res4: List[Int] = List(-4, 5, 7, 1)
  nums span (x => x > 0)                          //> res5: (List[Int], List[Int]) = (List(2),List(-4, 5, 7, 1))
 
 	def pack[T](xs: List[T]): List[List[T]] = xs match {
  	case Nil => Nil
  	case x:: xs1 => (xs takeWhile (y => y == x)) :: pack(xs1 dropWhile (z => z == x))
  }                                               //> pack: [T](xs: List[T])List[List[T]]
  
  pack(packNums)                                  //> res6: List[List[Int]] = List(List(1, 1, 1), List(2), List(4, 4))
}