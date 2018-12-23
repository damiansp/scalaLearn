/* Singleton Objects */
object Car {
  def drive { println("Driving car") } 
}

object Main extends App { 
  Car.drive
}