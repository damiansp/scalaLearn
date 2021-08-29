@main def main: Unit =
  val a = 0
  var b = 1
  val msg = "Hello, World"
  // msg= "Aloha" // err
  var msg2 = "Hola, Mundo"
  msg2 = "Aloha"


  val x: Int = 1
  val nums = List(1, 2, 3)

  val by: Byte = 1
  val i: Int = 1
  val l: Long = 1
  val s: Short = 1
  val d: Double = 2.0
  val f: Float = 3.0

  val k = 123 // Int
  val j = 1.0 // Double

  val l2 = 1_000L
  val d2 = 2.2D
  val f2 = 3.3F

  var bi = BigInt(1_234_567_890_987_654_321L)
  var bd = BigDecimal(123_456.789)
  val name = "Bill"
  val c = 'c'


  val firstName = "John"
  val mi = 'Q'
  val surname = "Doe"
  println(s"Full Name: $firstName $mi $surname")
  println(s"2 + 3 = ${2 + 2}")

  val neg = -1
  println(s"neg.abs = ${neg.abs}")

  val q = """
    SELECT *
    FROM table
    WHERE value IS 'filter'
    LIMIT 50;"""
  println(q)