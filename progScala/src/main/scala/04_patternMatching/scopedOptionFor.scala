case class Address(street: String, city: String, country: String)
case class Person(name: String, age: Int, address: Address)

val Person(name, age, Address(_, state, _)) = Person("Dean", 29, Address("1 Scala St", "CA", "USA"))
val head +: tail = List(1, 2, 3)
val head1 +: head2 +: tail2 = Vector(1, 2, 3)
val Seq(a, b, c) = List(1, 2, 3)
//val Seq(a, b, c) = List(1, 2, 3, 4) // Match error

val p = Person("Dean", 29, Address("1 Scala St", "CA", "USA"))
if (p == Person("Dean", 29, Address("1 Scala St", "CA", "USA"))) "yep" else "nope"
if (p == Person("Dean", 29, Address("1 Scala St", "CA", "USSR"))) "yep" else "nope"
//if (p == Person(_, 29, Address(_, _, "USA"))) "yep" else "nope" // error: missing param type

def sumCount(ints: Seq[Int]) = (ints.sum, ints.size)
val (sum, count) = sumCount(List(1, 2, 3, 4, 5)) // (15, 5)

val dogs = Seq(
	Some("Doberman"), None, Some("Yorkshire Terrier"), Some("Dachshund"), None, 
	Some("Scottish Terrier"), None, Some("Great Dane"), Some("Water Dog"))
for {
	Some(breed) <- dogs
	upBreed = breed.toUpperCase()
} println(upBreed)

