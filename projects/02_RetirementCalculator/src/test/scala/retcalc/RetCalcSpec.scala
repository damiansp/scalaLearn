package retcalc

import org.scalactic.{Equality, TolerantNumerics, TypeCheckedTripleEquals}
import org.scalatest.{Matchers, WordSpec}

class RetCalcSpec extends WordSpec with Matchers with TypeCheckedTripleEquals {
  implicit val doubleEquality: Equality[Double] = TolerantNumerics.tolerantDoubleEquality(
    0.0001)

  "RetCalc.futureCapital" should {
    "calculate the amount of savings I will have in n months" in {
      val actual = RetCalc.futureCapital(
        interestRate=0.04 / 12,
        nMonths=25 * 12,
        netIncome=3000,
        currentExpenses=2000,
        initialCapital=10000)
      val expected = 541267.1990
      actual should === (expected)
    }

    "calculate how mach savings will be left after having taken a pension for n months" in {
      val actual = RetCalc.futureCapital(
        interestRate=0.04 / 12,
        nMonths=40 * 12,
        netIncome=0,
        currentExpenses=2000,
        initialCapital=541267.1990)
      val expected = 309867.53176
      actual should === (expected)
    }
  }

  "RetCalc.simulatePlan" should {
    "calculate the capital at retirement and the capital after death" in {
      val (capitalAtRetirement, capitalAfterDeath) = RetCalc.simulatePlan(
        interestRate=0.04 / 12,
        nMonthsSavings=25 * 12,
        nMonthsInRetirement=40 * 12,
        netIncome=3000,
        currentExpenses=2000,
        initialCapital=10000)
      capitalAtRetirement should === (541267.1990)
      capitalAfterDeath should === (309867.5316)
    }
  }

  "RetCalc.nMonthsSaving" should {
    "calculate how long I need to save before I can retire" in {
      val actual = RetCalc.nMonthsSaving(
        interestRate=0.04 / 12,
        nMonthsInRetirement=40 * 12,
        netIncome=3000,
        currentExpenses=2000,
        initialCapital=10000
      )
      val expected = 23 * 12 + 1
      actual should === (expected)
    }

    "not crash if the resulting nMonths is very high" in {
      val actual = RetCalc.nMonthsSaving(
        interestRate=0.01 / 12,
        nMonthsInRetirement=40 * 12,
        netIncome=3000,
        currentExpenses=2999,
        initialCapital=0)
      val expected = 8280
      actual should === (expected)
    }

    "not loop forever if I enter bad parameters" in {
      val actual = RetCalc.nMonthsSaving(
        interestRate=0.04 / 1,
        nMonthsInRetirement=40 * 12,
        netIncome=1000,
        currentExpenses=2000,
        initialCapital=10000)
      actual should === (Int.MaxValue)
    }
  }

  "VariableReturns.fromUntil" should {
    "keep only a window of the returns" in {
      val variableReturns = VariableReturns(Vector.tabulate(12) { i =>
        val d = (i + 1).toDouble
        VariableReturn(f"2017.$d%02.0f", d)
      })
      variableReturns.fromUntil("2017.07", "2017.09").returns should === (
        Vector(VariableReturn("2017.07", 7.0), VariableReturn("2017.08", 8.0)))
      variableReturns.fromUntil("2017.10", "2018.01").returns should === (
        Vector(
          VariableReturn("2017.10", 10),
          VariableReturn("2017.11", 11.0),
          VariableReturn("2017.12", 12.0)))
    }
  }
}