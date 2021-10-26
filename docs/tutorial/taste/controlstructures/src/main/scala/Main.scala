import scala.annotation.switch


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
  var i = 1
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

  // alt syntax
  z = 0
  while (z < 3) {
    println(z)
    z += 1
  }


  // match
  val day = i match
    case 0 => "Sunday"
    case 1 => "Monday"
    case 2 => "Tuesday"
    case 3 => "Wednesday"
    case 4 => "Thursday"
    case 5 => "Friday"
    case 6 => "Saturday"
    case _ => "Invalid day"
  println(s"day: $day")

  i = 7
  i match
    case 0 => println("1")
    case 1 => println("2")
    case what => println(s"Modified what: ${what + 1}")

  val evenOrOdd = i match
    case 1 | 3 | 5 | 7 | 9 => println("that's odd")
    case 0 | 2 | 4 | 6 | 8 => println("nothing odd about it")
    case _ => println("outside of range")

  i match
    case 1 => println("the loneliest number")
    case x if x == 2 || x == 3 => println("the loneliest numbers since the number one")
    case x if x > 3 => println("stimulus overload")
    case _ => println("we may never know")

  speak(Person("Fred"))
  speak(Person("Bam Bam"))

  println(isTruthy(0))
  println(isTruthy(1))
  println(isTruthy(""))
  println(isTruthy("0"))

  /*
  var text = ""
  try
    text = openAndReadFile(f)
  catch
    case fnf: FileNotFoundException => fnf.printStackTrace()
    case ioe: IOException => ioe.printStackTrace()
    case _ => println("Something bad happened")
  finally
    println("And finally, the finally")
  */


case class Person(name: String)

def speak(p: Person) = p match
  case Person(name) if name == "Fred" => println(s"$name says yabba dabba doo")
  case Person(name) if name  == "Bam Bam" => println(s"$name says $name")
  case _ => println("Rock on!")


def isTruthy(a: Matchable) = a match
  case 0 | "" | false => false
  case _ => true


def pattern(x: Matchable): String = x match
  // const patterns
  case 0 => "zero"
  case true => "true"
  case "hello" => "why hello"
  case Nil => "nuffin"

  // seqs
  case List(0, _, _) => "A list: (0, x, y)"
  case List(1, _*) => "A list: (1, ...)"
  case Vector(0, _*) => "A vector: [0, ...]"

  // tups
  case (a, b) => s"just $a and $b"
  case (a, b, c) => "I can't keep track of all your stuff"

  // constructors
  case Person(name) => s"a dude(tte) named $name"

  // types
  case s: String => "le string"
  case i: Int => "Int ain't it?"
  case f: Float => "Flotsam"
  case a: Array[Int] => s"Ints a plenty: ${a.mkString(", ")}"
  case as: Array[String] => s"les stings: ${as.mkString(", ")}"
  case list: List[?] => "The List.  The List"
  case m: Map[?, ?] => m.toString

  case _ => "Ruh?"
