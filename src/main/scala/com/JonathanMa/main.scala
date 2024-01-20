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

  }
}
