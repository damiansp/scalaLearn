@main def hello: Unit = 
  val volume = 1000
  var stockPrice = 79
  println(s"Volume: $volume")
  println(s"Stock price: $stockPrice")
  stockPrice -= 1
  
  def getValue: Int = volume * stockPrice
  
  val value = getValue
  println(s"Value: $value")

  val face = 5
  lazy val lazyFace = 5

  var data = {
    println("Array initialized")
    Array("MSFT", "GOOG", "TM")
  }

  println("----------------------")
  data.foreach(println)

  val moreData = Array("MSFT", "GOOG", "TM")
  data(0) = "AAPL"
  data(2) = "TSLA"
  moreData.foreach(println)
  

