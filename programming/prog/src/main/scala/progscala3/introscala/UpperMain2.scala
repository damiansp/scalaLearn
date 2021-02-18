package progscala3.inotroscala

object UpperMain2:
  def main(params: Array[String]): Unit = 
    val output = params.map(_.toUpperCase()).mkString(" ")
    println(output)
