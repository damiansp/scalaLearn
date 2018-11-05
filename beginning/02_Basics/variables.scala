object Variables {
  def main(args: Array[String]) {
    val x = 10
    var y = 10
    println(x * x)
    y = 11
    //y = 10.5 // error type mismatch

    lazy val z = 1.0e21 * 1.0331


    /* Numeric Types */
    val b: Byte = 30
    val s: Short = b
    val d: Double = s


    /* Boolean Type */
    val f = !false
    println(f)


    /* Char */
    val c = 'X'


    /* Unit type */
    val empty = ()


    /* Strings */
    val hello = "Hello"
    val title = "Scala"
    println(s"I am learning ${title}")
  }
}
