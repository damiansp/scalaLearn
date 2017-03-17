def hi = "hi"; // equivalent to:
def hi2() = "hi";

/**
 *  As a matter of style, 'function' differs from 'function()' in that the former has no side
 *  effects, and the latter does
 */

def multiplier(x: Int, y: Int): Int = { x * y; };
println(multipler(6, 7));

def safeTrim(s: String): String = {
  if (s == null) return null;
  s.trim()
};

def log(d: Double): Unit = println(f"Got value $d%.2f");

