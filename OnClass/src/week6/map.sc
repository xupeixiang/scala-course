package week6

object map {
	val romanNumerals = Map("I" -> 1, "V" -> 5, "X" -> 10)
                                                  //> romanNumerals  : scala.collection.immutable.Map[String,Int] = Map(I -> 1, V -
                                                  //| > 5, X -> 10)
	val capitalOfCountry = Map("US" -> "Washington", "SwitzerLland" -> "Bern", "China" -> "Beijing")
                                                  //> capitalOfCountry  : scala.collection.immutable.Map[String,String] = Map(US -
                                                  //| > Washington, SwitzerLland -> Bern, China -> Beijing)
  // option
  capitalOfCountry get "andorra"                  //> res0: Option[String] = None
	capitalOfCountry get "US"                 //> res1: Option[String] = Some(Washington)
	
	var fruit = List("apple", "pear", "orange", "pineapple")
                                                  //> fruit  : List[String] = List(apple, pear, orange, pineapple)
	fruit sortWith (_.length < _.length)      //> res2: List[String] = List(pear, apple, orange, pineapple)
	fruit.sorted                              //> res3: List[String] = List(apple, orange, pear, pineapple)
	fruit groupBy (_.head)                    //> res4: scala.collection.immutable.Map[Char,List[String]] = Map(p -> List(pear
                                                  //| , pineapple), a -> List(apple), o -> List(orange))
}