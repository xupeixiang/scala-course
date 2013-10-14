package week4

trait Expr {
  def isNumber: Boolean
  def isSum: Boolean
  def isVar: Boolean
  def isProdd: Boolean
  def name: String
  def numValue: Int
  def leftOp: Expr
  def rightOp: Expr
  
  def show(): String = this match {
    case Number(n) => n.toString
    case Sum(e1, e2) => e1.show() + '+' + e2.show()
    case Var(e) => e
    case Prod(e1, e2) => e1 match {
      case Number(n) => n.toString + '*' + (e2 match {
        case Number(m) => m.toString
        case Sum(e3, e4) => "(" + e3.show() + "+" + e4.show() +")" 
        case Var(e) => e
        case Prod(e3, e4) => e1.show() + '*' + e2.show()
      })
      case Var(e) => e + '*' + (e2 match {
        case Number(m) => m.toString
        case Sum(e3, e4) => "(" + e3.show() + "+" + e4.show() +")" 
        case Var(e) => e
        case Prod(e3, e4) => e1.show() + '*' + e2.show()
      })
      case Sum(e3, e4) => "(" + e3.show() + "+" + e4.show() + ")*" + (e2 match {
        case Number(m) => m.toString
        case Sum(e3, e4) => "(" + e3.show() + "+" + e4.show() +")" 
        case Var(e) => e
        case Prod(e3, e4) => e1.show() + '*' + e2.show()
      })
      case Prod(e3, e4) => e1.show() + '*' + (e2 match {
        case Number(m) => m.toString
        case Sum(e3, e4) => "(" + e3.show() + "+" + e4.show() +")" 
        case Var(e) => e
        case Prod(e3, e4) => e1.show() + '*' + e2.show()
      })
      
     }
  }
}

case class Number(n: Int) extends Expr{
  def isNumber: Boolean = true
  def isSum: Boolean = false
  def isVar: Boolean = false
  def isProdd: Boolean = false
  def name: String = throw new Error("Number.name")
  def numValue: Int = n
  def leftOp: Expr = throw new Error("Number.leftop")
  def rightOp: Expr = throw new Error("NUmber.rightop")
}

case class Sum(e1: Expr,e2: Expr) extends Expr{
  def isNumber: Boolean = false
  def isSum: Boolean = true
  def isVar: Boolean = false
  def isProdd: Boolean = false
  def name: String = throw new Error("Sum.name")  
  def numValue: Int = throw new Error("Sum.numValue")
  def leftOp: Expr = e1
  def rightOp: Expr = e2
}

case class Var(e: String) extends Expr {
  def isNumber: Boolean = false
  def isSum: Boolean = false
  def isVar: Boolean = true
  def isProdd: Boolean = false
  def name: String = e
  def numValue: Int = throw new Error("Number.name")
  def leftOp: Expr = throw new Error("Number.leftop")
  def rightOp: Expr = throw new Error("NUmber.rightop")
}
case class Prod(e1: Expr, e2: Expr) extends Expr{
  def isNumber: Boolean = false
  def isSum: Boolean = false
  def isVar: Boolean = false
  def isProdd: Boolean = true
  def name: String = throw new Error("Sum.name")  
  def numValue: Int = throw new Error("Sum.numValue")
  def leftOp: Expr = e1
  def rightOp: Expr = e2
}