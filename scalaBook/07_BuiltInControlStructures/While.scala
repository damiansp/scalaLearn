def gcdLoop(x: Long, y: Long): Long = {
  var a = x;
  var b = y;

  while (a != 0) {
    val temp = a;
    a = b % a;
    b = temp;
  }

  b;
}

var line = "";

do {
  line = readLine();
  println("Read: " + line);
} while (line != "");
