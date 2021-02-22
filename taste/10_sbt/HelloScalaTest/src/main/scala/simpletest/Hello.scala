package simpletest


object Hello extends App {
  val p = new Person("Bob Dobolina")
  println(s"Hello, ${p.name}")
}


class Person(var name: String)