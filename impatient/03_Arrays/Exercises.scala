object Exercises {
  def main(args: Array[String]) {
    val a = Array(0, 1, 2, 3, 4, 5, 6, 7);
    val b = swap(a);
  
    println(b.mkString(", "));
  }

  // 1.

  // 2.
  def swap(a: Array[Int]): Array[Int] = {
    for (i <- (0 until (a.length, 2))) {
      var temp = a(i);
      a(i) = a(i + 1);
      a(i + 1) = temp;
    }

    a;
  }

  // 3.
  def swap2(a: Array[Int]): Array[Int] = {
    val b = a;

    for (i <- (0 until (a.length, 2))) yield 
  }

}
