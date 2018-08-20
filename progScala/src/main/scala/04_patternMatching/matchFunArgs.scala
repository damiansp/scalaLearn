case class Address(street: String, city: String, country: String)
case class Person(name: String, age: Int)

val as = Seq(Address("1 Scala St", "Anytown", "USA"), Address("2 Clojure Ct", "Othertown", "USA"))
val ps = Seq(Person("Buck Trends", 29), Person("Joe Clure", 28))
val pas = ps zip as

// Ugly way:
pas map { tup =>
	val Person(name, age) = tup._1
	val Address(street, city, country) = tup._2
	s"$name (age: $age) lives at $street, $city, in $country"
}

// Nicer:
pas map {
	case (Person(name, age), Address(street, city, country)) =>
	s"$name (age: $age) lives at $street, $city, in $country"
}