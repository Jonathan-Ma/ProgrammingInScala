/*
  11 Scala's Hierarchy
    All classes inherits from Any class which contains methods like
      final def ==(that: Any): Boolean
      final def !=(that: Any): Boolean
      def equals(that: Any): Boolean
      def ##: Int
      def hashCode: Int
      def toString: String
    Because every class inherits from Any, every object in Scala program can be compared using
    ==, !=, or equals; hashed, and formatted using toString.

    Root Any class has two subclass, AnyVal and AnyRef. AnyVal is the parent class of value classes
    There are nine value classes built into Scala: Byte, Short, Int, Long, Float, Double, Boolean, and Unit.


*/

/*
  11.2 How primitives are implemented
    Using integers as an example, they are stored as 32 bit values. This way of storing is different from
    objects in memory because there is less overhead.

    Auto-boxing is done automatically using Java wrappers when needed (when you need to use it like
    an object).

*/

/*
  11.3 Bottom types
    Null and Nothing are at the bottom of the type hierarchy to handle "corner cases".

    Null cannot be used with AnyVal types, for example, you can't assign Null value to an integer.

    Nothing is at the very bottom of everything, its a subtype of every other type. However, there exist no values of
    this type.

 */

/*
  11.4 Defining your own value classes
    Value classes must extend AnyVal and have one parameter with val before that param. Additionally, they can only have defs
    inside the class, no other classes can extend value classes. Lastly, they cannot redefine equals and hashCode.

  Avoiding a types monoculture
    Suppose you are writing some code to generate HTML:

      def title(text: String, anchor: String, style: String): String =
        s"<a id='$anchor'><h1 class='$style'>$text</h1></a>"

    When you fill in the arguments in the wrong order, the compiler will not complain, so:

      title("chap:vcls", "bold", "Value Classes")

    will give you:

      String = <a id='bold'><h1 class='Value Classes'>chap:vcls</h1></a>

    This is mangled HTML because Value Classes is supposed to be the actual text which is supposed to be the first
    argument. "bold" is supposed to be a style class which is the third argument, and chap:vcls is the anchor but displayed
    as text.

    The compiler can be more helpful if you define a tiny type for each domain concept. For example you can define
    a small class for styles, anchor, text, and text. And since these classes only have one parameter, then they can be
    defined as value classes.

      class Anchor(val value: String) extends AnyVal
      class Text(val value: String) extends AnyVal
      class Style(val value: String) extends AnyVal
      class HTML(val value: String) extends AnyVal
    Given these value classes, we can write a version of title that has a more trivial signature:
      def title(text: Text, anchor: Anchor, style: Style): String = {
        s"<a id='$anchor'><h1 class='$style'>$text</h1></a>"
      }

    If you try to use this version with the arguments in the wrong order, the compiler can now detect
    the error. For example:

      scala> title(new Anchor("chap:vcls"), new Style("bold"),
        new Text("Value Classes"))

    You will get errors here from the compiler because they are in the wrong order.

 */
