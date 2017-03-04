
object Traversing {
  def main(args: Array[String]) {
    val a = Array(0, 1, 2, 3, 4, 5, 6);

    for (i <- 0 until a.length) { // i <- 0 to a.length - 1
      println(i + ": " + a(i));
    }

    // every 2nd element
    for (i <- 0 until (a.length, 2)) {
      println(i + ": " + a(i));
    }

    // traverse backwards
    for (i <- (0 until a.length).reverse) {
      println(i + ": " + a(i));
    }

    // traverse elements instead of indices
    for (elem <- a) {
      println(elem);
    }
  }
}
