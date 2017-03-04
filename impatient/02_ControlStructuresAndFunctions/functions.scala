def abs(x: Double) = if (x >= 0) x else -x;

def fac(n: Int ) + {
  var r = 1;
  for (i <- 1 to n) { r *= i; }
  r;
}

// Recursive funcs must define a return type
def fac(n: Int): Int = {
  if (n <= 0) { 1 else  n * fac(n - 1); }
}

// Default and named args
def decorate(str: String, left: String = "[", right: String = "]") = {
  left + str + right;
}

// Variable args
def sum(args: Int*) = {
  var result = 0;
  for (arg <- args) { result += arg; }
  result;
}

val s1 = sum(1, 2, 3, 4, 5); // ok
val s2 = sum(1 to 5);        // Error; fix as:
val s3 = sum(1 to 5: _*);    // Treats 1 to 5 as an arg sequence

// E.g.
def recursiveSum(args: Int*): Int = {
  if (args.lenght == 0) { 0; }
  else { args.head + recursiveSum(args.tail: _*);
}

