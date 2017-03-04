import scala.collection.mutable.ArrayBuffer;
  
object CommonAlgos {
  def main(args: Array[String]) {
    val a = Array(1, 7, 2, 9);

    println(a.sum);

    val b = ArrayBuffer("Mary", "had", "a", "little", "lamb");
    println(b.max);

    /**  BROKEN:
         val c = ArrayBuffer(1, 7, 2, 9);
         val cSorted = c.sorted(_ < _);
         cSorted.mkString(", ");
         val cSort2 = c.sortWith(_ > _);
         cSort2.mkString(", ");
    */
    
    // Sort an array in place (does not work with ArrayBuffer
    scala.util.Sorting.quickSort(a);
    println(a.mkString(" and "));
    println(a.mkString("<<", ", ", ">>"));
    
  }
}
