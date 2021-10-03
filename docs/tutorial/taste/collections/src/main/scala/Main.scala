@main def hello: Unit = 
  var a = List(1, 2, 3)
  val b = (1 to 5).toList    // includes 5
  val c = (1 to 5 by 2).toList
  val d = (1 until 5).toList // does not include 5
  val e = List.range(1, 5)   // does not include 5
  val f = List.range(1, 10, 3)
  
  a = List(10, 20, 30, 40, 10)
  println(a)
  println(a.drop(2))           // (30, 40, 10)
  println(a.dropWhile(_ < 25)) // (30, 40, 10)
  println(a.filter(_ < 25))    // (10, 20, 10)
  println(a.slice(2, 4))       // (30, 40)
  println(a.tail)              // (20, 30, 40, 10)
  println(a.take(3))           // (10, 20, 30)
  println(a.takeWhile(_ < 30)) // (10, 20)

  val g = List(List(1, 2), List(3, 4))
  println(g.flatten) // (1, 2, 3, 4)
  val nums = List("one", "two")
  println(nums.map(_.toUpperCase))
  println(nums.flatMap(_.toUpperCase)) // ('O', 'N', 'E', 'T', 'W', 'O')

  val firstTen = (1 to 10).toList
  println(firstTen.reduceLeft(_ + _))    // 55
  println(firstTen.foldLeft(100)(_ + _)) // 155


  /* Tuples */
  case class Person(name: String)
  val t = (11, "eleven", Person("Eleven"))
  println(t(0)) // 11
  println(t(1)) // "eleven"
  println(t(2)) // Person("Eleven")

  val (n, str, person) = t
  println(s"$n, $str, $person")
