object Variables {
  def main(args: Array[String]) {
    val x = 10
    var y = 10
    println(x * x)
    y = 11
    //y = 10.5 // error type mismatch

    lazy val z = 1.0e21 * 1.0331


    /* Numeric Types */
    val b: Byte = 30
    val s: Short = b
    val d: Double = s


    /* Boolean Type */
    val f = !false
    println(f)


    /* Char */
    val c = 'X'


    /* Unit type */
    val empty = ()


    /* Strings */
    val hello = "Hello"
    val title = "Scala"
    println(s"I am learning ${title}")

    
    /* Arrays */
    var books = new Array[String](3)
    var books2 = Array("Beginning Scala", "Beginning Java", "Beginning Clojure")
    books2(2) = "Beginning C++"
    books2.foreach(println)


    /* Lists -- Arrays with immutable elements */
    val empty2: List[Nothing] = List()
    val booklist: List[String] = List("Beginning Scala", "Beginning Java", "Beginning C++")
    val empty3 = Nil /* List "tail" */
    val moreBooks = "Beginning Scala" :: ("Beginning Java" :: ("Beginning C++" :: Nil))
    println(moreBooks.head)
    println(moreBooks.tail)


    /* Ranges */
    println(1 to 5) // Range(1, 2, 3, 4, 5)
    println(1 until 5) // Range(1, 2, 3, 4)
    println(1 to 20 by 4) // Range(1, 5, 9, 13, 17)


    /* Tuples */
    val tuple = (1, false, "Scala")
    val tup2 = "title" -> "Scaler"
    println(tuple._3) // "Scala"


    /* if */
    val exp = true
    if (exp) println("you know it")
    if (exp) {
        println("no you don't")
        println("oh wait... yes you do")
    }
    val i: Int = if (exp) 1 else 3
    val j: Int = if (!exp) 1 else {
        val k = System.currentTimeMillis
        (k % 100L).toInt
    }
    println(j)


    /* While */
    var a = 0
    while (a < 4) {
        println(s"Working on $a")
        a += 1
    }


    /* For */
    val texts = List("Beginning Scala", "Beginning Java", "Beginning C++", "Scala Step by Step", 
                     "Scala in 24 Hours")
    for (text <- texts) println(text)


    /* Filters */
    for (text <- texts if text.contains("Scala")) println(text)


    /* Var binding */
    for {
        text <- texts
        textVal = text.toUpperCase()
    } println(textVal)


    /* Yielding */
    val scalaBooks = for {
        text <- texts if text.contains("Scala")
    } yield text 
    

    /* Exceptions */
    //throw new Exception("some exception...")


    /* try/finally */
    /**
    try {
        throw new Exception("some exception")
    } finally {
        println("...but still print this")
    }
    */


    /*  try/catch */
  }
}
