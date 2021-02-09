package progscala3.introscala


object UpperMain1:
  def main(params: Array[String]): Unit =
    params.map(s => s.toUpperCase()).foreach(s => printf("%s ", s))
    println("")
  end main // optional line

  @main def hello(params: String*) = main(params.toArray) // alt entrypoint
end UpperMain1 // optional