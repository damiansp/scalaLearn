object MethodsAndFunctions extends App {
  val data = Array("PS", "MSFT", "GOOG", "AAPL", "TSLA")
  val getNRowsFunction = () => data.length

  def getNRowsMethod: Int = data.length

  println("Total no. rows (method): " + getNRowsMethod)
  println("Total no. rows (func): " + getNRowsFunction())


  def existsMethod(ticker: String): Boolean = data.contains(ticker)

  val existsFunc = (ticker: String) => data.contains(ticker)
  val exists = existsMethod _

  println("PS exists? (method): " + existsMethod("PS"))
  println("TM exists? (func): " + existsFunc("TM"))
  println("GOOG exists? (converted method): " + exists("GOOG"))
}


