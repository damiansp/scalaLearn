object MapConstruction {
  def main(args: Array[String]) {
    /* Construction ----------------------------------------------- */
    // Construct an immutable map
    val fixedScores = Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8); // OR:
    val fixedScores2 = Map(("Alice", 10), ("Bob", 3), ("Cindy", 8));

    // Construct a mutable map
    val scores = scala.collection.mutable.Map(
      "Alex" -> 10, "Beth" -> 3, "Chuck" -> 8);

    // Starting with a blank map: supply params
    val noScores = new scala.collection.mutable.HashMap[String, Int];



    /* Accessing Values ------------------------------------------- */
    val bobScore = fixedScores("Bob");
    val aliceScore = if (fixedScores.contains("Alice")) {
      fixedScores("Alice")
    } else { 0; };
    
    val cindyScore = fixedScores.getOrElse("Cindy", 0);


    
    /* Updating Values -------------------------------------------- */
    scores("Bob") = 10;
    scores("Edgar") = 7; // OR
    scores += ("Bob" -> 9, "Gretchen" -> 7);

    // Remove
    scores -= "Bob";

    // Immutable maps cannot be changed but new maps can be made from them
    val newScores = fixedScores + ("Bob" -> 10, "Fred" -> 7);



    /* Iterating over maps ---------------------------------------- */
    for ((k, v) <- scores) {
      printf("%s: %d\n", k, v);
    }

    // keys only
    for (k <- scores.keySet) { println(k); }

    // values only
    for (v <- scores.values) { println(v); }

    // Reverse keys and values
    for ((k, v) <- scores) yield (v, k);



    /* Sorted Maps ------------------------------------------------- */
    val points = scala.collection.immutable.SortedMap(
      "Alice" -> 10, "Fred" -> 7, "Bob" -> 3, "Cindy" -> 8);

    // To be able to visit keys in insertion order use:
    val months = scala.collection.mutable.LinkedHashMap(1 -> "January",
                                                        2 -> "February",
                                                        3 -> "March",
                                                        4 -> "April",
                                                        5 -> "May",
                                                        6 -> "June");



    /* Tuples ----------------------------------------------------- */
    val t = (1, 3.14, "Fred");
    println("t._2: " + t._2);

    val (first, second, third) = t;
    val (one, two, _) = t;

    // partitions
    println("New York".partition(_.isUpper));



    /* Zipping ---------------------------------------------------- */
    val symbols = Array("<", "-", ">");
    val counts  = Array(3, 10, 3);
    val pairs   = symbols.zip(counts);

    for (pair <- pairs) { println(pair); }
    for ((s, c) <- pairs) { print(s * c); }
    println();

    // Zip to map
    val symbolMap = symbols.zip(counts).toMap;
  }
}
