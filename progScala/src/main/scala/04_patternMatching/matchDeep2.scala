case class Address(street: String, city: String, country: String)
case class Person(name: String, age: Int, address: Address)

val alice = Person("Alice", 25, Address("1 Scala Ln", "Roma", "Italia"))
val bob = Person("Bob", 29, Address("2 Jalan Java", "Jakarta", "Indonesia"))
val charlie = Person("Charlie", 41, Address("3 Python Pl", "Montyshire", "England"))

for (person <- Seq(alice, bob, charlie)) {
  person match {
    case p @ Person("Alice", 25, address) => println(s"Hi Alice! $p")
    case p @ Person("Bob", 29, a @ Address(street, city, country)) => 
      println(s"Hi ${p.name}! age ${p.age}, in ${a.city}")
    case p @ Person(name, age, _) => println(s"Who are you, $age year-old person named $name? $p")
  }
}