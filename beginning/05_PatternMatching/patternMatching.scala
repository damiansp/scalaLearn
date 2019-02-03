object Functional {
  def main(args: Array[String]) {
  	def printNum(int: Int) {
  		int match {
  			case 0 => println("Da big Zero")
  			case 1 => println("The one and only")
  			case _ => println("And anudder number")
  		}
  	}

	 	printNum(1)
	 	printNum(9)


	 	def fibonacci(n: Int): Int = n match {
	 		case 0 => 0
	 		case 1 => 1
	 		case n => fibonacci(n - 1) + fibonacci(n - 2)
	 	}

	 	println(fibonacci(8))

    // with guards
    def fib2(n: Int): Int = n match {
      case n if n <= 0 => 0
      case 1 => 1
      case n => fib2(n - 1) + fib2(n - 2)
    }


    // matching Any
    val anyList = List(1, "Ah", 2, 2.5, 'a')
    for (m <- anyList) { 
      m match {
        case i: Int    => println("Integer: " + i)
        case s: String => println("String: " + s)
        case f: Double => println("Double: " + f)
        case other     => println("Other: " + other)
      }
    }

    // Testing Data Types
    def test(in: Any) = in match {
      case s: String       => "String, length " + s.length
      case i: Int if i > 0 => "Natural number"
      case i: Int          => "(Non-natural) Integer"
      case a: AnyRef       => a.getClass.getName
      case _               => "null"
    }

    val x = 1
    val rest = List(2, 3, 4)
    println(x :: rest)


    def sumOdd(in: List[Int]): Int = in match {
      case Nil                     => 0
      case x :: rest if x % 2 == 1 => x + sumOdd(rest)
      case _ :: rest               => sumOdd(rest)
    }

    println(sumOdd(List(3, 2, 5, 4, 7))) // 15


    // Merge repeated items in List to single occurrence
    def noPairs[T](in: List[T]): List[T] = in match {
      case Nil                      => Nil
      case a :: b :: rest if a == b => noPairs(a :: rest)
      case a :: rest                => a :: noPairs(rest)
    }

    println(noPairs(List(1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5)))


    def ignore(in: List[String]): List[String] = in match {
      case Nil                   => Nil
      case _ :: "ignore" :: rest => ignore(rest)
      case x :: rest             => x :: ignore(rest)
    }

    println(ignore(List("a", "word", "ignore", "or", "ignore", "ignore", "two")))


    def getStrings(in: List[Any]): List[String] = in match {
      case Nil                 => Nil
      case (s: String) :: rest => s :: getStrings(rest)
      case _ :: rest           => getStrings(rest)
    }

    println(getStrings(List(1, 3, "first", true, "second", 2.2)))


    case class Person(name: String, age: Int, valid: Boolean)

    val p = Person("David", 45, true)
    val m = new Person("Martin", 44, true)
    println(p.name + ' ' + p.age +  ' ' + p.valid)
    // p.name = "Fred" Error: reassignment to val

    case class MPerson(var name: String, var age: Int) // properteies now mutable
    val mp = MPerson("Jorge", 24)

    def older(p: Person): Option[String] = p match {
      case Person(name, age, true) if age > 35 => Some(name)
      case _                                   => None      
    }

    println(older(p)) // Some(David)
    println(older(Person("Jorge", 24, true))) // None


    // Nested Pattern Matching in Case Classes
    /*
    case class MarriedPerson(
      override val name: String, 
      override val age: Int,
      override val valid: Boolean,
      spouse: Person) extends Person(name, age, valid)
    
    val sally = MarriedPerson("Sally", 24, true, p)

    def mOlder(p: Person): Option[String] = p match {
      case Person(name, age, true) if age > 35                         => Some(name)
      case MarriedPerson(name, _, _, Person(_, age, true)) if age > 35 => Some(name)
      case _                                                           => None
    }

    println(mOlder(p))
    mOlder(sally)
    */

    /*
    def handleRequest(req: List[String])(exceptions: PartialFunction(List[String], String)): = {
      if (exceptions.isDefinedAt(req)) exceptions(req)
      else  "Handling URL " + req + " in the default way"
    }

    handleRequest("foo" :: Nil) {
      case "api" :: call :: params => doApi(call, params)
    }

    def doApi(call: String, params: List[String]): String = "Doing API call " + call

    val f1: PartialFunction[List[Sting]], String] = case "stuff" :: Nil => "Got some stuff"
    val f2: PartialFunction[List[String], String] = case "other" :: params => "Other: " + params
    val f3 = f1 orElse f2
    handleRequest("a" :: "b" :: Nil)(f3)
    */

  }
}