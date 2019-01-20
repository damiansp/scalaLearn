package retcalc


object RetCalc {
  def futureCapital(
      interestRate: Double, nMonths: Int, netIncome: Int, currentExpenses: Int,
      initialCapital: Double): Double = {
    val monthlySavings = netIncome - currentExpenses

    def nextCapital(accumulated: Double, month: Int): Double =
      accumulated*(1 + interestRate) + monthlySavings

    (0 until nMonths).foldLeft(initialCapital)(nextCapital)
  }
}