import week3._

object nth {
  def nth[T](n: Int, list: List[T]): T =
    // n < 0 can be eliminated
    if (n < 0 || list.isEmpty) throw new IndexOutOfBoundsException
    else if (n == 0) list head
    else nth(n-1, list tail)                      //> nth: [T](n: Int, list: week3.List[T])T
	
	val list = new Cons(1, new Cons(3, new Cons(5, new Nil)))
                                                  //> list  : week3.Cons[Int] = week3.Cons@7d33fc
	
	nth(2, list)                              //> res0: Int = 5
	//nth(10, list)
  //nth(-1, list)
}