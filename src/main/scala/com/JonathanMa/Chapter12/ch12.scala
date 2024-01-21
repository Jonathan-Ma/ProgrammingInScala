package com.JonathanMa.Chapter12
import scala.collection.mutable.ArrayBuffer

/*
  Chapter 12: Traits
    Traits are fundamental unit of code reuse. Trait encapsulates method and field
    definitions, which then can be reused by mixing them into classes. A class can mis in any number of
    traits.

*/

/*
  12.1 How traits work
    Trait definition looks just like class definition except it uses keyword trait:

      trait Philosophical {
        def philosophize() = {
          println("I consume memory, therefor I am!")
      }

    This trait does not declare a superclass so like a class, it has default superclass AnyRef.

        class Frog extends Philosophical {
          override def toString: String = "green"
        }

    Methods inherited from traits can be used just like methods inherited from a superclass.

      val frog = new Frog
      frog.philosophize()

    A trait also defines a type:
      val phil: Philosophical = frog
      phil: Philosophical = green

    If you wish to mix in a trait into a class that also extends a superclass then you can use the
    with clause:

      class Animal
      class Frog extends Animal with Philosophical {
        override def toString = "green"
      }

    You can also mix in multiple traits:

      class Animal
      trait HasLegs

      class Frog extends Animal with Philosophical with HasLegs {}

    Classes inheriting traits can override methods inside the trait and still use the traits type.
 */

/*
  12.2 Thin vs rich interfaces
    Basically traits can have concrete and abstract methods as well as fields.
 */

/*
  12.3 Example: Rectangular objects
    Suppose we want to write a graphics library that have different classes that represent rectangular objects.
    It would be nice if the library provides geometric queries such as height, width, topRight, etc. but in order
    to implement all these methods in Java it would be repetitive because each class would have to reimplement the method.

    For example imagine if traits didn't exist:

      class Point(val x: Int, val y: Int)
      class Rectangle(val topLeft: Point, val bottomRight: Point) {
        def left = topLeft.x
        def right = bottomRight.x
        def width = right - left
      }

    Another class for a 2-D graphical widget:
      abstract class Component{
        def topLeft: Point
        def bottomRight: Point
        def left = topLeft.x
        def right = bottomRight.x
        def width = right - left
        // so on
      }

    See how left, right, width are identical above. With traits we can eliminate this repetition:

      trait Rectangular {
        def topLeft: Point
        def bottomRight: Point
        def left = topLeft.x
        def right = bottomRight.x
        def width = right - left
        // more geometric methods
      }

    So now we can extend Component and Rectangle with the trait:
      abstract class Component extends Rectangular {
        // other stuff
      }

      class Rectangle(val topLeft: Point, val bottomRight: Point) extends Rectangular {
        // other things
      }

    Now you can create a rectangle and call the trait methods:

      val rec = new Rectangle(new Point(1, 1), new Point(10, 10))
      rec.left > Int = 1
      rec.right > Int = 10
      rec.width > Int = 9
 */

/*
  12.4 The Ordered trait
    Primary role is to enrich a class with relational operation capabilities. The reason why its called ordered, from my interpretation,
    is because when you mix in the ordered trait, you have to implement the compare method, which gives you an integer that
    implies the order of the objects compared.
    Another thing you have to do when you mix in the trait is to provide the type of the class you're mixing in to:

      class Rational(n: Int, d: Int): Rational extends Ordered[Rational] {
        // Rational
        def compare(that: Rational): Int = {
          (this.numer * that.denom) - (this.denom * that.numer)
        }
      }

    What Ordered trait looks like under the hood in a nutshell:

      trait Ordered[T] {
        def compare(that: T):Int
        def <(that: T): Boolean = (this compare that) < 0
        def >(that: T): Boolean = (this compare that) > 0
        def <=(that: T): Boolean = (this compare that) <= 0
        def >=(that: T): Boolean = (this compare that) >= 0
      }

 */

/*
  12.5 Traits as stackable modifications
    Traits can modify the methods of a class and be stacked together.
    Consider the example of a queue with two operations put and get that can insert an integer and remove an integer
    and return it respectively. We can implement traits to perform modifications such as Doubling, Incrementing, and Filtering.
    They are stackable because you can choose any one of them, or all three, and mix them into a class.

 */
//Example:


abstract class IntQueue {
  def put(x: Int): Unit
  def get(): Int
}

class BasicQueue extends IntQueue {
  private val buf = new ArrayBuffer[Int]()
  override def put(x: Int): Unit = buf += x

  override def get(): Int = buf.remove(0)
}

trait Doubling extends IntQueue {
  abstract override def put(x: Int): Unit = super.put(x * 2)
}

trait Incrementing extends IntQueue {
  abstract override def put(x: Int): Unit = super.put(x + 1)
}

trait Filtering extends IntQueue {
  abstract override def put(x: Int): Unit = {
    if (x >= 0) super.put(x)
  }
}

/*
  12.6 Why not multiple inheritance?
    This section talks about linearization of mixing in multiple traits and how that affects super.
 */

/*
  12.7 To trait or not to trait
    If behavior will not be reused, make it into concrete class.
    If it might be reused in multiple, unrelated classes, make it into trait.
    If you want to inherit from it in Java use abstract class.
 */
