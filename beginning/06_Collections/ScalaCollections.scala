import scala.collection.mutable

object ScalaCollections {
	def main(args: Array[String]) {

		// Seq is an ordered List
		val sq = Seq(1, 2, 3)


		// Sets
		val s = Set(1, 2, 3) // Immutable by default


		// Map
		val map = Map(1 -> "a", 2 -> "b", 3 -> "c") // Immutable by default


		// Immutable Seq
		val imIndSeq = scala.collection.immutable.IndexedSeq(1, 2, 3) // = Vector
		val imLinSeq = scala.collection.immutable.LinearSeq(1, 2, 3)
		val imSeq = scala.collection.immutable.Seq(1, 2, 3)


    // Immutable Set
    val set = collection.immutable.Set(1, 2, 3)
    val sset = collection.immutable.SortedSet(1, 2, 3)
    val bset = collection.immutable.BitSet(1, 2, 3)
    val smap = collection.immutable.SortedMap(1 -> "a", 2 -> "b")

    // Since the defaults are immutable to use a mutable
    var mset = mutable.Set(1, 9, 5)


    // Buffer
    var buffer = mutable.Buffer(1, 2, 3)
    var aBuff = mutable.Seq(1, 2, 3) // ArrayBuffer
    var mList = mutable.LinearSeq(1, 2, 3) // MutableList
    var iSeq = mutable.IndexedSeq(1, 2, 3) // ArrayBuffer
    var mSortSet = mutable.SortedSet(1, 2, 3) // TreeSet
    var mbSet = mutable.BitSet(1, 2, 3) // BitSet
    var mmap = mutable.Map(1 -> "a", 2 -> "b")



    /* Using Immutable Collection Classes */
    val x = List(1, 2, 3, 4)
	}
}