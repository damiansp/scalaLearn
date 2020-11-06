package progscala3.introscala

object UpperMain2 {
  def main(params: Array[String]): Unit = {
    val output = params.map(_.toUpperCase()).mkString(" ")
    println(output)
  }
}
