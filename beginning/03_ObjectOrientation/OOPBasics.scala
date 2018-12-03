object Variables {
  def main(args: Array[String]) {
  	class Shape {
  		def area: Double = 0.0
  	}
  }


  def Rectangle(val width: Double, val height: Double) extends Shape {
  	override def area: Double = width * height
  }


  def Circle(val radius: Double) extends Shape {
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

}

