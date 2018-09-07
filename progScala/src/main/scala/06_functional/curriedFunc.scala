// Curried or "Partially applied functions"
def cat1(s1: String)(s2: String) = s1 + s2

val hello = cat1("Hello ") _

// NOTE:
//val hello = cat1("Hello ") // ERROR
println(hello("World!")) // "Hello World!"
println(cat1("Hello ")("World!")) // same


// "Partial function"
val inverse: PartialFunction[Double, Double] = {
	case d if d != 0.0 => 1.0 / d
}