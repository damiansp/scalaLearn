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

	}
}