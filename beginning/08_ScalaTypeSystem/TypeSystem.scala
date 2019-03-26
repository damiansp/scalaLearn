import scala.collections.mutable.ListBuffer

object Traits {
  def main(args: Array[String]) {

  	val list = ListBuffer[Any]()
  	val x = 2
  	list += x


  	class Book
  	list += new Book()


  	def test(int: AnyVal) = ()
  	test(5)    // extends AnyVal
  	test(5.12) // ''       ''
  	//test(new Object) // extends AnyRef
  }
}