@main def hello: Unit = 
  // if/then/else
  val x = 2
  if x == 1 then
    println("x is 1")
  else if x <= 0 then
    println("x is not positive")
  else
    println("x is positive")
  end if // optional

  val a = 2 * x + 3
  val b = 3 * x - 2
  val minVal = if a < b then a else b
  println(s"min: $minVal")

  val comp = compare(a, b)
  println(s"Compare(a, b): $comp")

  val ints = Seq(1, 2, 3)
  for i <- ints do println(i)
  for (i <- ints) println(i)
  for i <- ints do 
    val x = 2 * i
    println(s"i: $i, x: $x")
  
  for 
    i <- 1 to 2
    j <- 'a' to 'b'
    k <- 1 to 10 by 5
  do
    println(s"$i$j$k")

  for
    i <- 1 to 5
    if i % 2 == 0
  do
    println(i)

  for
    i <- 1 to 50
    if i % 2 == 0
    if i % 3 == 0
    if i % 7 == 0
  do
    println(i)

  val states = Map("WA" -> "Washington", "OR" -> "Oregon", "CA" -> "California")
  for (abbr, full) <- states do println(s"$abbr: $full")

  val list = 
    for
      i <- 10 to 15
    yield
      2 * i
  println(list)

  val list2 = (10 to 12).map(i => 2 * i)
  println(list2)

  val names = List("_olivia", "_walter", "_peter")
  val formattedNames = for name <- names yield 
    val noUnder = name.drop(1)
    noUnder.capitalize
  println(formattedNames)

  val accepted = bet3and10(List(1, 1, 2, 3, 5, 8, 13, 21))
  println(accepted)


  // while






def compare(a: Int, b: Int): Int = 
  if a < b then
    -1
  else if a == b then
    0
  else
    1

def bet3and10(xs: List[Int]): List[Int] = 
  for
    x <- xs
    if x >= 3
    if x <= 10
  yield x