// Fragment to exemplify Domain-Specific Language (DSL)

import org.scalatest.{FunSpec, ShouldMatchers}

class NerdFinderSpec extends FunSpec with ShouldMatchers {
  describe("nerd finder") {
    it ("identify nerds from a List") {
      val actors = List("Rick Moranis", "James Dean", "Woody Allen")
      val finder = new NerdFinder(actors)
      finder.findNerds shouldEqual List("Rick Moranis", "Woody Allen")
    }
  }
}
