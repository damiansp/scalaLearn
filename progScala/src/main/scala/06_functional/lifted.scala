val finicky: PartialFunction[String, String] = {
  case "finicky" => "FINICKY"
}

finicky("finicky") // FINICKY
finicky("other")   // MatchError

val finickyOption = finicky.lift

finickyOption("finicky") // Some(FINICKY)
finickyOption("other")   // None

val finicky2("finicky") = Function.unlift(finickyOption)

finicky2("finicky")  // FINICKY
finicky2("other")    // MatchError