package idealized.scala

abstract class Boolean {
  def ifThenElse[T](t: T, e: T): T
  
  object idealized_true extends Boolean {
	  def ifThenElse[T](t: T, e: T) = t
  }

  object idealized_false extends Boolean {
	  def ifThenElse[T](t: T, e: T) = e
  }
  
  def && (x: Boolean): Boolean = ifThenElse(x, idealized_false)
  def || (x: Boolean): Boolean = ifThenElse(idealized_true, x)
  def unary_! = ifThenElse(idealized_false, idealized_true)
  
  def == (x: Boolean): Boolean = ifThenElse(x, x.unary_!)
  def != (x: Boolean): Boolean = ifThenElse(x.unary_!, x)
  def < (x: Boolean): Boolean  = ifThenElse(idealized_false, idealized_true)
}
