package retcalc

sealed trait Returns
case class FixedReturns(annualRate: Double) extends Returns
case class VariableReturns(returns: Vector[VarableReturn]) extends Returns
case class VarableReturn(monthId: String, monthlyRate: Double)
