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
