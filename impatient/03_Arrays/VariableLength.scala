import scala.collection.mutable.ArrayBuffer;

object VariableLength {
  def main(args: Array[String]) {
    val b = ArrayBuffer[Int](); // or: val b = new ArrayBuffer[Int]

    b += 1;
    println(b); // b = (1)

    b += (1, 2, 3, 5);
    println(b); // b = (1, 1, 2, 3, 5)

    b ++= Array(8, 13, 21) ; // append
    println(b); // b = (1, 1, 2, 3, 5, 8, 13, 21)

    b.trimEnd(5);
    println(b); // (1, 1, 2)

    b.insert(2, 6); // insert value 6 at index 2 shift others right
    println(b); // (1, 1, 6, 2)

    b.insert(2, 7, 8, 9);
    println(b); // (1, 1, 7, 8, 9, 6, 2)

    b.remove(2);  // remove element at index 2; shift left
    println(b); // (1, 1, 8, 9, 6, 2)

    b.remove(2, 3);
    println(b); // (1, 1, 2)

    // To fixed-length Array:
    val a = b.toArray;
    println(a);

    // Fixed to variable-length:
    val c = a.toBuffer;
    println(c);
  }
}
