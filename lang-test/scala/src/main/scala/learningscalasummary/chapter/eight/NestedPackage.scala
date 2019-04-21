package learningscalasummary {
  package chapter {
    package eight {
      class NestedPackage {}
    }
  }
}

class Hola {
  def instantiateNestedPackage() = {
    val np = new learningscalasummary.chapter.eight.NestedPackage()
  }
}
