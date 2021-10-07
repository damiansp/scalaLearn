import scala.language.implicitConversions


case class Currency(code: String, amt: Double, inUSD: Double)


object Implicits extends App {
  implicit def stringToCurrency(money: String): Currency = {
    val Array(code: String, value: String) = money.split("\\s")
    val amtAsDouble = value.toDouble
    code match {
      case "USD" => Currency("USD", amtAsDouble, amtAsDouble)
      case "NZD" => Currency("NZD", amtAsDouble, amtAsDouble / 1.5)
      case "CAD" => Currency("CAD", amtAsDouble, amtAsDouble / 1.3)
    }
  }

  println(stringToCurrency("USD 100"))
  println(stringToCurrency("NZD 100"))
  println(stringToCurrency("CAD 100"))
  val cad: Currency = "CAD 555"
  println(cad)
}
