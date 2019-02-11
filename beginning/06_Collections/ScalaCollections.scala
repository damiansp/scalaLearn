object ScalaCollections {
	def main(args: Array[String]) {

		// Seq is an ordered List
		val x = Seq(1, 2, 3)


		// Sets
		val s = Set(1, 2, 3)


		// Map
		val map = Map(1 -> "a", 2 -> "b", 3 -> "c")


		// Immutable Seq
		val imIndSeq = scala.collection.immutable.IndexedSeq(1, 2, 3) // = Vector
		val imLinSeq = scala.collection.immutable.LinearSeq(1, 2, 3)
		val imSeq = scala.collection.immutable.Seq(1, 2, 3)
	}
}