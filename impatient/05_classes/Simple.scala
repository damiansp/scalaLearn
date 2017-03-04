class Counter {                   // classes default to public
  private var value = 0;          // must init

  def increment() { value += 1; } // methods default to public
  def current = value;            // w/o params emph that it is accessor not
                                  // mutator
}

val myCounter = new Counter; // OR new Counter();
myCounter.increment();
println(myCounter.current);




class Person {
  private var privateNTeeth = 0;
  var age = 0;  // scala generates a private age field w/ pub get/set methods

  def nTeeth = privateNTeeth;
  // Override default setter
  def nTeeth_=(newValue: Int) { // no spacing: field_= is the method name
    if (newValue > privateNTeeth) { privateNTeeth = newValue; } // no losses
  }
}

val fred = new Person;
println(fred.age);
fred.age = 21;  // calls built-in fred.age_ = (21)
fred.nTeeth = 2;
println("Teeth: " + fred.nTeeth);
fred.nTeeth = 1; // override setter prevents tooth loss (silent fail)
println("Teeth: " + fred.nTeeth);



// Read-only properties
class Message {
  val timeStamp = new java.util.Date; // vals do not get setters
}

val n = myCounter.current; // myCounter.current() is a syntax error



// Object-private fields
class Counter2 {
  // methods can access private fields of all objects in the class
  private var value = 0;
  private[this] var hiddenValue = 0;

  def increment() { value += 1; }
  // can access private value field of other:
  def isLess(other: Counter) = value < other.value;
  // CANNOT acces other's hiddenValue field:
  //def hiddenIsLess(other: Counter) = hiddenValue < other.hiddenValue; // err
}


// Bean Properties------------------------------------------------- */
import scala.reflect.BeanProperty;

class Person2 {
  @BeanProperty var name: String = _;
  /** ...generates 4 methods:
      name: String
      name_=(newValue: String): Unit
      getName(): String
      setName(newValue: String): Unit
  */
  
}
