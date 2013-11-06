package week7

object testPouring {
  val problems = new Pouring(Vector(4, 7, 23))    //> problems  : week7.Pouring = week7.Pouring@1f4384c2
  problems.moves                                  //> res0: scala.collection.immutable.IndexedSeq[Product with Serializable with we
                                                  //| ek7.testPouring.problems.Move] = Vector(Empty(0), Empty(1), Empty(2), Fill(0)
                                                  //| , Fill(1), Fill(2), Pour(0,1), Pour(0,2), Pour(1,0), Pour(1,2), Pour(2,0), Po
                                                  //| ur(2,1))
  
  problems.solutions(13)                          //> res1: Stream[week7.testPouring.problems.Path] = Stream(Fill(0) Fill(2) Pour(
                                                  //| 0,1) Pour(2,1) Empty(1) Pour(2,1) --> Vector(0, 7, 13), ?)
}