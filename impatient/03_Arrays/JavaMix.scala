import scala.collection.JavaConversions.bufferAsJavaList;
import scala.collection.mutable.ArrayBuffer;

object JavaMix {
  val command = ArrayBuffer("ls", "-la", "/$HOME/Class");
  val pb = new ProcessBuilder(command); // to Java
  
}
