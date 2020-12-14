import scala.collection.mutable.ArrayBuffer


sealed trait Topping
case object Cheese extends Topping
case object Onions extends Topping
case object Sausage extends Topping
case object Mushrooms extends Topping
case object Pepperoni extends Topping

sealed trait Size
case object Small extends Size
case object Medium extends Size
case object Large extends Size

sealed trait Crust
case object Thin extends Crust
case object Thick extends Crust
case object Stuffed extends Crust


class Pizza(var size: Size=Medium, var crust: Crust=Thick) {
  val toppings = ArrayBuffer[Topping]()

  def addTopping(t: Topping): Unit = toppings += t
  def removeTopping(t: Topping): Unit = toppings -= t
  def removeAllToppings(): Unit = toppings.clear()

  override def toString(): String = {
    s"""
    |$size Pizza with $crust Crust with:
    |  $toppings
    """.stripMargin
  }
}


object PizzaTest extends App {
  val p = new Pizza
  p.addTopping(Cheese)
  p.addTopping(Pepperoni)
  p.addTopping(Sausage)
  println(p)
}
