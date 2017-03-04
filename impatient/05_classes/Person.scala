object Demo {
  class Person {
    private var name = "";
    private var age  = 0;
    
    // Aux constr
    def this(name: String) { 
      this(); // calls primary constr
      this.name = name;
    }
    
    // Aux constr
    def this(name: String, age: Int) {
      this(name);  // calls previous aux constr
      this.age = age;
    }
  }

  class Person2(val name: String, val age: Int) {
    def description = name + " is " + age + "years old";
    
    println("A Person2 was constructed");
    println(description);
  }

  def main (args: Array[String]) {
    val p1 = new Person; // primary constr
    val p2 = new Person("Fred");
    val p3 = new Person("Gary", 27);
    val p4 = new Person2("Harold", 18);
  }
}

