val DATA = "/Users/damiansp/Learning/marketModeling/data"


@main def main: Unit = 
  val readFinanceData = () => {
    val source = io.Source.fromFile(s"$DATA/sp1950.csv")
    for {
      line <- source.getLines().drop(1).toVector
      cols = line.split(",").map(_.trim)
    } yield StockRecord(cols(0).toFloat, 
                        cols(1).toFloat, 
                        cols(2).toFloat, 
                        cols(3).toFloat, 
                        cols(4).toFloat, 
                        cols(5).toDouble, 
                        cols(6))
  }
  var data = readFinanceData()
  val getNRows = () => data.size
  val getAvgCloseVal = () => data.map(_.close).sum / data.size
  val getMinCloseVal = () => data.map(_.close).min
  val getMaxCloseVal = () => data.map(_.close).max
  val getCloseValOnDate = (d: String) => {
    val filteredClose = data.filter(_.date == d)
    filteredClose.map(_.close).head
  }
  val priceDelta = (_: Double) - (_: Double)
  val getDailyDelta = (
      open: Double, close: Double, delta: (Double, Double) => Double) => 
    delta(open, close)

  println(s"Data set size: ${getNRows()}")
  println(s"Mean close: ${getAvgCloseVal()}")
  println(s"Min close: ${getMinCloseVal()}")
  println(s"Max close: ${getMaxCloseVal()}")

  val date = "2020-01-03"
  println(s"Close val. on $date: ${getCloseValOnDate(date)}")

  val record = data.filter(_.date == date)
  println(s"Delta on $date:") 
  println(getDailyDelta(record(0).open, record(0).close, priceDelta))


case class StockRecord(
    open: Float, high: Float, low: Float, close: Float, adjClose: Float, volume: Double, date: String)