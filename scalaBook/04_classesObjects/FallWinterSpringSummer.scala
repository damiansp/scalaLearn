import ChecksumAccumulator.calculate;

// Extending App obviates the need for a main()
object FallWinterSpringSummer extends App {
  for (season <- List("fall", "winter", "spring")) {
    println(season + ": " + calculate(season));
  }
}
