object Combinators1 {
	def map[A, B](list: List[A])(f: (A) => B): List[B] = list map f
}