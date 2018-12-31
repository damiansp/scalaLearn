object Variables {
  def main(args: Array[String]) {
  	class Shape {
  		def area: Double = 0.0
  	}
  


    class Rectangle(val width: Double, val height: Double) extends Shape {
    	override def area: Double = width * height
    }


    class Circle(val radius: Double) extends Shape {
    	override def area: Double = math.Pi * radius * radius
    }


  	//def draw(s: Shape) { /*...*/ }

  	//val circle = draw(new Circle(3))
  	//val rectangle = draw(new Rectangle(2, 3))



  	/* Classes and Objects */
  	class Book(title: String) // "public" by default, no getters or setters
    val book = new Book("Basics")
    //println(book.title) // error

  	/* Constructors */
    // val params: getter generated
    class BookVal(val title: String)

    // var params: getter and setter/mutator generated
    class BookVar(var title: String)
    val bookvar = new BookVar("My Book")
    bookvar.title = "Other book"

    class BookPrivate(private var title: String) {
      def printTitle {
        println(title)
      }
    }
    val bookpriv = new BookPrivate("Private Book")
    bookpriv.printTitle

    abstract class Base {
      def thing: String
    }

    class One extends Base {
      def thing = "Moo"
    }

    class Two extends One {
      override val thing = (new java.util.Date ).toString
    }

    class Three extends One {
      override lazy val thing = super.thing + (new java.util.Date ).toString
    }


    /* Code blocks */
    def meth1() = "Hello, World!"

    def meth2() = { "Oink" }
    def meth3(): String = {
      val d = new java.util.Date()
      d.toString
    }

    val x: String = {
      val d = new java.util.Date()
      d.toString
    }


    /* Call-by-name */
    def nano() = {
      println("Getting nano...")
      System.nanoTime
    }

    // t is called by name
    def delayed(t: => Long) = {
      println("In delayed method")
      println("Param: " + t)
      t
    }

    def notDelayed(t: Long) = {
      println("In not delayed method")
      println("Param: " + t)
      t
    }

    println(delayed(nano()))
    println(notDelayed(nano()))


    class Vehicle(speed: Int) {
      val mph: Int = speed
      def race() = println("Racing")
    }

    /* Extending class */
    class Car(speed: Int) extends Vehicle(speed) {
      override val mph: Int = speed
      override def race() = println("Racing Car")
    }

    class Bike(speed: Int) extends Vehicle(speed) {
      override val mph: Int = speed
      override def race() = println("Racing Bike")
    }

    val vehicle1 = new Car(200)
    println(vehicle1.mph)
    vehicle1.race

    val vehicle2 = new Bike(47)
    println(vehicle2.mph)
    vehicle2.race

    /* Traits */
    trait flying {
      def fly() = println("flying")
    }

    trait floating {
      def float() = println("gliding")
    }

    class Batmobile(speed: Int) extends Vehicle(speed) with flying with floating {
      override val mph: Int = speed
      override def race() = println("Racing Batmobile")
      override def fly() = println("Flying Batmobile")
      override def float() = println("Gliding Batmobile")
    }

    val vehicle3 = new Batmobile(300)
    vehicle3.fly()

    val vehicleList = List(vehicle1, vehicle2, vehicle3)
    val fastestVehicle = vehicleList.maxBy(_.mph)
    println("Fastest:", fastestVehicle)


    /* Case Classes */
    case class Stuff(name: String, age: Int)

    val s = Stuff("David", 45)
    println(s.toString)
    println(s.name)

    class Things(val name: String, val age: Int) {
      override def toString = "Stuff(" + name + ", " + age + ")"
      override def hashCode = name.hashCode + age
      override def equals(other: AnyRef) = other match {
        case t: Things => this.name == t.name && this.age == t.age
        case _         => false
      }
    }

    object Things {
      def apply(name: String, age: Int) = new Things(name, age)
      def unapply(t: Things) = Some((t.name, t.age))
    }


    /* Value Classes */
    class SomeClass(val i: Int) extends AnyVal {
      def twice() = 2*i
    }

    val v = new SomeClass(9)
    println(v.twice)


  }
}

