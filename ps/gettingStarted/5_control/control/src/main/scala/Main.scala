@main def hello: Unit = 
  val n = 10
  if (n > 10) {
    println("> 10")
  } else if (n == 10) {
    println("= 10")
  } else {
    println("< 10")
  }

  val sym1: String = if (n > 10) { "> 10" } else { "<= 10" }
  val sym2: String = if (n > 10) "> 10" else "<= 10" 
  println(sym1)
