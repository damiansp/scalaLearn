import org.scalatest.{Matchers, WordSpec}

class MainSpec extends WordSpec with Matchers {
  "A Person" should {
    "be instantiated with an age and a name" in {
      val john = Person(firstName="John", lastName="Smith", 42)
      john.firstName should be("John")
      john.lastName should be("Smith")
      john.age should be(42)
    }
  }
}
