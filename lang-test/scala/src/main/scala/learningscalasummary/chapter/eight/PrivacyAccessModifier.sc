package learningscalasummary.chapter.eight {
  private[chapter] class OnlyAllowedInChapterPackage {
    val myField: String = "myField"
  }

  class Test {
    private[this] val passwd: String = "1234"
  }
}
