package com.JonathanMa.Chapter10


object Section1 {

}

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

/*
  10.5 Overriding methods and fields:
      With uniform access principle (UAP), we can change the internal application of a field or method
      without affecting how the client accesses the member.
*/

/*
  10.6 Defining parametric fields
    The conts parameter for ArrayElements is solely for contents field, this is "code smell"
    which is a sign there may be redundancy in code.
    So in comes parametric fields, the combination of a field and parameter:

      class Cat{
        val dangerous: = true
      }
      class Tiger(
        override val dangerous: Boolean
        private var age: Int
      ) extends Cat

    Notice here we can have modifiers(private, protected, override).
    The code above is the same as:

      class Tiger(param1: Boolean, param2: Int) extends Cat{
        override val dangerous = param1
        private var ag = param2
      }
 */

/*
  10.7 Invoking superclass constructors
 */
class LineElement(s: String) extends ArrayElements(Array(s)) {
  override def width: Int = s.length

  override def height: Int = 1
}

/*
  10.8 Using override modifier
    1. All concrete members require an override modifier
    2. Optional for abstract members
 */

/*
  10.9 Polymorphism and dynamic binding
    Remember how a var with type Element can refer a type ArrayElement, that is polymorphism.
    You can also say Element object can have many forms.
 */

class UniformElement(ch: Character, override val height: Int, override val width: Int) extends Element {
  private val line = ch.toString * width

  def contents: Array[String] = Array.fill(height)(line)
}

// dynamic binding means that a method invocation on a expression is based on the objects class, not the type of the variable:
/*
    abstract class Element {
      def demo() = {
        println("Element's implementation invoked")
      }
    }
    class ArrayElement extends Element {
      override def demo() = {
        println("ArrayElement's implementation invoked")
      }
    }
    class LineElement extends ArrayElement {
      override def demo() = {
        println("LineElement's implementation invoked")
      }
    }

    def invokeDemo(e:Element) = {
      e.Demo()
    }
*/

/*
  10.10 Declaring final members
    When you do not want a class or method to be overridden then you can use the "final" modifier.
      class ArrayElement extends Element {
        final override def demo() = {
          println("ArrayElement's implementation invoked")
        }
      }
    This will not compile because LineElement will throw an error because it extends ArrayElement
    and tries to override the final demo method.

    Similarly you can final a whole class so that it cannot be inherited:
      final class ArrayElement extends Element {
        override def demo() = {
          println("ArrayElement's implementation invoked")
        }
      }
    This will throw an error illegal inheritance from final class
 */

/*
  10.11 Using composition and inheritance
    Takeaway from this section is that inheritance has the "fragile base class" problem.
    Basically if you want to change the base class you risk breaking subclasses.
 */

/*
  10.12 Implementing above, beside, and toString
 */

import Element2.elem

abstract class Element2 {
  def contents: Array[String]

  def height: Int = contents.length

  def width = if (height == 0) 0 else contents(0).length

  def above(that: Element2): Element2 = elem(this.contents ++ that.contents)

  def beside(that: Element2): Element2 = elem(for ((list1, list2) <- this.contents zip that.contents) yield list1 + list2)

  //  def above(that: Element2): Element2 =
  //    new ArrayElements2(this.contents ++ that.contents)
  //
  //  def beside(that: Element2): Element2 =
  //    new ArrayElements2(
  //      for (
  //        (line1, line2) <- this.contents zip that.contents
  //      ) yield line1 + " " + line2
  //    )
  // Commented out because we are adding a companion object of class Element and making that the factory object
  override def toString: String = contents mkString ("\n")

  def heighten(h: Int): Element2 =
    if (h <= height) this
    else {
      val top = elem(' ', width, (h - height) / 2)
      val bot = elem(' ', width, h - height - top.height)
      top above this above bot
    }

  def widen(w: Int): Element2 =
    if (w <= width) this
    else {
      val left = elem(' ', (w - width) / 2, height)
      val right = elem(' ', w - width - left.width, height)
      left beside this beside right
    }
}


object Element2 {
  private class ArrayElements2(val contents: Array[String]) extends Element2 {
  }

  private class UniformElements2(char: Char, override val width: Int, override val height: Int) extends Element2 {
    private val line = char.toString * width

    def contents: Array[String] = Array.fill(height)(line)
  }

  private class LineElement2(s: String) extends Element2 {
    val contents = Array(s)
    override def width = s.length
    override val height = 1

  }

  def elem(arr: Array[String]): Element2 = {
    new ArrayElements2(arr)
  }

  def elem(char: Char, width: Int, height: Int): Element2 = {
    new UniformElements2(char, width, height)
  }

  def elem(s: String): Element2 = {
    new LineElement2(s)
  }
}

