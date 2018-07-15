val t = ("Hello", 1, 2.3)
println("The whole tuple: " + t)
println("First item: " + t._1)
println("Second: " + t._2)
println("And third: " + t._3)

val (t1, t2, t3) = ("World", '!', 0x22)
println(t1 + ", " + t2 + ", " + t3)

val (t4, t5, t6) = Tuple3("World", '!', 0x22)
println(t4 + ", " + t5 + ", " + t6)