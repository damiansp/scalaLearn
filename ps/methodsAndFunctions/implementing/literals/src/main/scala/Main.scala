@main def hello: Unit = 
  var hundo = (x: Int) => x * 100
  println(hundo(3))
  println(hundo(7))

  var calculate = (x: Int, y: Int) => {
    val sum = x + y
    val diff = x - y
    val prod = x * y
    val quot = x / y
    (sum, diff, prod, quot)
  }
  println("10, 5:")
  println(calculate(10, 5))
  println("40, 8:")
  println(calculate(40, 8))

  val googStockPrices = List(136.7, 136.1, 139.4, 139.3, 140.4, 142.0, 143.0)
  googStockPrices.foreach((price: Double) => println(price))

  //val googStockPriceGreaterThan140 = googStockPrices.filter((price: double) => price > 140)
  //val googStockPriceGreaterThan140 = googStockPrices.filter(price => price > 140)
  val googStockPriceGreaterThan140 = googStockPrices.filter(_ > 140)
  println(googStockPriceGreaterThan140)

  val tickers = List("goog", "tsla", "aapl", "msft")
  val capTickers = tickers.map(_.toUpperCase)
  println(capTickers)

  val greet = () => println("Hello, function literal!")
  val add = (x: Int, y: Int) => x + y
  val add3 = (x: Int, y: Int, z: Int) => x + y + z

  greet()
  println(add(7, 9))
  println(add3(7, 9, 11))