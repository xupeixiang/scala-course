package week6

object lazyEva {
  def expr = {
  	// caculate once and immediately
  	val x = { print("x"); 1 }
  	
  	// caculate once and until use
  	lazy val y = {print("y"); 2}
  	
  	// always caculate when use
  	def z = { print("z"); 3}
  	z + y + x + z + y + x
  }                                               //> expr: => Int
  
  expr                                            //> xzyzres0: Int = 12
}