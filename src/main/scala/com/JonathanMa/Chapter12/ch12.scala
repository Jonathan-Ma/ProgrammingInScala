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