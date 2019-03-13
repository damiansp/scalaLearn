object Traits {
  def main(args: Array[String]) {
    trait Gliding {
      def gliding() = println("gliding")
    }


    class Glider extends Gliding {
      override def toString = "glider"
      //override def gliding() = println("race for now " + toString)
    }


    val glider = new Glider
    glider.gliding()
    val g: Glider = glider
    g.gliding()
  }
}
