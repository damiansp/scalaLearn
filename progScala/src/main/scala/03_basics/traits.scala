class ServiceImportant(name: String) {
	def work(i: Int): Int = {
		println(s"ServiceImportant: so important! $i")
		i + 1
	}
}

val service1 = new ServiceImportant("uno")
(1 to 3) foreach (i => println(s"Result: ${service1.work(i)}"))

trait Logging {
	def info(message:    String): Unit
	def warning(message: String): Unit
	def error(message:   String): Unit
}

trait StdoutLogging extends Logging {
	def info(message:    String) = println(s"INFO:    $message")
	def warning(message: String) = println(s"WARNING: $message")
	def error(message:   String) = println(s"ERROR:   $message")
}


val service2 = new ServiceImportant("dos") with StdoutLogging {
	override def work(i: Int): Int = {
		info(s"Starting work: i = $i")
		val result = super.work(i)

		info(s"Ending work: i = $i, result = $result")
		result
	}
}
(1 to 3) foreach (i => println(s"Result: ${service2.work(i)}"))


class LoggedServiceImportant(name: String) extends ServiceImportant(name) with StdoutLogging { 
	/** ... */
}