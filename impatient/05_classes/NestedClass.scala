import scala.collection.mutable.ArrayBuffer;

class Network {
  class Member(val name: String) {
    val contacts = new ArrayBuffer[Member]; // member of same network
    //val contacts = new ArrayBuffer[Network#Member] // member of ANY network
  }

  private val members = new ArrayBuffer[Member];
  val chatter = new Network;
  val myFace  = new Network;

  def join(name: String) {
    val m = new Member(name);
    members += m;
    m;
  }

  val fred   = chatter.join("Fred");
  val wilma  = chatter.join("Wilma");
  val barney = myFace.join("Barney");

  fred.contacts += wilma;  // ok
  //fred.contacts += barney; // nope, can't add myFace.Member to chatter.Member
  
}


/**
   class Network(val name: String) { outer => // outer = Network.this
     class Member(val name: String) {
       ...
       def description = name + " inside " + outer.name
     }
   }
*/


     
