@main def hello: Unit = 
  val fo = square(2)
  println(fo)
  val ate = mult(2, fo)
  println(ate)
  val sixfo = mult(2, fo, ate)
  println(sixfo)
  val oddsome = sumOdd(10)
  println(oddsome)
  greet(last="Stark", first="Tony")
  logTransaction(100.25, true, "USD")
  logTransaction(33.95)
  logTransaction(88.88, false, "NZD")


def square(x: Int): Int = x * x


def mult(x: Int, y: Int): Int = x * y


def mult(ns: Int*): Int = 
  var prod = 1
  for (n <- ns) prod *= n
  prod


def sumOdd(n: Int): Int =
  
  def getOdd(x: Int): Array[Int] =
    var res = Array[Int]()
    var cur = 1
    while (cur <= x) {
      if (cur % 2 == 1) res :+= cur
      cur += 1
    }
    res

  val odds = getOdd(n)
  println(odds.mkString(", "))
  odds.sum


def greet(first: String, last: String): Unit = 
  println("Hello! " + first + " " + last)


def logTransaction(amt: Double, debit: Boolean = true, currency: String = "USD"): Unit = 
  val symbol = if(debit) "-" else "+"
  println(symbol + currency + amt)