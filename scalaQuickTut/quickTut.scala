import collection.mutable;
import scala.math._;

object QuickTut {
  def main(args: Array[String]) {
    val Tau = Pi * 2;

    /* String Formatting------------------------------------------------------------------------ */
    println(s"Happy $Tau Day");
    printf("Now you have %.4f problems.", Math.nextAfter(2.0, 3));

    /* Useful Operations------------------------------------------------------------------------ */
    val range = 1 to 10; // [1, 2, ..., 10]
    val range2 = 1 until 10; // [1, 2, ..., 10) = [1, 2, ..., 9]
    val range3 = 2 until 10 by 3; // [2, 5, 8]
    println(range3.toList);

    val num = -5;
    val numAbs = num.abs;
    println(numAbs.max(7));
    println(numAbs.min(7));

    val reverse = "scala".reverse;
    println(reverse);

    val cap = "scala".capitalize;
    println(cap);

    val multi = "scala! " * 7;
    println(multi);

    val onetwothree = "123".toInt;
    println(onetwothree);

    val moren4 = range.filter(_ > 4);
    println(moren4);

    val doublit = range2.map(_ * 2);
    println(doublit);

    /* Anonymous Functions---------------------------------------------------------------------- */
    def doTo1n2(f: (Int, Int) => Int) = f(1, 2);
    val call1 = doTo1n2((x: Int, y: Int) => x + y); // same as...
    val call2 = doTo1n2((x, y) => x + y);           // same as...
    val call3 = doTo1n2(_ + _);
    println(call1, call2, call3);

    def add1(x: Int, y: Int) = x + y;    // method
    val add2 = (x:Int, y:Int) => x + y;  // anonymous function
    val add3: (Int, Int) => Int = _ + _; // same
    println(add1(12, 34));
    println(add2(12, 34));
    println(add3(12, 34));

    /* Return multiple values------------------------------------------------------------------- */
    def swap(x: String, y: String) = (y, x);
    println(swap("hello", "world"));

    /* Declare multiple values/variables-------------------------------------------------------- */
    var x, y, z = 0;
    val c, python, java = false;
    println(x, y, z, c, python, java);

    /* Assign multiple values/variables--------------------------------------------------------- */
    var (u, v, w) = (1, 2, 3);
    println(u, v, w);

    /* Control---------------------------------------------------------------------------------- */
    /* while */
    var i, sum = 0;
    while (i < 10) {
      sum += i;
      i += 1;
    }

    println(sum);

    /* for */
    sum = 0;
    for (i <- 0 until 10) { sum += i; }
    println(sum);

    /* other */
    println((0 until 10).sum);

    /* if/else */
    val likesEggs = false;
    val joesBreakfast = if (likesEggs) "fried eggs" else "bacon";
    println(joesBreakfast);

    /* match (as switch) */
    val selection = "two";
    selection match {
      case "one" => println("one for you, sir");
      case "two" => println("no one for you, sir");
      case _     => println("don't know what to make of you, sir");
    }

    /* Arrays (length fixed, elements mutable)-------------------------------------------------- */
    def printArray[AnythingHere](array: Array[AnythingHere]) = array.mkString("Array(", ", ", ")");

    val a1 = Array(1, 2, 3);
    printArray(a1);

    val a2 = Array("a", 2, false);
    printArray(a2);
    println(a2(2));

    a2(2) = true;
    printArray(a2);

    /* concat */
    val concat = "prepend" +: (a1 ++ a1) :+ "append";
    printArray(concat);

    /* indexOf */
    println(a1.indexOf(1));

    /* diff */
    val diffArray = Array(1, 2, 3, 4).diff(Array(1, 3));
    printArray(diffArray);

    /* find */
    val personArray = Array(("Alice", 1), ("Billy", 2), ("Chuck", 3));

    def arrayFindByName(name: String) = personArray.find(_._1 == name).getOrElse(("David", 4));

    println(arrayFindByName("Billy"));
    println(arrayFindByName("Eldridge"));

    /* Lists------------------------------------------------------------------------------------ */
    // Immutable
    val list1 = List(1, 2, 3);
    val list2 = List("a", 2, true);

    // Mutable
    val mlist = mutable.ArrayBuffer("a", "b", "c");

    // Accessing
    val firstItem = list1(0);

    // Modifying
    mlist(0) = "d";

    // Concat
    val list3 = list1 ++ list2; // or list1 ::: list2 // lists only
    // Prepend
    val list4 = 0 :: list1; // or 0 +: list1
    // append
    val list5 = list1 :+ 4; // not efficient for mutable lists

    // Removing elements
    val mlist2 = mlist - "c";
    val mlist3 = mlist -- List("b", "c");
    mlist.foreach(println);

    mlist -= "c";
    mlist += "e";
    mlist ++= List("f", "g");
    mlist.foreach(println);

    // Difference of lists
    val diffList = List(1, 2, 3, 4) diff List(2, 3);
    diffList.foreach(println);

    // Find
    val personList = List(("Alice", 1), ("Bob", 2), ("Carol", 3));

    def findByName2(name: String) = personList.find(_._1 == name).getOrElse(("David", 4));

    val findBob = findByName2("Bob");
    val findEli = findByName2("Eli");
    
    println(findBob);
    println(findEli);


    /* Sets------------------------------------------------------------------------------------- */
    val set1 = Set(1, 2, 3);
    val set2 = Set("a", 2, true);
    val mset = mutable.HashSet("a", "b", "c");

    println(Set(1, 2, 3, 2, 5, 3, 2, 2, 3, 1));

    // Check for existence
    val oneExists = set1(1); // true
    val fourExists = set2(4); // false

    mset -= "a";
    println(mset);

    // Combine sets (order is arbitrary/not fixed)
    val superset = set1 ++ set2 ++ mset;

    println(superset);
    println(set1); // unchanged

    // Remove; add
    mset -= "c";
    println(mset);
    mset += "e";
    mset ++= Set("f", "g");
    println(mset);

    // Set diff
    val diffSet = Set(1, 2, 3, 4) diff Set(2, 3);
    println(diffSet);

    // Find (NOTE: Map is better used for this purpose)
    val personSet = Set(("Abe", 1), ("Barb", 2), ("Cal", 3));

    def findByName3(name: String) = personSet.find(_._1 == name).getOrElse(("Doug", 4));

    val findBarb = findByName3("Barb");
    val findEd = findByName3("Ed");

    println(findBarb);
    println(findEd);


    /* Maps------------------------------------------------------------------------------------- */
    val map1 = Map("one" -> 1, "two" -> 2, "three" -> 3);
    val map2 = Map(1 -> "one", 2 -> "two", 3 -> "three");

    // collection.mutable
    val mmap = mutable.HashMap("a" -> 1, "b" -> 2, "c" -> 3);

    // Duplicate keys replace
    println(Map("a" -> 1, "a" -> 2));

    // Get items with map(key)
    println(map1("one"));

    // Using .get returns an Option
    val fourExistsOption = map1.get("four"); // returns None
    println(fourExistsOption.isDefined);     //         false

    // Setting or changing values
    mmap("d") = 4;
    println(mmap);

    // Concatenate with ++ (removes dupes, order not guaranteed)
    val concatMap = map1 ++ map2 ++ mmap;
    println(concatMap);

    // Remove or add elem
    mmap -= "c";
    println(mmap);

    mmap += "e" -> 5;
    mmap ++= Map("f" -> 6, "g" -> 7);
    println(mmap);

    // Search
    val personMap = Map(("Alice", 1), ("Bob", 2), ("Carol", 3));

    def findByName(name: String) = personMap.getOrElse(name, 4);

    println(findByName("Bob"));
    println(findByName("Eli"));


    // Mutable Collections--------------------------------------------------------------------- */
    // scala.collection.mutable
    val arrayBuffer = mutable.ArrayBuffer(1, 2, 3);
    val listBuffer = mutable.ListBuffer("a", "b", "c");
    val hashSet = mutable.Set(0.1, 0.2, 0.3);
    val hashMap = mutable.Map("one" -> 1, "two" -> 2);

    /* Mutable Collections Operations---------------------------------------------------------- */
    arrayBuffer += 4;
    listBuffer  += "d";
    arrayBuffer -= 1;
    listBuffer  -= "a";
    hashMap += "four" -> 4;
    hashMap -= "one";

    arrayBuffer ++= List(5, 6, 7);
    hashMap ++= Map("five" -> 5, "six" -> 6);
    hashMap --= Set("one", "three");

    println(arrayBuffer);
    println(listBuffer);
    println(hashMap);

    /* Immutable Collection with var------------------------------------------------------------ */
    // imort scala.collection.mutable
    var immutableSet = Set(1, 2, 3);
    immutableSet += 4;

    val mutableSet = mutable.Set(1, 2, 3);
    mutableSet += 4;
    println(immutableSet, mutableSet);


    /* Classes---------------------------------------------------------------------------------- */
    // Simple class; does nothing
    class Person(fname: String, lname: String);

    val p1 = new Person("Alice", "Bo-balice");  // note p1.fname, p1.lname inaccessible

    // Class w method
    class Person2(fname: String, lname: String) {
      def greet = s"Hi $fname $lname!";
    }

    val p2 = new Person2("Mary", "Bo-bary");
    println(p2.greet);                          // p1.fname, lname still inaccessible

    // Class w read-only var
    class Person3(fname: String, lname: String) {
      val fullName = s"$fname $lname"; // public, read only
      def greet = s"Hi $fullName!";
    }

    val p3 = new Person3("Carlos", "Bo-barlos");
    println(p3.greet);
    println(p3.fullName);                       // fname, lname still inaccessible

    // Auto creates a getter for fname and getter & setter for lname:
    class Person4(val fname: String, var lname: String);

    val p4 = new Person4("David", "Bo-bavid") {
      override def toString = s"$fname $lname";
    };

    println(p4.fname);
    println(p4.lname);
    p4.lname = "Bowie";
    println(p4);
    
  }
}
