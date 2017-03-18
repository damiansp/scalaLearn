def hi = "hi"; // equivalent to:
def hi2() = "hi";

/**
 *  As a matter of style, 'function' differs from 'function()' in that the former has no side
 *  effects, and the latter does
 */

def multiplier(x: Int, y: Int): Int = { x * y; };
println(multiplier(6, 7));

def safeTrim(s: String): String = {
  if (s == null) return null;
  s.trim()
};

def log(d: Double): Unit = println(f"Got value $d%.2f");
def formatEuro(amt: Double) = f"€$amt%.2f";

println(formatEuro(3.14159));
println(formatEuro {
    val rate = 1.32;
    0.235 + 0.7123 + rate * 5.32 });

// Recursive functions
def power(x: Int, n: Int): Long = {
  if (n >= 1) x * power(x, n - 1) else 1;
};

println(power(2, 8));

/**
 * @annotation.tailrec
 * def pow(x: Int, n: Int): Long = {
 *   if (n >= 1) x * pow(x, n - 1) else 1; // if return is function invocation, can be optimized
 * };                                      // This one fails
 *
 * @annotation.tailrec
 * def pow(x: Int, n: Int): Long = {
 *   if (n < 1) 1 else x * pow(x, n - 1) // fails: call to pow() being multiplied by other value
 * };
 */

@annotation.tailrec
def pow(x: Int, n: Int, t: Int = 1): Int = {
  if (n < 1) t else pow(x, n - 1, x * t)
};

println(pow(2, 8));

// Nested functions
def max(a: Int, b: Int, c: Int) = {
  def max(x: Int, y: Int) = if (x > y) x else y;
  max(a, max(b, c))
};

println(max(1, 2, 4));
