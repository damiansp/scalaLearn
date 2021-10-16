@main def hello: Unit = 
  val name = "Bob"
  val mi = 'J'
  val surname = "Dobolina"
  println(s"Calling Mr $name $mi. $surname")
  println(s"2 + 2 = ${2 + 2}")
  val multiline = """Eriam J H
                     |the ghost
                     |in the machine.""".stripMargin
  println(multiline)
