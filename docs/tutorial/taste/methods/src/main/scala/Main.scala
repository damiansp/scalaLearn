@main def hello: Unit = 
  val x = sum(1, 2)
  val y = concatenate("fu", "bar")
  makeConnection("https://localhost")
  makeConnection("https://localhost", 2500)
  println("world".hello)
  println("world".aloha)
  println("1".makeInt(2))
  println("10".makeInt(2))
  println("100".makeInt(2))


def sum(a: Int, b: Int): Int = a + b


def concatenate(s1: String, s2: String): String = s1 + s2


/*
def getStackTrace(t: Throwable): String =
  val sw = new StringWriter
  t.printStackTrace(new PrintWriter(sw))
  sw.toString
*/


def makeConnection(url: String, timeout: Int = 5000): Unit = 
  println(s"url=$url, timeout=$timeout")


// Extension methods (to closed classes)
extension (s: String)
  def hello: String = s"Hello, ${s.capitalize}!"
  def aloha: String = s"Aloha, ${s.capitalize}!"
  def makeInt(radix: Int): Int = Integer.parseInt(s, radix)