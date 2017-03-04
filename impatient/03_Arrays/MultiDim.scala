object MultiDim {
  def main(args: Array[String]) {
    val matrix = Array.ofDim[Double](3, 4); // 3 rows, 4 cols
    matrix(2)(3) = 34;

    // Ragged Arrays ok
    val triangle = new Array[Array[Int]](10);
    for (i <- 0 until triangle.length) {
      triangle(i) = new Array[Int](i + 1)
    }
  }
}
