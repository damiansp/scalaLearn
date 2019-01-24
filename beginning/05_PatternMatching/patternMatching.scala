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

    // with guards
    def fib2(n: Int): Int = n match {
      case n if n <= 0 => 0
      case 1 => 1
      case n => fib2(n - 1) + fib2(n - 2)
    }


    // matching Any
    val anyList = List(1, "Ah", 2, 2.5, 'a')
    for (m <- anyList) { 
      m match {
        case i: Int    => println("Integer: " + i)
        case s: String => println("String: " + s)
        case f: Double => println("Double: " + f)
        case other     => println("Other: " + other)
      }
    }

    // Testing Data Types
    def test(in: Any) = in match {
      case s: String       => "String, length " + s.length
      case i: Int if i > 0 => "Natural number"
      case i: Int          => "(Non-natural) Integer"
      case a: AnyRef       => a.getClass.getName
      case _               => "null"
    }

    val x = 1
    val rest = List(2, 3, 4)
    println(x :: rest)
  }
}