import scala.io.StdIn.readLine


object HelloInteractive extends App {
  print("Enter your first name: ")
  val name = readLine()
  print("And surname: ")
  val surname = readLine()
  println(s"Well, hello there, $name $surname")
}