val bools = Seq(true, false)

for (bool <- bools) {
  bool match {
    case true => println("Got Heads")
    case false => println("Got Tails")
  }
}