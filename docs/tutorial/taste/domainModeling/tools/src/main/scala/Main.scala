import java.time.*
import scala.math.*


@main def hello: Unit = 
  // Classes
  class Person(var name: String, var vocation: String)
  class Book(var title: String, var author: String, var year: Int)
  class Movie(var name: String, var director: String, var year: Int)

  val p = Person("Bob Dobolina", "Larpist")
  println(p.name)
  println(p.vocation)

  p.name = "Bob Dylan"
  p.vocation = "Singer-Songwriter"

  
  class Human(var name: String, var surname: String):
    println("Initializing human...")
    val fullName = name + " " + surname

    def printFullName: Unit =
      println(fullName)

    printFullName
    println("Initialization complete")

  val bob = Human("Bob", "Dobolina")
  bob.printFullName


  class Socket(val timeout: Int=5_000, val linger:Int=5_000):
    override def toString = s"timeout: $timeout, linger: $linger"

  val s = Socket()
  val s2 = Socket(2_500)
  val s3 = Socket(10_000, 3_000)
  val s4 = Socket(linger=7_000)


  // Aux constructors
  class Student(var name: String, var gid: String):
    private var _appDate: Option[LocalDate] = None
    private var _sid: Int = 0

    def this(name: String, gid: String, appDate: LocalDate) =
      this(name, gid)
      _appDate = Some(appDate)

    def this(name: String, gid: String, sid: Int) = 
      this(name, gid)
      _sid = sid

  val st1 = Student("Rob", "123")
  val st2 = Student("Rob", "123", LocalDate.now)
  val st3 = Student("Rob", "123", 456)


  // Objects (classes with only a single instance)
  object StringUtils:
    def truncate(s: String, length: Int): String = s.take(length)
    def containsWhitespace(s: String): Boolean = s.matches(".*\\s.*")
    def isNullOrEmpty(s: String): Boolean = s == null || s.trim.isEmpty

  println(StringUtils.truncate("Bobby Dobolini", 5))

  import StringUtils.*
  println(isNullOrEmpty("JC Jenkins"))

  //import StingUtils.{truncate, containsWhitespace} // import just some


  object MathConstants:
    val PI = 3.14159
    val E = 2.71828

  println(MathConstants.PI)


  // Companion Objects (obj w same name as class and defined in same file)
  case class Circle(r: Double):
    def area: Double = Circle.calculateArea(r)

  object Circle:
    private def calculateArea(r: Double): Double = Pi * pow(r, 2.0)

  val c1 = Circle(5.0)
  println(c1.area)


  // Other uses