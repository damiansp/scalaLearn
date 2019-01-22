object Functional {
  def main(args: Array[String]) {
  	def printNum(int: Int) {
  		int match {
  			case 0 => println("Da big Zero")
  			case 1 => println("The one and only")
  			case _ => println("And anudder number")
  		}
  	}

	 	printNum(1)
	 	printNum(9)


	 	def fibonacci(n: Int): Int = n match {
	 		case 0 => 0
	 		case 1 => 1
	 		case n => fibonacci(n - 1) + fibonacci(n - 2)
	 	}

	 	println(fibonacci(8))
  }
}