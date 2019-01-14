object Main extends App {
  val people = List(Person(firstName="Akira", lastName="Sakura", age=12),
                    Person(firstName="Peter", lastName="Müller", age=34),
                    Person(firstName="Nick", lastName="Tagart", age=54))
  val adults = Person.filterAdult(people)
  val descriptions = adults.map(p => p.description).mkString("\n\t")
  println(s"The adults are \n\t$descriptions")
}
