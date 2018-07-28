val breeds = List("Doberman", "Rotweiler", "Collie", "Labrador", "Retreiver")
for (breed <- breeds if breed.contains("ei")) { println(breed) }
for (breed <- breeds if breed.contains("ei") if !breed.startswith("Rot")) { println(breed) }
for (breed <- breeds if breed.contains("ei") || breed.containes("ie")) { println(breed) }