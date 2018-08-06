object Breed extends Enumeration {
	type Breed = Value
	val doberman = Value("Doberman Pinscher")
	val yorkie = Value("Yorkshire Terrier")
	val scottie = Value("Scottish Terrier")
	val dane = Value("Great Dane")
	val portie = Value("Portuguese Water Dog")
}

import Breed._

// Print list of breeds and IDs
println("ID\tBreed")
for (breed <- Breed.values) println(s"${breed.id}\t$breed")

// print just terrier breeds
println("\nJust Terriers:")
Breed.values filter (_.toString.endsWith("Terrier")) foreach println

def isTerrier(b: Breed) = b.toString.endsWith("Terrier")

println("\nTerriers again...")
Breed.values filter isTerrier foreach println



object WeekDays extends Enumeration {
	type = WeekDay = Value
	val Mon, Tue, Wed, Thu, Fri, Sat, Sun = Value
}

import WeekDay._

def isWorkingDay(d: WeekDay) = !(d == Sat || d == Sun)

WeekDay.values filter isWorkingDay foreach println

