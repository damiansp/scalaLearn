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
	}
}