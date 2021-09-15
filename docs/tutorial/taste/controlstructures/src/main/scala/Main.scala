@main def hello: Unit = 
  // if/else
  val x = 11
  if x < 0 then
    println("negative")
  else if x == 0 then
    println("zero")
  else
    println("positive")

  val a = 2 * x
  val b = 4 * x
  val y = if a < b then a else b


  // for
  val ints = List(1, 2, 3, 4, 5)
  for i <- ints do println(i)
  for (i <- ints) println(i)
  for 
    i <- ints
    if i > 2
  do
    println(i)

  for
    i <- 1 to 3
    j <- 'a' to 'c'
    if i == 2
    if j == 'b'
  do
    println(s"i = $i, j = $j")

  // for expressions
  val doubles = for i <- ints yield 2 * i
  val d1 = for (i <- ints) yield 2 * i
  val d2 = for (i <- ints) yield (2 * i)
  val d3 = for { i <- ints } yield (2 * i)

  val names = List("chris", "ed", "maurice")
  val capNames = for name <- names yield name.capitalize
  val fruits = List("apple", "banana", "lime", "orange")
  val fruitsLength = for 
    f <- fruits
    if f.length > 4
  yield
    // multiple lines here ok too
    f.length

  
  // match
  val i = 1
  i match
    case 1 => println("one")
    case 2 => println("two")
    case _ => println("other")

  /*
  val p = Person("Fred")
  p match
    case Person(name) if name == "Fred" => 
      println(s"$name says Yabba Dabba Doo")
    case Person(name) if name == "Bam Bam" => println(s"$name say Bam Bam")
    case _ => println("Meet the Flintsones")
  */

  def getClassAsString(x: Matchable): String = x match
    case s: String => s"'$s' is a String"
    case i: Int => "Int"
    case d: Double => "Double"
    case l: List[_] => "List"
    case _ => "Unknown"

  println(getClassAsString(1))
  println(getClassAsString("hello"))
  println(getClassAsString(List(1, 2, 3)))


  // try/catch/finally
  /*
  try
    writeTextToFile(text)
  catch
    case ioe: IOException => println("Got IOException")
    case nfe: NumberFormatException => ("Got NumberFormatException")
  finally
    println("Clean yourself up!")
  */


  // while
  /*
  while x >= 0 do x = f(x)
  while (x >= 0) { x = f(x) }
  */
  var z = 1
  while 
    z < 3
  do
    println(z)
    z += 1