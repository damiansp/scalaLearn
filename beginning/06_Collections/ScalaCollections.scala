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
        println(x.filter(a => a % 2 == 0)) // 2, 4
        println(x) // 1, 2, 3, 4

        val a = Array(1, 2, 3)
        println(a(1)) // 2

        val m = Map("one" -> 1, "two" -> 2, "three" -> 3)
        println(m("two")) // 2

        val r = 0 to 10 // instantiated lazily so:
        println((1 to Integer.MAX_VALUE - 1).take(5)) // only actually instantiates the 1st 5

        val vec = IndexedSeq(1, 2, 3) // imm by default
        println(vec(0)) // 1

        val vec2 = vec ++ Vector(4, 5) // 1, 2, 3, 4, 5
        val vec3 = vec2.updated(0, 9) // 9, 2, 3, 4, 5

        val vec4 = Vector(1, 2, 3, 4, 5)
        val vec5 = vec4.take(2)
        println(vec5) // 1, 2
        vec6 = vec4.filter(_ > 2)
        println(vec6) // 3, 4, 5
        val vec6 = vec ++ vec2
    }
}