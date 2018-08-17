// Operators for SQL WHERE clauses
object Op extends Enumeration {
	type Op = Value
	val EQ = Value("=")
	val NE = Value("!=")
	val LTGT = Value("<>")
	val LT = Value("<")
	val GT = Value(">")
	val LE = Value("<=")
	val GE = Value(">=")
}

import Op._

case class WhereOp[T](columnName: String, val1: T, cals T*)

val wheres = Seq(WhereIn("state", "IL", "CA", "VA"),
	               WhereOp("state", EQ, "IL"),
	               WhereOp("name", EQ, "Buck Trend"),
	               WhereOp("age", GT, 29))
for (where <- wheres) {
	where match {
		case WhereIn(col, val1, vals @ _*) => 
			val valStr = (val1 +: vals).mkString(", ")
			println(s"WHERE $col IN ($valStr)")
		case WhereOp(col, op, value) => println("WHERE $co $op $value")
		case _ => println(s"ERROR: Unknown expression $where")
	}
}