package progscala3.introscala.shapes


sealed trait Message // sealed: subclasses must be defined in same file
case class Draw(shape: Shape) extends Message
case class Response(message: String) extends Message
case object Exit extends Message