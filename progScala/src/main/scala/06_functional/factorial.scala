import scala.annotation.tailrec

//@tailrec
def factorial(i: BigInt): BigInt = {
  if (i == 1) i
  else i * factorial(i - 1)
}

for (i <- 1 to 10) println(s"$i:\t${factorial(i)}")


// b35534
def factorial(i: BigInt): BigInt = {
  @tailrec
  def fact(i: BigInt, accumulator: BigInt): BigInt = {
    if (i == 1) accumulator else fact(i - 1, i * accumulator)
  }
  fact(i, 1)
}

for (i <- 1 to 10) println(s"$i:\t${factorial(i)}")
