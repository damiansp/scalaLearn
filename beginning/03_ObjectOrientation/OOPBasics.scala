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
  }
}

