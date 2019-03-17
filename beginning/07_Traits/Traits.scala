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


    /**
    trait TraitA {
      def methodA
      def methodAWithParam(param: String)
      def methodWithoutReturnType: String
    }


    trait TraitB extends TraitA {
      def methodB
    }


    class ClassA extends TraitA {
      // ...
    }

    class ClassA extends TraitA with TraitB {
      // ...
    }

    class ClassB extends ClassA with TraitA with TraitB {
      // ...
    }
    */

    trait Vehicle {
      def drive = println("Driving")
      def race // abstract
    }


    class Car extends Vehicle {
      def race = "Racing the car"
    }
  }
}
