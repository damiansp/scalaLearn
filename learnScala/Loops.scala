// Basic for loop
for (x <- 1 to 7) { println(s"Day $x:") }

// Yield generates a collection of the return values
val days = for (x <- 1 to 7) yield { s"Day $x:" }

// Iterator guards (filters)
val threes = for(i <- 1 to 20 if i % 3 == 0) yield i
val quote = "Faith,Hope,,Charity"

for {
  t <- quote.split(",")
  if t != null
  if t.size > 0
} { println(t) }

// Nested iterators
for {
  x <- 1 to 3
  y <- 1 to 4
} { print(s"($x, $y)") }

// Value binding
val powersOf2 = for (i <- 0 to 8; pow = 1 << i) yield pow

// While, do/while
var x = 10
while (x > 0) x -= 1

val y = 0
do println(s"\nHere I am, x = $x") while (x > 0)