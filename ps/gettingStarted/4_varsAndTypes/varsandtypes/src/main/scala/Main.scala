import java.time._


@main def main: Unit =
  // Numeric types
  val anInt: Int = 5
  val aDoub: Double = 3.2
  val aFloat: Float = 1.3f
  val aLong: Long = 1999L
  val aChar: Char = 'c'
  val aShort: Short = 120
  val aByte: Byte = 1

  // Non-numeric types
  val aUnit: Unit = ()
  val aBool: Boolean = false
  
  // Ref types
  var arr: Array[Int] = Array(1, 2)
  println(arr(1)) // 2
  val aNull: Null = null

  // Casting
  /* byte < short < int < long < float < double
             char < int...
  */ 


  // Dates and times (from Java)
  val nowDate = LocalDate.now()
  val nowTime = LocalTime.now()
  val nowDateTime = LocalDateTime.now()
  val nowDateTimeTZ = ZonedDateTime.now()
  println(nowDate)
  println(nowTime)
  println(nowDateTime)
  print(nowDateTimeTZ)  

  val bd = LocalDate.of(1976, 11, 3)
  val bt = LocalTime.of(1, 23, 45) // h, m, s
  val bdt = LocalDateTime.of(1976, 11, 3, 1, 23)
  println(bd.isAfter(nowDate)) // false
  println(bt.isBefore(nowTime))
  println(bdt)

  val thisYear = bdt.plusYears(45)
  println(thisYear)
  
