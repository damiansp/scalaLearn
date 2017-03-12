// match is frequently a good replacement for if... else, or when other
// languages would use a switch block:
val max1 = if (x > y) x else y;

// Equivalent to
val max2 = x > y match {
  case true => x;
  case false => y;
};

val message = status match {
  case 200 => "ok"
  case 400 => {
    println("ERROR - Service called incorretly")
    "error"
  }
  case 500 {
    println("ERROR - Service error")
    "error"
  }
};

// Alternate pattern matching
val day = "SAT";
val daytype = day match {
  case "MON" | "TUE" | "WED" | "THU" | "FRI" => "weekday"
  case "SAT" | "SUN" => "weekend"
};

// Default/wildcard matching
val msg = "Unauthorized";
val status = msg match {
  case "Ok" => 200
  case _ => {
    println(s"Couldn't parse $message")
    -1
  }
};

// Matching with pattern guards
val response: String = null;
response match {
  case s if s != null => println(s"Received '$s'")
  case s              => println("Error! Received a null response")
};

// Matching types with pattern variables
val x: Int = 12180;
val y: Any = x;

y match {
  case x: String => s"'$x'"
  case x: Double => f"$x%.2f"
  case x: Float  => f"$x%.2f"
  case x: Long   => s"${x}l"
  case x: Int    => s"${x}i"
};
