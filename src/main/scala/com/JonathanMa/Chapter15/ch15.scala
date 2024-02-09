package com.JonathanMa.Chapter15
/*
    Chapter 15: Case classes and pattern matching
      Case classes are Scala's way to allow you pattern matching on objects without requiring large amounts of boilerplate.
 */
// simple example
object Chapter15 {
  abstract class Expr
  case class Var(name: String) extends Expr
  case class Number(num: Int) extends Expr
  case class UnOp(operator: String, arg: Expr) extends Expr
  case class BinOp(operator: String, left: Expr, right: Expr) extends Expr

  /*
  By adding case modifier, the compiler will add syntactic convenience to the class.
  1. It adds a factory method with the name of the class so you don't need "new"
  2. All arguments of a case class implicitly gets a val prefix
  3. Compiler adds "natural" implementations of methods toString, hashCode, and equals.
  4. Finally, the compiler adds a copy method to your class. For any parameter you don't specify, it will remain the same.
 */

  // example for 1, no need to use "new"
  var binOp = BinOp("+", Number(2), Var("Hello"))

  // example for 2, val are added as prefixes implicitly
  // println(binOp.operator) prints "x"

  // example for 3, equals compares structural
  // binOp.left == Number(2) is true

  // number 4 we can copy the class and specify which parameter we want to change
  // val op = binOp.copy(operator = "-") this copies binOp but changes operator to "-"

  /*
    Pattern matching
      Say we have three arithmetic rules as an illustration:
        UnOp("-", UnOp("-", e)) => e
        BinOp("+", e, Number(0)) => e
        BinOp("*", e, Number(1)) => e
      Using pattern matching, these rules can be taken almost as they are to form the core of a simplification function in
      Scala.
   */

  // Ex of simplifyTop
  def simplifyTop(expr: Expr): Any = expr match {
    case UnOp("-", UnOp("-", e)) => e
    case BinOp("+", e, Number(0)) => e
    case BinOp("*", e, Number(1)) => e
    case BinOp("*", Number(0), _) => 0: Int
    case _ => expr
  }

  /*
    15.2 Kinds of patterns

      Wildcard pattern: (_) like the last case in simplifyTop matches anything. It can also be used to ignore parts of an object
      that you do not care about like the third case, where we dont care what the right operand is.

      Constant patterns: A constant pattern only matches itself. Any literal may be used as a constant.
        def describe(x: Any) = x match {
          case 5 => "five"
          case true => "truth"
          case _ =>
        }

      Variable patterns: A variable matches any object like a wildcard except it binds to the object.
        expr match {
          case 0 => "zero"
          case somethingElse => "not zero: " + somethingElse
        }
      somethingElse can be used in the expression.

      Lowercase and capital separates constant and variable!!! a lowercase case will be used as a variable and won't even
      let you add a default case because variable will match all cases. If you want constant then use back ticks or capital.

      Sequence patterns: you can match against sequence types like List and Arrays.
        expr match {
          case List(0, _, _)
        }
      This shows a pattern that checks for a three-element list starting with 0. If you want to match a list without specifying
      how long it can be, you can use _*, the following matches a list that starts with 0 with any length:
        expr match {
          case List(0, _*)
        }

      Tuple pattern:
        def tup(expr: Any) =
          expr match {
            case (a, b, c) => println("matched" + a + b + c)
          }

      Typed pattern: The generalSize method below takes an argument of any type. s is a typed pattern, it matches any non-null instance
      of String.
        def generalSize(x: Any) =
          expr match {
            case s: String => s.length
            case m: Map[_, _] => m.size
            case _ => -1
          }
      The second case matches any value that is a Map of some arbitrary key and value.

      Scala uses erasure, this means no information about the type argument is maintained at runtime. The only exception is Arrays
      because they are handled specially in Java and Scala. The element type is stored with the array value.

      Variable bindings: A variable-binding pattern is a pattern where you put a "@" between the pattern you're looking for and
      the variable you want to bind to it.
        expr match {
          case Unop("abs", e @ (UnOp("abs", _)) => e
        }
      The example above is essentially looking for pattern Unop("abs", (UnOp("abs", _)), if there is a match then (UnOp("abs", _) is
      bound to e.
   */

  // Sum of section 15.2 in some example code
  def patterns(x: Any) = x match {
    case 5 => "five"
    case _: Int => "Number"
    case c @ UnOp("+", e) =>
    case p @ List(1, _*) => println(p)
    case (a, b ,c) => println("matched" + a + b + c)
    case variable => variable
  }
  // case 1 illustrates a constant
  // case 2 is a wildcard with a type int
  // case 3 constructor pattern with a variable-binding pattern
  // case 4 is an example of sequence pattern as well as a variable binding, it matches a list that starts with 1 and followed by
  //        0 or more elements
  // case 5 is a tuple pattern
  // case 6 is a variable that catches all

  /*
  15.3 Pattern guard
    A pattern guard comes after a pattern and starts with an if. The pattern matches only if the guard is true.
      def guard(expr: Expr): Any = expr match {
        case BinOp("+", x, y) if y == x => BinOp("*", x, Number(2))
        case _ =>
      }
    The example above matches the case only if x == y
   */

  /*
    15.4 Pattern overlaps
      Basically order matters significantly so don't put catch-all on the top.
   */

  /*
    15.5 Sealed classes
      Sealing a class is to ensure that when you pattern match, you don't miss out any cases. Sealed classes also prevent you from
      adding new subclasses.
   */
  sealed abstract class Expr2
  case class Var2(name: String) extends Expr2
  case class Number2(num: Double) extends Expr2
  case class UnOp2(operator: String, arg: Expr2) extends Expr2
  case class BinOp2(operator: String,
                   left: Expr, right: Expr) extends Expr2

  def describe(e: Expr2): String = e match {
    case Number2(_) => "a number"
    case Var(_) => "variable"
  }

  /*
    compiler here will complain warning: match is not exhaustive!
    missing combination UnOp
    missing combination BinOp

    If you want this to go away then use @unchecked annotation like so:
      def describe(e: Expr): String = (e: @unchecked) match {
        case Number(_) => "a number"
        case Var(_) => "a variable"
      }
    This will suppress the exhaustivity check.
   */

  /*
      15.6 The Option type
        The Option type is a safer and more explicit alternative to "null" for optional values. It is particularly useful
        in operations like "Map.get" which returns "Option" to safely handle the presence or absence of a key. Pattern matching with
        Option prevents runtime errors like "NullPointerException".
   */

  def show(x: Option[String]): String = x match {
    case Some(s) => s
    case None => "?"
  }

  /*
    15.7 Patterns everywhere
      Patterns in variable definitions
        Patterns can be in variable definitions not just match expressions.
          val myTuple = (123, "abc")
          val (number, string) = myTuple
        This is called destructuring, it is essentially using pattern matching to "unpack" or destructuring the tuple by creating two
        new variables number and string, then it extracts corresponding elements and assigns them to the new variables.

      Case sequences as partial functions
        Case sequences can be function literals providing multiple entry points, each with there own list of parameters.
        Each case is an entry point to the function and the parameters are the pattern of the case:
          def withDefault: Option[Int] => Int = {
            case Some(x) => x
            case None => 0
          }
        withDefault(Some(10)) returns 10

        It is essential to note that a sequence of cases creates a partial function. If you apply such a function to a value
        that it does not support then there will be a runtime error.
          def second:(List[Int]) => Int = {
            case x :: y :: _ => y
          }
        this will work with a list with 3 elements but not an empty one and will throw an warning at compile and error at runtime
        if list is not the right size.
   */

}
