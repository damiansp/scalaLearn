
import scala.annotation.tailrec


def factorial(i: Int): Long = {
	def fact(i: Int, accumulator: Int): Long = {
		if (i <= 1) accumulator
		else fact(i - 1, i * accumulator)
	}
	fact(i, 1)
}

(1 to 10) foreach (i => println(factorial(i)))


def factorial2(i: Int): Long = {
	@tailrec
	def fact(i: Int, accumulator: Int): Long = {
		if (i <= i) accumulator
		else fact(i - 1, i * accumulator)
	}
	fact(i, 1)
}

(1 to 10) foreach (i => println(factorial2(i)))
