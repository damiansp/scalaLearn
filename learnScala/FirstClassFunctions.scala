// Function Types and Values
def double(x: Int): Int = x * 2;
println(double(5));

val myDouble: (Int) => Int = double; // bc only 1 param Int => Int also ok
println(myDouble(10));

// Alternate syntax
val myDouble2 = double _;
println(myDouble2(20));

val myDoubleCopy = myDouble;
println(myDoubleCopy(40));

def max(a: Int, b: Int) = if (a > b) a else b;
val maximize: (Int, Int) => Int = max;
println(maximize(30, 50));

def logStart() = "=" * 50 + "\nStarting NOW\n" + "=" * 50;
val start: () => String = logStart;
println(start());



// Higher-Order Functions
def safeStringOp(s: String, f: String => String) = {
  if (s != null) f(s) else s;
};

def reverser(s: String) = s.reverse;
println(safeStringOp("satterthwaite", reverser));
println(safeStringOp(null, reverser));



// Function Literals
val doubler = (x: Int) => x * 2;
val doubled = doubler(22);

val greeter = (name: String) => s"Hello, $name";
val hi = greeter("World");
val start2 = () => "=" * 50 + "\nStarting NOW\n" + "=" * 5;

println(start());

println(safeStringOp(null, (s: String) => s.reverse));
println(safeStringOp("eyesnickem", s => s.reverse));



// Placeholder syntax
val tripler: Int => Int = _ * 3;
println(safeStringOp("remba", _.reverse));

def combination(x: String, y: String, f: (String, String) => String) = f(x, y);
println(combination("Pizza Hut ", "Taco Bell ", _ + _));



// Partially Applied Functions and Currying
def isFactorOf(x: Int, y: Int) = y % x == 0;
val f = isFactorOf _; // retains no parameters
val x = f(7, 20); // false
println(x);

val multipleOf3 = factorOf(3, _: Int);
val y = multipleOf3(78); // true
println(y);
nn
// Currying
def isFactorOfB(x: Int)(y: Int) = y % x == 0;
val isEven = isFactorOfB(2) _;
val z = isEven(32); // true
println(z);



// By-Name Parameters
def doubles(x: => Int) = {
  println("Now doubling " + x);
  x * 2;
};

def g(i: Int) = {
  println(s"Hello from g($i)");
  i;
};

println(doubles(g(8)));



// Partial Functions
val statusHandler: Int => String = {
  case 200 => "Okay";
  case 400 => "Your error";
  case 500 => "Our error";
};



// Higher-Order Functions
val uuid = java.util.UUID.randomUUID.toString;
val timeUUID = safeStringOp(uuid, {
    s =>
    val now = System.currentTimeMillis;
    val timed = s.take(24) + now;
    timed.toUpperCase;
});

def safeStringOp2(s:String)(f: String => String) = {
  if (s != null) f(s) else s;
};

val timeUUID2 = safeStringOp2(uuid) {
  s =>
  val now = System.currentTimeMillis;
  val timed = s.take(24) + now;
  timed.toUpperCase;
};

def timer[A](f: => A): A = {
  def now = System.currentTimeMillis;
  val start = now;
  val a = f;
  val end = now;
  println(s"Executed in ${end - start} ms")
  a;
};

val veryRandomAmount = timer {
  util.Random.setSeed(System.currentTimeMillis);
  for (i <- 1 to 100000) util.Random.nextDouble;
  util.Random.nextDouble;
};

