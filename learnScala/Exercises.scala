/** Exercises */
def nameOrNA(name: String): String = {
  name match {
    case "" => "n/a"
    case _ => name
  }
}

println(nameOrNA("Damian"))
println(nameOrNA(""))

def posNeg1(amount: Double): String = {
  if (amount < 0) "negative" else if (amount == 0) "zero" else "positive"
}

def posNeg2(amount: Double): String = {
  amount match {
    case a if a < 0  => "negative"
    case a if a == 0 => "zero"
    case a if a > 0  => "positive"
  }
}

print(s"${posNeg1(-1)}, ${posNeg1(0)}, ${posNeg1(1)}\n")
print(s"${posNeg2(-1)}, ${posNeg2(0)}, ${posNeg2(1)}\n")

def colorToHex(color: String): String = {
  color match {
    case "cyan"    => "#00FFFF"
    case "magenta" => "#FF00FF"
    case "yellow"  => "#FFFF00"
    case _         => {
      println("color not recognized; black assigned")
      "#000000"
    }
  }
}

println(colorToHex("magenta"))
println(colorToHex("burgundy"))

for (i <- 1 to 100) {
  i match {
    case x if (x % 15 == 0) => print(" fizzbang\n")
    case x if (x % 3  == 0) => print("     fizz")
    case x if (x % 5  == 0) => print("     bang\n")
    case _                  => print(f"$i%9d")
  }
}