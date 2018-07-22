def inEven(n: Int) = (n % 2) == 0

List(1, 2, 3, 4).filter((i: Int) => isEven(i)).foreach((i: Int) => println(i)) // same as:
List(1, 2, 3, 4).filter(i => isEven(i)).foreach(i => println(i))               // same as:
List(1, 2, 3, 4).filter(isEven).foreach(println)                               // same as:
List(1, 2, 3, 4) filter isEven foreach println                                 // -> 2 4

