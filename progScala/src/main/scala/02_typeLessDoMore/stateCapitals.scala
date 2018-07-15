val stateCapitals = Map(
  "Alabama" -> "Montgomery", "Alaska" -> "Juneau", "Virginia" -> "Richmond", "Wyoming" -> "Cheyenne")

println("Get the capitals wrappen in Options:")
println("Alabama: " + stateCapitals.get("Alabama"))   // Some(Montgomery)
println("Wyoming: " + stateCapitals.get("Wyoming"))   // Some(Cheyenne)
println("Disaster: " + stateCapitals.get("Disaster")) // None

println("Get the values of the capitals:")
println("Alabama: " + stateCapitals.get("Alabama").get)                        // Montgomery
println("Wyoming: " + stateCapitals.get("Wyoming").getOrElse("Oops!"))         // Cheyenne
println("Disaster: " + stateCapitals.get("Disaster").getOrElse("Oops again!")) // Oops again!
