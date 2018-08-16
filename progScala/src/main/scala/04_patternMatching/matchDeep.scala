case class Address(street: String, city: String, country: String)
case class Person(name: String, age: Int, address: Address)

val alice   = Person("Alice",   25, Address("1 Scala Ln", "Chicago", "USA"))
val bob     = Person("Bob",     29, Address("2 Java Ave", "Sunnyvale", "USA"))
val charlie = Person("Charlie", 41, Address("3 Pyton Blvd", "Portland", "USA"))

for (person <- Seq(alice, bob, charlie)) {
	person match {
		case Person("Alice", 25, Address(_, "Chicago", _)) => println("That's our Alice!")
		case Person("Bob", 29, Address("2 Java Ave", "Sunnyvale", "USA")) => println("Hi, Bob!")
		case Person(name, age, _) => println(s"Where are you from, $age-year-old $name?")
	}
}


val itemsCost = Seq(("pencil", 0.52), ("paper", 0.35), ("notebook", 2.43))
val itemCostIndices = itemsCost.zipWithIndex
for (itemCostIndex <- itemCostIndices) {
	itemCostIndex match {
		case ((item, cost), index) => println(s"$index: $item costs $cost each")
	}
}