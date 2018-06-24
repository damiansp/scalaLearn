//--------//--------//--------//--------//--------//--------//--------//--------//--------//--------
class Person(val name: String, var age: Int)

val p = new Person("Damian Phillips", 41)
println(p.name)
println(p.age)

//p.name = "Dr. D" // <- error: cannot reassign val

p.age = 42
println(p.age)
