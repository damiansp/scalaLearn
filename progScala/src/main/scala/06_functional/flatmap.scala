val list = List("now", "is", "", "the", "time")
println(list flatMap(s => s.toList)) // List(n, o, w, i, s, t, ...)


// Same as map() then flatten()
val list2 = List("now", "is", "", "the", "time") map(s => to.List)
// List(List(n, o, w), List(i, s), List(), ...)

println(list2.flatten) // List(n, o, w, i, s, t, ...)
  
