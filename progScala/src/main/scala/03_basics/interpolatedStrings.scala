val name = "Buck Trends"
println(s"Hello, $name")

val gross = 100000F
val net = 64000F
val percent = 100 * (net / gross)
println(f"$$${gross}%.2f vs. $$${net}%.2f or ${percent}%.1f%%")

val i = 200
val d = 100.22
f"${i}%.2f" // ok -> 200.00
f"${d}%2d"  // fails

val s = "%02d: name = %s".format(5, "Elvis P.")
val name = "Elvis"
raw"123\n$name\n456" // -> no formatting or substitution, verbatim repeat


