// A procedure is a function with no return value
object Procedures {
  def main(args: Array[String]) {
    box("Hello, Sunshine");
    
    def box(s: String) { // same as: def box(s: String) : Unit = {
      val border = " --" + "-"  * s.length + " \n";
      println(border + "| " + s + " |\n" + border);
    }
  }
}

