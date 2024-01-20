package com.JonathanMa.Chapter14
/*
  Chapter 14: Assertions an Tests
    Assertions are written as calls of a predefined method assert. You can use one argument in the form
    of assert(condition) or two arguments - assert(condition, explanation).
 */
object Chapter14{
  def addPos(x: Int, y:Int): Int = {

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
    We'll start with ScalaTest.
 */

