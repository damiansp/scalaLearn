import scala.math.*


@main def hello: Unit = 
  val x = StringUtils.isNullOrEmpty("")
  println(x) // true
  val y = StringUtils.isNullOrEmpty("a")
  println(y) // false

  val c1 = Circle(5.0)
  println(c1.area) // 78.539...

  import MathService.*
  println(add(1, 1))
  println(multiply(2, 2))


// utility methods
object StringUtils:
  def isNullOrEmpty(s: String): Boolean = s == null || s.trim.isEmpty
  def leftTrim(s: String): String = s.replaceAll("^\\s+", "")
  def rightTrim(s: String): String = s.replaceAll("\\s+$", "")


// Companion objects (can access private members of companion obj/class)
class Circle(radius: Double):
  import Circle.*
  def area: Double = calculateArea(radius)

object Circle:
  private def calculateArea(radius: Double): Double = Pi * pow(radius, 2.0)


// modules from traits
trait AddService:
  def add(a: Int, b: Int) = a + b

trait MultService:
  def multiply(a: Int, b: Int) = a * b

object MathService extends AddService, MultService