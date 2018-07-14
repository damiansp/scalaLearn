def hello(name: String) = s"""Welcome!
  Hello, $name!
  * (Gratuitious Star!!)
  |We're glad you're here.
  |  Have some extra whitespace.""".stripMargin


def goodbye(name: String) =
  s"""xxxGoodbye, ${name}yyy
  xxxCome again!yyy""".stripPrefix("xxx").stripSuffix("yyy")


// Function Literals
val f1: (Int, String) => String = (i, s) => s + i // same as:
val f2: Function2[Int, String, String] = (i, s) => s + i

hello("Damian")
goodbye("Damian")