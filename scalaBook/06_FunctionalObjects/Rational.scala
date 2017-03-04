object Demo {
  class Rational(n: Int, d: Int) {
    require(d != 0);

    private val g = gcd(n.abs, d.abs);
    val num: Int = n / g;
    val denom: Int = d / g;

    // Aux constr:
    def this(n: Int) = this(n, 1);
    
    override def toString = if (denom > 1) num + "/" + denom else num;      

    // Operator overloads
    def +(that: Rational): Rational = new Rational(
      num * that.denom + that.num * denom, denom * that.denom);
    def +(i: Int): Rational = new Rational(num + i * denom, denom);
    def -(that: rational): Rational = new Rational(
      num * that.denom - that.num * denom, denom * that.denom);
    def -(i: Int): Rational = new Rational(num - i * denom, denom);
    def *(that: Rational): Rational = new Rational(num * that.num,
                                                   denom * that.denom);
    def *(i: Int): Rational = new Rational(num * i, denom);
    def /(that: Rational): Rational = new Rational(num * that.denom,
                                                   denom * that.num);
    def /(i: Int): Rational = new Rational(num, denom * i);
    
    def lessThan(that: Rational) = {
      this.num * that.denom < that.num * this.denom;
    }

    // Greatest common divisor
    private def gcd(a: Int, b: Int): Int = {
      if (b == 0) a else gcd(b, a % b);
    }
  }


  def main(args: Array[String]) {
    val three5 = new Rational(3, 5);
    val one2   = new Rational(1, 2);
    val seven  = new Rational(7);
    val ten30  = new Rational(10, 30);

    println(three5);
    println(three5.num);
    println(three5.denom);
    println(three5 + one2);
    println(three5 * one2);
    println(seven);
    println(ten30);
  }
}

