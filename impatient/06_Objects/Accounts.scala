/** objects are:
    homes for util functions
    used when single immutable instance can be shared efficiently
    for classes with single instances
*/
class Account {
  val id = Account.newUniqueNumber(); // note func not in class scope
  private var balance = 0.0;

  def deposit(amount: Double) { balance += amount; }
  // ...
}

// Companion object
object Account {
  private var lastNumber = 0;
  private def newUniqueNumber() = {
    lastNumber += 1;
    lastNumber
  }
}

// class and companion obj can access ea other's private parts;
// obj methods/vars are like statics in java
// must be in same source file
