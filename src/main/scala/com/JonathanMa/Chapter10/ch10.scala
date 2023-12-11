package com.JonathanMa.Chapter10

// when a method has no implementation then it is abstract
// consequently you have to make the class abstract if it has abstract members
// methods that have implementation are called concrete
// none of the methods have parameters, these are called parameterless methods
// invocation of parameter list depends on the method, if the method has no side effects then
// leave out the parameter, otherwise use it: "hello".length | println()
// recommended convention of using parameterless method is when the method takes no argument AND the method is used to
// read fields
abstract class Element {
  def contents: Array[String]
  def height: Int = contents.length
  def width: Int = if (height == 0) 0 else contents(0).length
}




// ArrayElements is a subclass of Element because it extends Element
class ArrayElements(conts: Array[String]) extends Element {
  // a member with the same name in a subclass overrides the superclass member with the same name
  // we can say concrete member implements abstract member if we define it in the subclass
  def contents: Array[String] = conts // contents here is a concrete method because it has implementation
  // contents also overrides superclass Element content method because it has the same name
}
// subclasses does NOT inherit private members of the superclass and overridden methods


/*
Subtyping:
          val e: Element = new ArrayElement(Array("hello", "world"))
          val e here is expecting a type Element but it is receiving a type ArrayElement
          this is allowed because ArrayElement is a subclass of Element
 */

/* Overriding methods and fields:
      With uniform access principle (UAP), we can change the internal application of a field or method
      without affecting how the client accesses the member.
*/