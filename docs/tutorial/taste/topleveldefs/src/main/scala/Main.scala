import scala.collection.mutable.ArrayBuffer


enum Topping:
  case Cheese, Pepperoni, Mushrooms

import Topping.*


class Pizza:
  val toppings = ArrayBuffer[Topping]()

extension (s: String)
  def capitalizeAllWords = s.split(" ").map(_.capitalize).mkString(" ")

val p =  Pizza()
val hwUpper = "hello, world!".capitalizeAllWords

type Money = BigDecimal


@main def main: Unit = 
  p.toppings += Cheese
  println("show me the code".capitalizeAllWords)