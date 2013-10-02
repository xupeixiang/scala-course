import week3.Rational

object scratch {
  //new week3.Rational(3, 2)
  new Rational(3, 4)                              //> res0: week3.Rational = 3/4
  
  def error(msg: String) = throw new Error(msg)   //> error: (msg: String)Nothing
	//error("test")
	val x = null                              //> x  : Null = null
	val y: String = x                         //> y  : String = null
	
	//mis match
	//val z: Int = null
}