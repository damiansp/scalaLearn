package retcalc

import scala.annotation.tailrec


object RetCalc {
  def futureCapital(
      interestRate: Double, nMonths: Int, netIncome: Int, currentExpenses: Int,
      initialCapital: Double): Double = {
    val monthlySavings = netIncome - currentExpenses
    (0 until nMonths).foldLeft(initialCapital)(
      (accumulated, _) => accumulated*(1 + interestRate) + monthlySavings)
  }

  def simulatePlan(
      interestRate: Double, nMonthsSavings: Int,  nMonthsInRetirement: Int, netIncome: Int,
      currentExpenses: Int, initialCapital: Double): (Double, Double) = {
    val capitalAtRetirement = futureCapital(
      interestRate=interestRate,
      nMonths=nMonthsSavings,
      netIncome=netIncome,
      currentExpenses=currentExpenses,
      initialCapital=initialCapital)
    val capitalAfterDeath = futureCapital(
      interestRate=interestRate,
      nMonths=nMonthsInRetirement,
      netIncome=0,
      currentExpenses=currentExpenses,
      initialCapital=capitalAtRetirement)
    (capitalAtRetirement, capitalAfterDeath)
  }

  def nMonthsSaving(
      interestRate: Double, nMonthsInRetirement: Int, netIncome: Int, currentExpenses: Int,
      initialCapital: Double): Int = {
    @tailrec
    def loop(months: Int): Int = {
      val (capitalAtRetirement, capitalAfterDeath) = simulatePlan(
        interestRate=interestRate,
        nMonthsSavings=months,
        nMonthsInRetirement=nMonthsInRetirement,
        netIncome=netIncome,
        currentExpenses=currentExpenses,
        initialCapital=initialCapital
      )
      if (capitalAfterDeath > 0.0) months else loop(months + 1)
    }
    if (netIncome > currentExpenses) loop(0) else Int.MaxValue
  }
}