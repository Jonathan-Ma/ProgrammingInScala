import com.JonathanMa.Chapter05
import com.JonathanMa.Chapter02.Ch02
import com.JonathanMa.Chapter06.Rational
import com.JonathanMa.Chapter07.chapter7._
import com.JonathanMa.Chapter05
import com.JonathanMa.Chapter09._
import com.JonathanMa.Chapter10.Element2.elem
import com.JonathanMa.Chapter10._
import com.JonathanMa.Chapter12._
import com.JonathanMa.Chapter14._
import com.JonathanMa.Chapter15.Chapter15.BinOp
import com.JonathanMa.Chapter15._

object main {

  def main(args: Array[String]): Unit = {
    /* Chapter6 codes
    //new Rational(1, 0) // this will fail because denominator is 0, the 'require' method will prevent oject being constructed
    //Ch02.Hello()
    val rational1 = new Rational(5, 8)
    val rational2 = new Rational(3, 8)
    val rational3 = new Rational(9)
    val rational4 = new Rational(64, 128)
    val integer = 4
    println(rational1 + " + " + rational2 + " = " + (rational1 + rational2))// Making class parameters as fields allows you to use their parameter value outside of the class

    println("Is " + rational1 + " less than " + rational2 + " ? " + (rational1 lessThan rational2))
    println("The greater one of the two rational is: " + (rational1 max rational2))// You can leave out "this" at times

    println("Whole number " + rational3.n + " is equal to " + rational3) // This showcases the result of an auxiliary constructor
    println("The factored version of 64/128 is: " + rational4)// result of using a private val and method
    println("Rational " + rational4 + " + " + integer + " = " + (rational4+integer))
     */

    /*
      Ch14 Assertion
     */
    //println(Chapter14.addPos(-1, 2))
    // AssertionError thrown with explanation
    //println(Chapter14.addToPos(-1, 0)) // prints [error] java.lang.AssertionError: assertion failed: Must add up to be over 0


//    object Spiral {
//      val space = elem(" ")
//      val corner = elem("+")
//
//      def spiral(nEdges: Int, direction: Int): Element2 = {
//        if (nEdges == 1)
//          elem("+")
//        else {
//          val sp = spiral(nEdges - 1, (direction + 3) % 4)
//
//          def verticalBar = elem('|', 1, sp.height)
//
//          def horizontalBar = elem('-', sp.width, 1)
//
//          if (direction == 0)
//            (corner beside horizontalBar) above (sp beside space)
//          else if (direction == 1)
//            (sp above space) beside (corner above verticalBar)
//          else if (direction == 2)
//            (space beside sp) above (horizontalBar beside corner)
//          else
//            (verticalBar above corner) beside (space above sp)
//        }
//      }
//    }
//
//    val nSides = args(0).toInt
//    println(Spiral.spiral(nSides, 1))
    class MyQueue extends BasicQueue with Doubling
    val myQueue = new MyQueue
    myQueue.put(10)
    println(myQueue.get()) // prints 20 as expected

    val queue = new BasicQueue with Filtering with Incrementing
    queue.put(-1)
    println(queue.get()) // Prints 0

    println(Chapter15.binOp.left == Chapter15.Number(2))// prints true

    println(s"simplifyTop: ${Chapter15.simplifyTop(BinOp("*", Chapter15.Number(0), Chapter15.Number(10)))}")
  }
}
