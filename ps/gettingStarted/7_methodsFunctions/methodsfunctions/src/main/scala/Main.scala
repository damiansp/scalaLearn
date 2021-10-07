@main def hello: Unit = 
  println(transform(square, 1, 2, 3, 4, 5))
  println(transform(n: Int) => n * n, 1, 2, 3, 4, 5)
  println(transform(n => n * n * n, 1, 2, 3, 4, 5))
  val ns = Array(1, 2, 3, 4, 5, 6, 7)
  println(ns.map(n => 2 * n))
  val evens = ns.filter(n => n %2 == 0)
  println(evens)


def square(n: Int): Int = n * n

def cube(n: Int): Int = n * n * n

def transform(f: Int => Int, ns: Int*): Seq[Int] = ns.map(f)