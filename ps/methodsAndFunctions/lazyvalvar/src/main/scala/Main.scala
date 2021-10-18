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

