object Functional {
	def main(args: Array[String]) {
		val add = (x: Int, y: Int) => x + y

		val areaOfRectangle: (Int, Int) => Int = (width: Int, height: Int) => width * height
		println(areaOfRectangle(5, 3))

		val doubler = (i: Int) => { i * 2 }
		println(doubler(2))

		def operation(functionParam: (Int, Int) => Int) { println(functionParam(4, 4)) }
		val mult = (x: Int, y: Int) => { x * y }
		operation(add)
		operation(mult)

		def greeting() = (name: String) => { s"hello, $name" }
		var greet = greeting()

		greet("Reader")


		/* Closure */
		var y = 3
		val multiplier = (x: Int) => x * y
		println(multiplier(3)) // 9


		/* Partially Applied */
		println(add(1, 3)) // 4
		val addOne = add(1, _: Int)
		println(addOne(7)) // 8


		/* Tail Calls and Tail Optimization */
		def factorial(n: Int): Int = {
			if (n == 1) return 1
			n * factorial(n - 1)
		}

		println(factorial(5))

		// With Incorrect Tail Recursion
		/*
		@annotation.tailrec
		def factorialTR(n: Int): Int = {
			if (n == 1) return 1
			n * factorialTR(n - 1)
		}

		println(factorialTR(5))
		*/

		// Correct
		@annotation.tailrec
		def factorialTR(accumulator: Int, n: Int): Int = {
			if (n == 1) return accumulator
			factorialTR(n * accumulator, n - 1)
		}

		println(factorialTR(1, 5))
	}

	// Call by name - evaluate String only if String is to be logged
	/*
	def log(level: Level, msg: => String) = 
		if (logger.level.intValue >= level.intValue) logger.log(level, msg)
	

	def allStrings(expr: => String): List[String] = expr match {
		case null => Nil
		case s => s :: allStrings(expr)
	}
	*/
}