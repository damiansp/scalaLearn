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
        val vec7 = vec4.filter(_ > 2)
        println(vec7) // 3, 4, 5
        val vec6 = vec ++ vec2

        val myList = List(1, 2, 3)
        println(99 :: myList) // 99, 1, 2, 3
        val otherList = List(97, 98, 99)
        println(myList ::: otherList)

        val odds = List(1, 2, 3, 4, 5).filter(x => x % 2 == 1)
        println(odds) // 1, 3, 5

        def isOdd(x: Int) = x % 2 == 1

        val moreOdds = List(1, 2, 3, 4, 5, 6, 7).filter(isOdd)
        println(moreOdds)

        println("99 Red Balloons".toList.filter(Character.isDigit)) // 9, 9
        println("Elwood eats mice".takeWhile(c => c != ' ')) // E, l, w, o, o, d
        println(List("A, Cat").map(s => s.toLowerCase)) // a, cat
        println(List("A", "Cat").map(_.toLowerCase))
        println(List("A", "Cat").map(_.length)) // 1, 3


        trait Person { def first: String }

        val p1 = new Person { def first = "David" }
        val p2 = new Person { def first = "Elwood" }
        val p3 = new Person { def first = "Frankie" }
        println(List(p1, p2, p3).map(_.first))

        println(List(8, 6, 22, 2).reduceLeft(_ max _))
        println(
            List("moose", "cow", "alligator", "cat")
            .reduceLeft((a, b) => if (a.length > b.length) a else b))
        println((1 to 10).foldLeft(0)(_ + _))
        println((1 to 10).foldLeft(1)(_ * _))

        val n = (1 to 3).toList
        println(n.map(i => n.map(j => i * j))) // List(List(1, 2, 3), List(2, 4, 6), List(3, 6, 9))
        println(n.flatMap(i => n.map(j => i * j))) // List(1, 2, 3, 2, 4, 6, 3, 6, 9)

        def isEven(n: Int) = !isOdd(n)
        val ten = (1 to 10).toList
        ten.filter(isEven).flatMap(i => ten.filter(isOdd).map(j => i * j))
        for {
            i <- ten if isEven(i)
            j <- ten if isOdd(j)
        } yield i * j

        
        /* Ranges */
        println(1 to 10 by 2)
        println('a' to 'f')


        /* Stream - Lazily evaluated Lists */
        val stream = 1 #:: 2 #:: 3 #:: Stream.empty
        val longStream = (1 to 100000000).toStream
        println(longStream.head) // 1
        println(longStream.tail) // Stream(2, ?)


        /* Tuples */
        def sumSq(x: List[Double]): (Int, Double, Double) = {
            x.foldLeft((0, 0d, 0d))((t, v) => (t._1 + 1, t._2 + v, t._3 + v*v))
        }

        def sumSq2(x: List[Double]): (Int, Double, Double) = {
            x.foldLeft((0, 0d, 0d)) {
                case ((cnt, sum, sq), v) => (cnt + 1, sum + v, sq + v*v)
            }
        }
        
        Tuple2(1, 2) == Pair(1, 2)
        Pair(1, 2) == (1, 2)
        (1, 2) == 1 -> 2


        /* Map[K, V] */
        var p = Map(1 -> "David", 9 -> "Elwood")
        p += 8 -> "Archer"
        println(p(9)) // Elwood
        println(p.get(88)) // None
        println(p.getOrElse(88, "Nobody")) // Nobody
        println(p.get(9)) // Some(Elwood)
        p -= 9 // removes Elwood
        println(p.contains(1)) // true
        println(p.keys.reduceLeft(_ max _)) // 8
        println(p.values.reduceLeft((a, b) => if (a > b) a else b)) // David
        println(p.values.exists(_.contains("z"))) // false
        p ++= List(5 -> "Cat", 6 -> "Dog")
        p --= List(8, 6)

        //def removeInvalid(in: Map[Int, Person]) = in.filter(kv => kv._2.valid)

        val immutableMap = Map(1 -> "a", 2 -> "b", 3 -> "c")
        val newMap = immutableMap - 1 + (4 -> "d")
        println(newMap)

        val mapBuff = immutableMap.toBuffer
        mapBuff += (5 -> "e")
        val newerMap = mapBuff.toMap


        /* Mutable Queue */
        var intQ = mutable.Queue[Int]()
        intQ += 1
        println(intQ) // 1
        intQ += (2, 3) 
        println(intQ) // 1, 2, 3
        intQ.enqueue(4)
        println(intQ) // 1, 2, 3, 4
        println(intQ.dequeue) // 1
        println(intQ) // 2, 3, 4


        /* Mutable Stack */
        var intStack = mutable.Stack[Int](1, 2, 3)
        intStack.push(4) 
        println(intStack) // 4, 1, 2, 3
        intStack.push(5, 6, 7)
        println(intStack) // 7, 6, 5, 4, 1, 2, 3
        println(intStack.pop) // 7
    }
}