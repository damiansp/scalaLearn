val list1 = List("Programming", "Scala")
val list2 = "I" :: "like" :: list1
val list3 = "Programming" :: "Scala" :: Nil // List(Programming, Scala)
val list4 = "I" :: "like" :: Nil            // List(I, like)
val list5 = list4 ++ list3                  // List(I, like, Programming, Scala)

  
