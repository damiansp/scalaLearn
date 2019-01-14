object Functional {
	def main(args: Array[String]) {
		val add = (x: Int, y: Int) => x + y

		val areaOfRectangle: (Int, Int) => Int = (width: Int, height: Int) => width * height
		println(areaOfRectangle(5, 3))
	}
}