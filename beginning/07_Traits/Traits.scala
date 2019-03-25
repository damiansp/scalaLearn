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


    trait KnowsName extends Animal {
      def name: String
    }


    class Dog(val name: String) extends Mammal with HasLegs with KnowsName {
      def bodyTemperature: Double = 99.3
    }


    trait IgnoresName {
      this: KnowsName => def ignoreName(when: String): Option[String] = 
        if (ignoreName(when)) None else Some(name)
    }


    class Cat(val name: String) extends Mammal with HasLegs with KnowsName with IgnoresName {
      def ignoreName(when: String) = when match {
        case "Dinner" => false
        case _ => true
      }

      def bodyTemperature: Double = 99.5
    }


    trait Athlete extends Animal


    trait Runner {
      this: Athlete with HasLegs => def run() { println("Running") }
    }


    class Person(val name: String) extends Mammal with HasLegs with KnowsName {
      def bodyTemperature: Double = 98.6
    }


    trait Biker extends Person {
      this: Athlete => def ride() { println("Riding a bike") }
    }


    trait Gender
    trait Male extends Gender
    trait Female extends Gender

    // val bikerDog = new Dog("biker") with Athlete with Biker /* a biker nmust be a person */
    val archer = new Dog("Archer") with Athlete with Runner with Male
    val dpp = new Person("David") with Athlete with Biker with Male
    val john = new Person("John") with Athlete with Runner with Male
    val annette = new Person("Annette") with Athlete with Runner with Female


    def goBiking(b: Biker) = println(b.name + " is biking")
    goBiking(dpp)
    //goBiking(annette) /* annette is not a biker */


    def charityRun(r: Person with Runner) = r.run()
  }
}
