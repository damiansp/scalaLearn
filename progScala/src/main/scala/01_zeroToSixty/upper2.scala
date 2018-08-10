package zeroToSixty;

object Upper2 {
  def main(args: Array[String]) = {
    val output = args.map(_.toUpperCase()).mkString(" ");
    println(output);
  }
}
