// Lists, Sets, Maps
val numbers = List(1, 1, 2, 3, 5, 8, 13)
val colors = List("red", "green", "blue")

println(s"I have ${colors.size} colors: $colors")
println(colors.head)
println(colors.tail)
println(colors(1))

var total = 0

for (i <- numbers) { total += i }
for (c <- colors) { println(c) }
colors.foreach((c: String) => println(c))

val sizes = colors.map((c: String) => c.size)
val total2 = numbers.reduce((a: Int, b: Int) => a + b)

val unique = Set(10, 20, 30, 20, 20, 10)
val sum = unique.reduce((a: Int, b: Int) => a + b)

val colorMap = Map("red" -> 0xFF0000, "green" -> 0xFF00, "blue" -> 0xFF)
val redRGB = colorMap("red")
val cyanRGB = colorMap("green") | colorMap("blue")
val hasWhite = colorMap.contains("white")

for (pairs <- colorMap) { println(pairs) }



// What's in a List?
val oddsAndEvens = List(List(1, 3, 5), List(2, 4, 6))
val keyValList = List(('A', 65), ('B', 66), ('C', 67))
val primes = List(1, 2, 3, 5, 7, 11, 13)
val first = primes(0)
var i = primes

while (! i.isEmpty) {
  print(i.head + ", ")
  i = i.tail
}

def visit(i: List[Int]): Unit = {
  if (i.size > 0) {
    print(i.head + ", ")
    visit(i.tail)
  }
}

visit(primes)

i = primes
while (i != Nil) {
  print(i.head + ", ")
  i = i.tail
}

val l: List[Int] = List()
l == Nil // true

val m: List[String] = List("a")
println(m.head) // a
m.tail == Nil // true



// The Cons(truct) Operator :: for List building
val numbs = 1 :: 2 :: 4 :: Nil
val frst = Nil.::(1)

println(frst.tail == Nil) // true -- first is List(1)

val second = 2 :: frst
println(second.tail == frst) // true



// List Arithmetic
// ::   - append to List
val ot = List(1) :: List(2) // ((1), (2))
println(ot)

// :+   - append to List
println(List(1, 2, 3, 4) :: List(5)) // ((1, 2, 3, 4), 5)
println(List(1, 2, 3, 4) :+ 5)       // (1, 2, 3, 4, 5)

// :::   - prepend List to List
val ll = List(1, 2) ::: List(2, 3)
println(ll)

// ++   - append another collection to List
val ls = List(1, 2) ++ Set(3, 4, 3)
println(ls)

// ==   - check for equality
println(List(1, 2) == List(1, 2))

// others
println(List(3, 5, 4,3, 4).distinct)
println(List('a', 'b', 'c', 'd') drop 2)      // ('c', 'd')
println(List('a', 'b', 'c', 'd') dropRight 2) // ('a', 'b')
println(List(23, 8, 14, 21) filter (_ > 18))
println(List(List(1, 2), List(3, 4)).flatten) // List(1, 2, 3, 4)
println(List(1, 2, 3, 4, 5) partition (_ < 3)) // ((1, 2), (3, 4, 5))
println(List(1, 2, 3, 4).reverse)
println(List(2, 3, 5, 7).slice(1, 3))          // (3, 5)
println(List("apple", "to", "eat") sortBy (_.size))
println(List("apple", "to", "eat").sorted)
println(List(2, 3, 4, 5, 7) splitAt 2)         // ((2, 3), (4, 5 7))
println(List(2, 3, 5, 7, 11, 13) take 3)       // (2, 3, 5)
println(List(2, 3, 5, 7, 11, 13) takeRight 3)  // (7, 11, 13)
println(List(1, 2) zip List("a", "b"))         // ((1, "a"), (2, "b"))



// Mapping Lists
println(List(0, 1, 0) collect { case 0 => "ok" }) // ("ok", "ok")
println(List("milk, tea") flatMap (_.split(','))) // ("milk", "tea")
println(List("milk", "tea") map (_.toUpperCase))



// Reducing Lists
println(List(51, 59, 26).max)
println(List(51, 59, 26).min)
println(List(2, 3, 4, 5).product)
println(List(2, 3, 4, 5).sum)
println(List(23, 34, 45) contains 29)
println(List(0, 4, 3) endsWith List(4, 3))
println(List(24, 17, 32) exists (_ < 18))
println(List(24, 17, 32) forall (_ < 18))
println(List(0, 4, 3) startsWith List(0))

println(List(4, 5, 6).fold(0)(_ + _)) // 15
println(List(4, 5, 6).foldLeft(0)(_ + _))
println(List(4, 5, 6).foldRight(0)(_ + _))
println(List(4, 5, 6).reduce(_ + _))
println(List(4, 5, 6).reduceLeft(_ + _))
println(List(4, 5, 6).reduceRight(_ + _))
println(List(4, 5, 6).scan(0)(_ + _))     // (0, 4, 9, 15)
println(List(4, 5, 6).scanLeft(0)(_ + _)) // (0, 4, 9, 15)
println(List(4, 5, 6).scanRight(0)(_ + _)) // (15, 11, 6, 0)
