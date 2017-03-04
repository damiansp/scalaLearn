object FixedLength {
  def main(args: Array[String]) {
    val numw = new Array[Int](10); // Array of 10 ints, init to 0
    val a = new Array[String](10); // 10 strings, init to null
    val s = Array("Hello", "World"); // no new needed
    s(0) = "Goodbye";
  }
}
