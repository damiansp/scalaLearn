import java.io._

abstract class BulkReader {
	type In
	val source: In
	def read: String // Read source, return String
}

class StringBulkReader(val source: String) extends BulkReader {
	type In = String
	def read: String = source
}

class FileBulkReader(val source: File) extends BulkReader {
	type In = File
	def read: String = {
		val in = new BufferedInputStream(new FileInputStream(source))
		val nBytes = in.available()
		val bytes = new Array[Byte](nBytes)
		in.read(bytes, 0, nBytes)
		new String(bytes)
	}
}

println(new StringBulkReader("Hello, Scala!").read)
println(new FileBulkReader(new File("TypeLessDoMore/abstractTypes.scalaa")).read)