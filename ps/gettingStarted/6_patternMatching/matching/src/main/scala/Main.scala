@main def hello: Unit = 
  val amount = 50

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