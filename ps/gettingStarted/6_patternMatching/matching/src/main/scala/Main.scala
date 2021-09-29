@main def hello: Unit = 
  var amount = 50

  amount match {
    case 50 => println("$50")
    case 100 => println("$100")
    case _ => println("other amount")
  }

  amount match {
    case a if a <= 50 => println("No more than $50")
    case b if b <= 100 => println("No more than $100")
    case _ => println("More than $100")
  }

  amount = 88
  val res: String = amount match {
    case a if a <= 50 => "No more than $50"
    case b if b <= 100 => "No more than $100"
    case _ => "More than $100"
  }

  println(amount)

  val cur: Currency = NZD()
  cur match {
    case u: USD => println("USD " + amount)
    case c: CAD => println("CAD " + (amount / 1.3))
    case n: NZD => println("NZD " + (amount / 1.5))
  }

  val arr = Array(100, 220, 333)
  arr match {
    case Array(_, second, _) => println("2nd: " + second)
  }

  val tup = ("NZD", 100)
  tup match {
    case (currency, amount) if currency == "USD" => println("USD " + amount)
    case (currency, amount) if currency == "NZD" => 
      println("NZD " + (amount / 1.5))
  }


abstract class Currency
case class USD() extends Currency
case class CAD() extends Currency
case class NZD() extends Currency