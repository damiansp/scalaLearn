object Upper2:
  def convert(strings: Seq[String]) = strings.map(_.toUpperCase())

println(Upper2.convert(List("hello", "world!")))