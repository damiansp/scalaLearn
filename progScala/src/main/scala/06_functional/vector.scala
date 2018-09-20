val vect1 = Vector("good", "books")
val vect2 = "People" +: "should" +: "read" +: vect1
val vect3 = "good" +: "books" +: Vector.empty
val vect4 = "I" +: "like" +: Vector.empty
val vect5 = vect4 ++ vect3

println(vect5(3)) // "good"
