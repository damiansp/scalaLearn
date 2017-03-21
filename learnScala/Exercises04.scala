def circleArea(r: Double): Double = {
  val pi = 3.141592;
  pi * r * r;
};

println(circleArea(12.0));

def msToYears(ms: Long): String = {
  val msPerS = 1000;
  val sPerMin = 60;
  val minPerHr = 60;
  val hrPerDay = 24;
  val dayPerYear = 365;

  val msFinal = ms % msPerS;
  val s = ms / msPerS;
  val sFinal = s % sPerMin;
  val min = s / sPerMin;
  val minFinal = min % minPerHr;
  val hr = min / minPerHr;
  val hrFinal = hr % hrPerDay;
  val day = hr / hrPerDay;
  val dayFinal = day % dayPerYear;
  val year = day / dayPerYear;
  s"$year years, $dayFinal days, $hrFinal hrs, $minFinal min, $sFinal s, $msFinal ms";
};

for (i <- List(10000, 200000, 3000000, 40000000, 500000000)) {
  println(msToYears(i));
}

def power(base: Int, exp: Int): Long = {
  if (exp == 0) return 1;
  if (exp == 1) {
    return base;
  } else {
    return  base * power(base, exp - 1);
  }
};

println(power(2, 0));
println(power(2, 1));
println(power(2, 2));
println(power(2, 3));

case class Point(x: Int, y: Int);

def diffxy(p1: Point, p2: Point): Point = {
  new Point(p1.x - p2.x, p1.y - p2.y);
};

val p1 = new Point(5, 4);
val p2 = new Point(3, 3);
println(diffxy(p1, p2));


  
