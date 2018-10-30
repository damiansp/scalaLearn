object Variables {
  def main(args: Array[String]) {
    val x = 10
    var y = 10
    println(x * x)
    y = 11
    //y = 10.5 // error type mismatch
  }
}
