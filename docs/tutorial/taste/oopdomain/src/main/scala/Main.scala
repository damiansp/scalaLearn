@main def hello: Unit = 
  oop()
  fp()


def oop(): Unit =
  val d = Dog("Rover")
  println(d.speak())

  val c = Cat("Morris")
  println(c.speak())
  c.run()
  c.stopRun()

  val p = Person("Bob", "Dobolina")
  println(p.name)
  p.printFullName()


trait Speaker:
  def speak(): String // no body; abstract


trait TailWagger:
  def wag(): Unit = println("Tail is wagging")
  def stopWag(): Unit = println("Not wagging")


trait Runner:
  def run(): Unit = println("Running")
  def stopRun(): Unit = println("Stopped running")


class Dog(name: String) extends Speaker, TailWagger, Runner:
  def speak(): String = "Woof!"


class Cat(name: String) extends Speaker, TailWagger, Runner:
  def speak(): String = "Meow"
  override def run(): Unit = println("Nope.  I ain't runnnin'")
  override def stopRun(): Unit = println("Stop what, now?")


class Person(var name: String, var surname: String):
  def printFullName() = println(s"$name $surname")


def fp(): Unit = 
  import Size.*

  val size = Small
  size match
    case Small => println("A small a-pizza")
    case Medium => println("A medium a-pizza")
    case Large => println("A large a-pizza")
  if size == Small then println("That pizza is just itty bitty")

  val h = Human("Bob Dobolina", "Bobber and Weaver")
  println(h)
  println(h.name)
  //h.name = Joe // error: params are val by default, cannot mutate

  val h2 = h.copy(name="Elton John")
  println(h2)


enum Size:
  case Small, Medium, Large


enum Crust:
  case Thin, Thick, Stuffed


enum Topping:
  case Cheese, Pepperoni, Olives, Onions, Sausage


case class Human(name: String, vocation: String)