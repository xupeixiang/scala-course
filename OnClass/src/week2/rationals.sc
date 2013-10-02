package week2

object rationals {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
	val x = new Rational(1, 3)                //> x  : week2.Rational = 1/3
	
	val y = new Rational(5, 7)                //> y  : week2.Rational = 5/7
	x.+(y)                                    //> res0: week2.Rational = 22/21
	-y                                        //> res1: week2.Rational = 5/-7
	
	val z = new Rational(3, 2)                //> z  : week2.Rational = 3/2
	x - y - z                                 //> res2: week2.Rational = -79/42
	x + x                                     //> res3: week2.Rational = 2/3
	x.less(y)                                 //> res4: Boolean = true
	x max y                                   //> res5: week2.Rational = 5/7
	
	new Rational(2)                           //> res6: week2.Rational = 2/1
}

class Rational(x:Int, y: Int){

	require(y != 0, "denominator must be  nonzero!")
	
	def this(x: Int) = this(x , 1)

	private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd (b, a % b)
	private def g = gcd(x , y)
	def numer = x / g
	def denom = y / g
	
	def less(that: Rational) = numer * that.denom < that.numer * denom
	def max(that: Rational) = if (this.less(that)) that else that

	def + (that: Rational) =
		new Rational(
		numer * that.denom + that.numer * denom,
		denom * that.denom)
	
	override def toString = numer + "/" + denom
	
	def unary_- = new Rational(- numer, denom)
	def - (that: Rational) = this + -that
	
	
}