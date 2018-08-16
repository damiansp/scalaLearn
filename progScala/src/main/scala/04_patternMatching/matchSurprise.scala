// Bad code: y in body acts like default and will match anything
def checkY(y: Int) = {
  for x <- Seq(99, 100, 101) {
    val str = x match {
      case y      => "found y!"
      case i: Int => "int: " + i
    }
    println(str)
  }
}

// Should be:
def checkY(y: Int) = {
  for x <- Seq(99, 100, 101) {
    val str = x match {
      case `y`    => "found y!"
      case i: Int => "int: " + i
    }
    println(str)
  }
}