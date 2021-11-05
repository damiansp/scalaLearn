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
    pintln("Initialization complete")

  val bob = Human("Bob", "Dobolina")
  bob.printFullName


  class Socket(val timeout: Int=5_000, val linger:Int=5_000):
    override def toString = s"timeout: $timeout, linger: $linger"

  val s = Socket()
  val s2 = Socket(2_500)
  val s3 = Socket(10_000, 3_000)
  val s4 = Socket(linger=7_000)


  // Aux constructors