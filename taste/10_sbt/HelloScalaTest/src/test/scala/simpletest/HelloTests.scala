package simpletest

import org.scalatest.FunSuite


class HelloTests extends FunSuite {
  // Test 1
  test("the name is set correctly in constructor") {
    val p = new Person("Barney Fife")
    assert(p.name == "Barney Fife")
  }

  // Test 2
  test("a Person's name can be changed") {
    val p = new Person("Bob Dobolina")
    p.name = "Lon"
    assert(p.name == "Lon")
  }
}