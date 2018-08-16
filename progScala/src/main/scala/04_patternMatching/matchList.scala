val nonEmptyList = List(1, 2, 3, 4, 5)
val emptyList = Nil

def listToString[T](list: List[T]): String = list match {
  case head :: tail => s"($head :: ${listToString(tail)})"
  case Nil          =>  "(Nil)"
}

for (l <- List(nonEmptyList, emptyList)) { println(listToString(l)) }

val s1 = (1 +: (2 +: (3 +: (4 +: (5 +: Nil)))))
val l = (1 :: (2 :: (3 :: (4 :: (5 :: Nil)))))
val s3 = (("i", 1) +: (("ii",  2) +: (("iii", 3) +: ("iv" 4) +: Nil)))
val m = Map(s2 :_*)