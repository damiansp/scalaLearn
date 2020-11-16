object Upper {
  def upper(strings: String*): Seq[String] = {
    strings.map((s: String) => s.toUpperCase())
  }

  def upper2(strings: String*) = strings.map(_.toUpperCase())
}

println(Upper.upper("hello", "world!"))
println(Upper.upper2("and", "goodbye."))