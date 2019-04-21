package learningscalasummary.chapter.eight

sealed class SealedClass {}
class SealedSubClassOnlyCanPlaceInSameFileWithSealedClass extends SealedClass
// ex: Option, Some, None
// sealed classes are a useful way to implement an abstract parent class that "knows" and refers to specific subclasses.
// By restricting subclasses outside the same file, assumptions can be made about a class hierarchy that would otherwise have severe repercussions (read: bugs).