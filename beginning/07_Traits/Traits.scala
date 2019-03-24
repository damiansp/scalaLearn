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
      def drive = "Driving"
      def race // abstract
    }


    class Car extends Vehicle {
      def race = "Racing the car"
    }


    class Boat extends Vehicle {
      override def drive = "Float"
      def race = "Racing the boat"
    }


    trait CarTrait {
      var door: Int
      val wheels: Int = 4
      var seat = 4
    }

    
    class Car extends CarTrait {
      var door = 4 // override not needed for var
      override val wheels = 3  // val does
      seat = 5
    }


    abstract class LivingThing
    abstract class Plant extends LivingThing
    abstract class Fungus extends LivingThing
    abstract class Animal extends LivingThing


    trait HasLegs extends Animal {
      def walk() = println("Walking")
    }


    trait HasWings extends Animal {
      def flap() = println("Flap Flap")
    }


    trait Flies {
      this: HasWings => def fly() = println("I'm flying")
    }


    abstract class Bird extends Animal with HasWings with HasLegs 


    class Robin extends Bird with Flies
    class Ostrich extends Bird


    abstract class Mammal extends Animal {
      def bodyTemperature: Double
    }
  }
}
