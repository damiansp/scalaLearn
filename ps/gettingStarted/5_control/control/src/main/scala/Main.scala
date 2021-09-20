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


  /* for */
  val amounts = Array(10, 24, 35, 23, 12)
  var sum = 0
  for (amount <- amounts) { sum += amount }
  println(sum)

  val result: Array[Int] = for(amt <- amounts) yield { amt }
  println(result)

  val currencies = Array("USD", "NZD")
  val res2: Array[String] = for {
    amt <- amounts
    cur <- currencies
    if amt > 20 && amt < 30
  } yield cur + " " + amt
  println(res2)

  amounts.foreach(amt => println(amt / 10.0))
  List(1, 2, 3, 4).foreach(n => println(10 * n))


  /* while */
  var i = 1
  while (i < 10) {
    println(i)
    i += 1
  }