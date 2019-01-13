case class Person(firstName: String, lastName: String, age: Int) {
  def description = s"$firstName $lastName is $age ${if (age == 1) "year" else "years"} old"
}

object Person {
  def filterAdult(people: List[Person]): List[Person] = {
    people.filter(_.age >= 18)
  }
}