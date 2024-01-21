package com.JonathanMa.Chapter14
/*
  Chapter 14: Assertions an Tests
    Assertions are written as calls of a predefined method assert. You can use one argument in the form
    of assert(condition) or two arguments - assert(condition, explanation).
 */
object Chapter14{
  def addPos(x: Int, y:Int): Int = {
    assert(x > 0 && y > 0, "Must be positive numbers")
    x + y
  }

  /*
    Ensuring is basically assert but it is called after a evaluation.
   */
  def addToPos(x: Int, y:Int): Unit = {
    (x + y).ensuring(x+y > 0, "Must add up to be over 0")
  }
}

/*
  14.2 Testing in Scala
    There are many options to test in Scala from established Java tools such as JUnit and TestNG to tools written in
    Scala, such as ScalaTest, specs2, and ScalaCheck.
 */

/*
  14.3 Informative failure reports
    We can get more descriptive error messages using Diagrams trait. If you wish to emphasize the distinction between actual and expected,
    you can use assertResult method.

    We can also check to see if the exceptions thrown is as expected with assertThrows[what you expect].
 */

/*
  14.4 Tests as specifications

 */