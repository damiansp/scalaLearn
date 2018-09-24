val stateCapitals = Map("Alabama" -> "Montgomery", "Alaska" -> "Juneau", "Wyoming" -> "Cheyenne")
val lengths = stateCapitals map { kv => kv._1, kv._2.length } // Alabama -> 10, Alaska -> 6, Wyoming -> 8
val caps = stateCapitals map { case (k, v) => (k, v.toUpperCase) } // Alabama -> MONTGOMERY ...

val stateCapitals2 = stateCapitals + ("Virginia" -> "Richmond")
val stateCapitals3 = stateCapitals2 + ("New York" -> "Albany", "Illinois" -> "Springfield")
