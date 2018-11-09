object Functions {
	def main(args: Array[String]) {
		def hello() = { "Hello, World!" }
		println(hello)
		println(hello())

		def hello2(): String = { "Hello, World!" }
		println(hello2)

		def hello3 = "Hello, World!"
		println(hello3)

		def square(i: Int) = i * i
		println(square(3))

		def add(x: Int, y: Int) = x + y
		println(add(3, 4))		
	}
}