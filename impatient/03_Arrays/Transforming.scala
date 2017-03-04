object Transforming {
  def main(args: Array[String]) {
    val a = Array(-9, 2, 3, -8, 5, 6, 7, -1, 11, 12);
    val result = for (elem <- a) yield 2 * elem;
    val res2 = a.filter(_ % 2 == 0).map(2 * _);
    
    for (e <- result) { println(e); }
    println();
    for (e <- res2) { println(e); }
    println();

    // Remove all but the first negative number from array
    /** Common approach in other langs:
        var first = true;
        var n = a.length;
        var i = 0;
        
        while (i < n) {
          if (a(i) >= 0) { i += 1; }
          else {
            if (first) {
              first = false;
              i += 1;
            } else {
              a.remove(i);
              n -= 1;
            }
          }
        }
    */

    // Better solution:
    // Copy non-neg vals to front
    var first = false;
    val inds = for (i <- 0 until a.length if first || a(i) >= 0) yield {
      if (a(i) < 0) {
        first = false;
        i;
      }
    }

    // Then move elems where they belong and trim the end
    for ( j <- 0 until inds.length) { a(j) = a(inds(j)); }
    a.trimEnd(a.length - inds.length);

    for (e <- a) { println(e); }
    println();
    
  }
}
