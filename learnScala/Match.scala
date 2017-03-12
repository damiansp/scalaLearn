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

