package retcalc


object RetCalc {
  def futureCapital(
      interestRate: Double, nMonths: Int, netIncome: Int, currentExpenses: Int,
      initialCapital: Double): Double = {
    val monthlySavings = netIncome - currentExpenses
    (0 until nMonths).foldLeft(initialCapital)(
      (accumulated, _) => accumulated*(1 + interestRate) + monthlySavings)
  }
}