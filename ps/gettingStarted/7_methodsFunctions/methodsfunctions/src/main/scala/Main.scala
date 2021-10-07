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
  println(transform(square, 1, 2, 3, 4, 5))
  println(transform(n: Int) => n * n, 1, 2, 3, 4, 5)
  println(transform(n => n * n * n, 1, 2, 3, 4, 5))
  val ns = Array(1, 2, 3, 4, 5, 6, 7)
  println(ns.map(n => 2 * n))
  val evens = ns.filter(n => n %2 == 0)
  println(evens)


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


def square(n: Int): Int = n * n

def cube(n: Int): Int = n * n * n

def transform(f: Int => Int, ns: Int*): Seq[Int] = ns.map(f)


def square(x: Int): Int = x * x


