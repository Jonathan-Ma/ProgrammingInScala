package com.JonathanMa.Chapter04
object Param{
  def param(): Unit = {
    val greetStrings: Array[String] = new Array[String](3)
    greetStrings(0) = "Hello"
    greetStrings(1) = ", "
    greetStrings(2) = "world!\n"

    for (i <- 0 to 2)
      print(greetStrings(i))
  }
}

