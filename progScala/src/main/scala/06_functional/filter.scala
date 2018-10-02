val stateCapitals = Map("Alabama" -> "Montgomery", "Alaska" -> "Juneau", "California" -> "Sacramento")
val aCaps = stateCapitals filter { kv => kv._1 startsWith "A" }

/* Similar
 * drop(n) // drops the first n elements
 * dropWhile(p)
 * exists(p)
 * filterNot
 * find
 * forall
 * partition
 * takeWhile
 */
 