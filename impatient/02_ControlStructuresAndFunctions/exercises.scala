object Exercises {
  def main(args: Array[String]) {
    def signum(n: Int) : Int = {
      if (n >= 0) 1 else -1;
    }

    println(signum(-42));
    println(signum(17));
    println({});

    def countdown(n: Int) {
      for (i <- 0 to n) { println(n - i); }
    }

    for (i <- 0 to 10) { println(10 - i); }
    countdown(15);

    var prod = 1;
    for (c <- "Hello") {
      prod *= c;
    }
    println(prod);

    def stringProd(s: String) : Int = {
      var prod = 1;
      for (c <- s) { prod *= c; }
      prod;
    }

    println(stringProd("Bye"));
  }
}
