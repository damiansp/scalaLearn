@main def hello: Unit = 
  val a = List(1, 2, 3).map(i => 2 * i)
  val b = List(1, 2, 3).map(2 * _)
  val a2 = List(1, 2, 3).map(i => double(i))
  val b2 = List(1, 2, 3).map(double)
  val ns = (1 to 10).toList
  val x = ns.filter(_ > 3).filter(_ < 7).map(10 * _)
  println(a2)
  println(b2)
  println(x)

def double(i: Int): Int = 2 * i