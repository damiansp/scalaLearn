// Scala wrapper for Java-like DB API
package scala.implicits {
  pacage scaladb {
    object implicits {
      import javadb.JRow

      implicit class SRow(jrow: JRow) {
        def get[T](colName: String)(implicit toT: (JRow, String) => T): T = toT(jrow, colName)
      }

      implicit val jrowToInt: (JRow, String) => Int = 
        (jrow: JRow, colName: String) => jrow.getInt(colName)
      implicit val jrowToDouble: (JRow, String) => Double = 
        (jrow: JRow, colName: String) => jrow.getDouble(colName)
      implicit val jrowToString: (JRow, String) => String = 
        (jrow: JRow, colName: String) => jrow.getText(colName)
    }

    object DB {
      import implicits._

      def main(args: Array[String]) = {
        val row = javadb.JRow("one" -> 1, "two" -> 2.2, "three" -> "THREE")
        val oneVal1: Int = row.get("one")
        val twoVal1: Double = row.get("two")
        val threeVal1: String = row.get("three")
        println(s"one1   -> $oneVal1")
        println(s"two1   -> $twoVal1")
        println(s"three1 -> $threeVal1")

        val oneVal2 = row.get[Int]("one")
        val twoVal2 = row.get[Double]("two")
        val threeVal1 = row.get[String]("three")
        println(s"one2   -> $oneVal1")
        println(s"two2   -> $twoVal1")
        println(s"three2 -> $threeVal1")
      }
    }
  }
}