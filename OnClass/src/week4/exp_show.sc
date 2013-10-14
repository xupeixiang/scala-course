package week4

object exp_show {
  var x = Prod(Sum(Number(4),Var("x")), Sum(Number(1), Number(2)))
                                                  //> x  : week4.Prod = Prod(Sum(Number(4),Var(x)),Sum(Number(1),Number(2)))
  x.show()                                        //> res0: String = (4+x)*(1+2)
}