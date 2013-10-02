package week3

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