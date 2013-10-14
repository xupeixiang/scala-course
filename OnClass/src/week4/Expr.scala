package week4

trait Expr {
  def isNumber: Boolean
  def isSum: Boolean
  def isVar: Boolean
  def isProd: Boolean
  def name: String
  def numValue: Int
  def leftOp: Expr
  def rightOp: Expr
  
  def show(e: Expr): String = e match {
    case Number(n) => n.toString
    case Sum(e1, e2) => show(e1) + '+' + show(e2)
  }
}

case class Number(n: Int) extends Expr{
  def isNumber: Boolean = true
  def isSum: Boolean = false
  def isVar: Boolean = false
  def isProd: Boolean = false
  def name: String = throw new Error("Number.name")
  def numValue: Int = n
  def leftOp: Expr = throw new Error("Number.leftop")
  def rightOp: Expr = throw new Error("NUmber.rightop")
}

case class Sum(e1: Expr,e2: Expr) extends Expr{
  def isNumber: Boolean = false
  def isSum: Boolean = true
  def isVar: Boolean = false
  def isProd: Boolean = false
  def name: String = throw new Error("Sum.name")  
  def numValue: Int = throw new Error("Sum.numValue")
  def leftOp: Expr = e1
  def rightOp: Expr = e2
}
